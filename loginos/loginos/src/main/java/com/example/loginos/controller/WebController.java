package com.example.loginos.controller;

import com.example.loginos.model.User;
import com.example.loginos.model.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class WebController {

    @GetMapping("/")
    public String loadIndex(HttpSession session) {
        session.setAttribute("displayerror", "none");
        return "index.jsp";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
        if(!email.isEmpty() || !password.isEmpty())
        {
            User u = UserRepository.getInstance().findUserByEmail(email);
            String passwordHash = DigestUtils.md2Hex(password);
            if(u.getPasswordHash().equals(passwordHash))
            {
                u.incraseLoginNumber();
                session.setAttribute("user", u);
                return "main.jsp";
            }
            else {
                return "redirect:/invalid.html";
            }
        }
        else {
            return "redirect:/invalid.html";
        }
    }

    @PostMapping("/register")
    public String registerNewUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session)
    {
        if(!email.isEmpty() || !password.isEmpty()) {
            if(UserRepository.getInstance().findUserByEmail(email) == null)
            {
                User u = new User(email, DigestUtils.md2Hex(password));
                u.incraseLoginNumber();
                UserRepository.getInstance().addUser(u);
                session.setAttribute("user", u);
            }
            else {
                session.setAttribute("displayerror", "block");
                return "register.jsp";
            }
        }
        return "main.jsp";
    }
}
