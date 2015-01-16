package model;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


import javax.management.Query;
import java.util.*;

/**
 * Created by Pulkit.singh on 1/12/2015.
 */
public class UserDao {
    public boolean authenticate(User u) {

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Criteria cr = session.createCriteria(User.class);
        cr.setProjection(Projections.property("username"));
        cr.setProjection(Projections.property("password"));
        cr.add(Restrictions.eq("username", u.getUsername()));
        cr.add(Restrictions.eq("password",u.getPassword()));
        List list = cr.list();
        session.close();
        if (list.isEmpty())
            return false;
        else
            return true;
    }

    public boolean authenticateUser(User u) {

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Criteria cr = session.createCriteria(User.class);
        cr.setProjection(Projections.property("username"));
        cr.add(Restrictions.eq("username",u.getUsername()));
        List list = cr.list();
        session.close();
        if (list.isEmpty())
            return false;
        else
            return true;
    }

    public void makeEntry(User u) {

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.persist(u);
        t.commit();
        session.close();
    }

    public void addRole(Role role){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.persist(role);
        t.commit();
        session.close();
    }

    public void addMg(User user){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "update User set manager ='"+user.getManager()+"' where username ='"+user.getUsername()+"'";
        org.hibernate.Query query = session.createQuery(hql);
        query.executeUpdate();
        t.commit();
        session.close();
    }

    public List<User> getUsersList(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Criteria cr = session.createCriteria(User.class);
        List<User> userList = new ArrayList<User>();
        userList = cr.list();
        return userList;
    }

    public List getRolesList(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Criteria cr = session.createCriteria(Role.class);
        cr.add(Restrictions.ne("username","admin"));
        return cr.list();
    }

    public void delUser(User user){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "Delete from User where username = '"+user.getUsername()+"'";
        org.hibernate.Query query = session.createQuery(hql);
        query.executeUpdate();
        t.commit();
        session.close();
    }

    public void delRole(Role role){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "Delete from Role where username = '"+role.getUsername()+"' and rolename = '"+role.getRolename()+"'";
        org.hibernate.Query query = session.createQuery(hql);
        query.executeUpdate();
        t.commit();
        session.close();
    }

    public void delMg(User user){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "update User set manager ="+null+" where username ='"+user.getUsername()+"'";
        org.hibernate.Query query = session.createQuery(hql);
        query.executeUpdate();
        t.commit();
        session.close();
    }

    public boolean checkPermi(User user,String permission){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        String hql = "Select P.permission from Permission P,Role R where P.rolename = R.rolename and R.username='"+user.getUsername()+"' and P.permission='"+permission+"'";
        org.hibernate.Query query = session.createQuery(hql);
        List pList = query.list();
        if(pList.isEmpty()){
            return false;
        }
        return true;
    }

    public Stack<String> getSList(String manager){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Criteria cr = session.createCriteria(User.class);
        List temp = cr.list();
        HashMap<String,String> e_m = new HashMap<String, String>();
        for (Iterator it =temp.iterator(); it.hasNext();){
            User user = (User) it.next();
            String uname = user.getUsername();
            String mname = user.getManager();
            if(mname==null)
                mname="X";
            e_m.put(uname,mname);
        }



        Stack<String> result = new Stack<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(manager);
        while (!queue.isEmpty()){
            String mngr = queue.remove();
            Set set = e_m.entrySet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                Map.Entry me = (Map.Entry) it.next();
                String uname = (String) me.getKey();
                String mname = (String) me.getValue();
                if(mname.equals(mngr)){
                    queue.add(uname);
                    result.push(uname);
                }
            }
        }
        return result;
    }
}