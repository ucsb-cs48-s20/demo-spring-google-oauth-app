package edu.ucsb.cs56.w20.lab07.controllers;

import edu.ucsb.cs56.w20.lab07.repositories.AppUserRepository;
import edu.ucsb.cs56.w20.lab07.services.MembershipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppUsersController {

    private Logger logger = LoggerFactory.getLogger(AppUsersController.class);

    @Autowired
    private MembershipService ms;

    private AppUserRepository appUserRepository;

    @Autowired
    public AppUsersController(AppUserRepository repo) {
        this.appUserRepository = repo;
    }

    @GetMapping("/users")
    public String users(Model model, OAuth2AuthenticationToken token,
            RedirectAttributes redirAttrs) {
        String role = ms.role(token);
        if (!role.equals("Admin")) {
            redirAttrs.addFlashAttribute("alertDanger",
                    "You do not have permission to access that page");
            return "redirect:/";
        }
        model.addAttribute("users", appUserRepository.findAll());
        return "users/index";
    }

    /*
    @PostMapping("/admin/delete/{id}")
    public String deleteAdmin(@PathVariable("id") long id, Model model,
            RedirectAttributes redirAttrs, OAuth2AuthenticationToken token) {
        String role = ms.role(token);
        if (!role.equals("Admin")) {
            redirAttrs.addFlashAttribute("alertDanger",
                    "You do not have permission to access that page");
            return "redirect:/";
        }

        Optional<Admin> admin = appUserRepository.findById(id);
        if (!admin.isPresent()) {
            redirAttrs.addFlashAttribute("alertDanger", "Admin with that id does not exist.");
        } else {
            String email = admin.get().getEmail();
            if (ms.getAdminEmails().contains(email)) {
                redirAttrs.addFlashAttribute("alertDanger", "Admin " + email + " was set from application properties and cannot be deleted.");
            } else {
                appUserRepository.delete(admin.get());
                redirAttrs.addFlashAttribute("alertSuccess", "Admin successfully deleted.");
            }
        }
        model.addAttribute("newAdmin", new Admin());
        model.addAttribute("admins", appUserRepository.findAll());
        return "redirect:/admin";
    }

    @PostMapping("/admin/add")
    public String addAdmin(@Valid Admin admin, BindingResult result, Model model,
            RedirectAttributes redirAttrs, OAuth2AuthenticationToken token) {
        String role = ms.role(token);
        if (!role.equals("Admin")) {
            redirAttrs.addFlashAttribute("alertDanger",
                    "You do not have permission to access that page");
            return "redirect:/";
        }

        boolean errors = false;
        if (!ValidEmailService.validEmail(admin.getEmail())) {
            errors = true;
            redirAttrs.addFlashAttribute("alertDanger", "Invalid email.");
        }
        List<Admin> alreadyExistingAdmins = appUserRepository.findByEmail(admin.getEmail());
        if (!alreadyExistingAdmins.isEmpty()) {
            errors = true;
            redirAttrs.addFlashAttribute("alertDanger", "An admin with that email already exists.");
        }
        if (!errors) {
            appUserRepository.save(admin);
            model.addAttribute("newAdmin", new Admin());
        } else {
            model.addAttribute("newAdmin", admin);
        }
        model.addAttribute("admins", appUserRepository.findAll());
        return "redirect:/admin";
    }

    private void addAdminsFromPropertiesFile() {
        ms.getAdminEmails().forEach((email) -> {
            if (appUserRepository.findByEmail(email).isEmpty()) {
                appUserRepository.save(new Admin(email, true));
            }
        });
    }
    */
}
