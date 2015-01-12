package control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
/**
 * Created by Pulkit.singh on 1/12/2015.
 */

@Controller
public class RegisterController {
    @RequestMapping("/register")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        UserDao udao = new UserDao();
        boolean status = udao.authenticateUser(user);
        if (status) {
            return new ModelAndView("err", "message", "User Already registered");
        } else {
            udao.makeEntry(user);
            return new ModelAndView("welcome", "username", user.getUsername());
        }
    }
}

