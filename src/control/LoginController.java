package control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Stack;

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
            List managerList = service.getMngrList();
            List roleList = service.getRoleList();
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("mlist",managerList);
            modelAndView.addObject("list",roleList);
            modelAndView.addObject("username",uname);
            modelAndView.setViewName("editRole");
            return modelAndView;
        }
        else{
            return new ModelAndView("err","message","You don't have the permissions.");
        }
    }

    @RequestMapping("/editM")
    public ModelAndView editMngr(HttpServletRequest request,HttpServletResponse response){
        String uname = request.getParameter("uname");
        Service service = new Service();
        boolean editMPermi = service.checkPermi(uname,"editM");
        if(editMPermi){
            List managerList = service.getMngrList();
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("mlist",managerList);
            modelAndView.addObject("username",uname);
            modelAndView.setViewName("editManager");
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

    @RequestMapping("/addManager")
    public ModelAndView addMngr(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        String mname = request.getParameter("manager_name");
        String uname = request.getParameter("uname");
        Service service = new Service();
        service.addMngr(username, mname);
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

    @RequestMapping("/delManager")
    public ModelAndView delMngr(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        String mname = request.getParameter("manager_name");
        String uname = request.getParameter("uname");
        Service service = new Service();
        service.delMngr(username, mname);
        return new ModelAndView("welcome","username",uname);
    }

    @RequestMapping("/sub")
    public ModelAndView viewSub(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("uname");
        String manager = request.getParameter("manager");
        Service service = new Service();
        Stack<String> subList = service.getSubList(manager);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("manager",manager);
        modelAndView.addObject("username",username);
        modelAndView.addObject("subList",subList);
        modelAndView.setViewName("viewSub");
        return modelAndView;
    }
}
