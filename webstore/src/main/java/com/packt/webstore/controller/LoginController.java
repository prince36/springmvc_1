package com.packt.webstore.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ja on 21.05.2017.
 */
public class LoginController {

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String errorlogin(Model model){
        model.addAttribute("error", "true");
        return "login";
    }

    @RequestMapping(value="/logout", method=RequestMethod.GET)
    public String logout(Model model) {
        return "login";
    }

}
