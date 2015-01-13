package control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Pulkit.singh on 1/12/2015.
 */

@Controller
public class RegisterController {
    @RequestMapping("/register")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");

        Service service = new Service();
        boolean status = service.registerService(username,password,name);

        if (status) {
            return new ModelAndView("welcome", "username", username);
        } else {
            return new ModelAndView("err", "message", "User Already registered");
        }
    }
}

