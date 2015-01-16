package control;

/**
 * Created by Pulkit.singh on 1/13/2015.
 */

import model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Stack;

public class Service {

    public boolean authenticateService(String username,String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("udao");
        return  userDao.authenticate(user);
    }

    public boolean registerService(String username,String password,String name){
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        user.setName(name);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("udao");
        boolean status = userDao.authenticateUser(user);
        if (!status){
            userDao.makeEntry(user);
            return true;
        }
        else
            return false;
    }

    public List<User> getEmpList(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("udao");
        return userDao.getUsersList();
    }

    public List getRoleList(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("udao");
        return userDao.getRolesList();
    }

    public List getMngrList(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("udao");
        return userDao.getUsersList();
    }

    public boolean checkPermi(String username,String permi){
        User user = new User();
        user.setUsername(username);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("udao");
        return userDao.checkPermi(user, permi);
    }

    public void delEmp(String username){
        User user = new User();
        user.setUsername(username);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("udao");
        userDao.delUser(user);
    }

    public void delRole(String username,String rolename){
        Role role = new Role();
        role.setRolename(rolename);
        role.setUsername(username);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("udao");
        userDao.delRole(role);
    }

    public void delMngr(String username,String mname){
        User user = new User();
        user.setManager(mname);
        user.setUsername(username);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("udao");
        userDao.delMg(user);
    }

    public void addRole(String username,String rolename){
        Role role = new Role();
        role.setRolename(rolename);
        role.setUsername(username);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("udao");
        userDao.addRole(role);
    }

    public void addMngr(String username,String mname){
        User user = new User();
        user.setManager(mname);
        user.setUsername(username);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("udao");
        userDao.addMg(user);
    }

    public Stack<String> getSubList(String manager){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("udao");
        return userDao.getSList(manager);
    }
}
