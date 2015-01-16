package control;

import model.User;
import netscape.javascript.JSObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Pulkit.singh on 1/16/2015.
 */


@RestController
@RequestMapping("/service/user")
public class SpringServiceController {
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String getGreeting(@PathVariable String name) {
        String result="Hello "+name;
        return result;
    }
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<User> getAllUsers() {
       Service service = new Service();
       List<User> users=service.getEmpList();
       return users;
    }
}
