package control;

/**
 * Created by Pulkit.singh on 1/13/2015.
 */

import model.*;

public class Service {

    public boolean authenticateService(String username,String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        UserDao userDao = new UserDao();
        return  userDao.authenticate(user);
    }

    public boolean registerService(String username,String password,String name){
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        user.setName(name);

        UserDao userDao = new UserDao();
        boolean status = userDao.authenticateUser(user);
        if (!status){
            userDao.makeEntry(user);
            return true;
        }
        else
            return false;
    }
}