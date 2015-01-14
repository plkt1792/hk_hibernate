package control;

/**
 * Created by Pulkit.singh on 1/13/2015.
 */

import model.*;

import java.util.List;

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

    public List getEmpList(){
        UserDao userDao = new UserDao();
        return userDao.getUsersList();
    }

    public List getRoleList(){
        UserDao userDao = new UserDao();
        return userDao.getRolesList();
    }

    public boolean checkPermi(String username,String permi){
        User user = new User();
        user.setUsername(username);
        UserDao userDao = new UserDao();
        return userDao.checkPermi(user, permi);
    }

    public void delEmp(String username){
        User user = new User();
        user.setUsername(username);
        UserDao userDao = new UserDao();
        userDao.delUser(user);
    }

    public void delRole(String username,String rolename){
        Role role = new Role();
        role.setRolename(rolename);
        role.setUsername(username);
        UserDao userDao = new UserDao();
        userDao.delRole(role);
    }

    public void addRole(String username,String rolename){
        Role role = new Role();
        role.setRolename(rolename);
        role.setUsername(username);
        UserDao userDao = new UserDao();
        userDao.addRole(role);
    }
}
