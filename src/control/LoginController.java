package control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Pulkit.singh on 1/12/2015.
 */

@Controller
public class LoginController {
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Service service = new Service();
        boolean status = service.authenticateService(username,password);

        if(status){
            return new ModelAndView("welcome","username",username);
        }
        else{
            return new ModelAndView("err","message","Login failed, try again");
        }
    }

    @RequestMapping("/view")
    public ModelAndView view(HttpServletRequest request,HttpServletResponse response){
        String uname = request.getParameter("uname");
        Service service = new Service();
        boolean viewPerm = service.checkPermi(uname,"view");
        if (viewPerm) {
            List empList = service.getEmpList();
            return new ModelAndView("view", "list", empList);
        }
        else {
            return new ModelAndView("err","message","You don't have the permissions.");
        }
    }

    @RequestMapping("/delete")
    public ModelAndView delete(HttpServletRequest request,HttpServletResponse response){
        String uname = request.getParameter("uname");
        Service service = new Service();
        boolean delPerm = service.checkPermi(uname,"delete");
        if(delPerm) {
            return new ModelAndView("delete", "username", uname);
        }
        else{
            return new ModelAndView("err","message","You don't have the permissions.");
        }
    }

    @RequestMapping("/deleteEmp")
    public ModelAndView deleteEmp(HttpServletRequest request,HttpServletResponse response){
        String ename = request.getParameter("ename");
        String uname = request.getParameter("uname");
        Service service = new Service();
        service.delEmp(ename);
        return new ModelAndView("welcome","username",uname);
    }

    @RequestMapping("/edit")
    public ModelAndView edit(HttpServletRequest request,HttpServletResponse response){
        String uname = request.getParameter("uname");
        Service service = new Service();
        boolean editPermi = service.checkPermi(uname,"edit");
        if(editPermi){
            List roleList = service.getRoleList();
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("list",roleList);
            modelAndView.addObject("username",uname);
            modelAndView.setViewName("editRole");
            return modelAndView;
        }
        else{
            return new ModelAndView("err","message","You don't have the permissions.");
        }
    }

    @RequestMapping("/addRole")
    public ModelAndView addRole(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        String rolename = request.getParameter("rolename");
        String uname = request.getParameter("uname");
        Service service = new Service();
        service.addRole(username,rolename);
        return new ModelAndView("welcome","username",uname);
    }

    @RequestMapping("/delRole")
    public ModelAndView delRole(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        String rolename = request.getParameter("rolename");
        String uname = request.getParameter("uname");
        Service service = new Service();
        service.delRole(username,rolename);
        return new ModelAndView("welcome","username",uname);
    }
}
