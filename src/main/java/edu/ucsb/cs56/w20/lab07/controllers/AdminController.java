package edu.ucsb.cs56.w20.lab07.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.ucsb.cs56.w20.lab07.services.MembershipService;

@Controller
public class AdminController {

    @Autowired
    private MembershipService ms;

    @GetMapping("/admin")
    public String admin(OAuth2AuthenticationToken token, RedirectAttributes redirAttrs){
        String role = ms.role(token);

        if (! role.equals("Admin")) {
            redirAttrs.addFlashAttribute("alertDanger", "You do not have permission to access that page");
            return "redirect:/";
        }
        return "admin/create";
    }
}