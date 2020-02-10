package edu.ucsb.cs56.w20.lab07.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidEmailService {
  public static boolean validEmail(String email) {
    if (email == null) {
      return false;
    }
    String regex = "^(.+)@(.+)$";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
  }
}