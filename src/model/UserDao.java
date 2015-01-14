package model;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;


import javax.management.Query;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Pulkit.singh on 1/12/2015.
 */
public class UserDao {
    public boolean authenticate(User u) {

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Criteria cr = session.createCriteria(User.class);
        cr.add(Restrictions.eq("username",u.getUsername()));
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

    public List getUsersList(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Criteria cr = session.createCriteria(User.class);
        return cr.list();
    }

    public List getRolesList(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Criteria cr = session.createCriteria(Role.class);
        cr.add(Restrictions.ne("username","admin"));
        return cr.list();
    }

    public void delUser(User user){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Criteria cr = session.createCriteria(User.class);
        Transaction t = session.beginTransaction();
        String hql = "Delete from User where username = '"+user.getUsername()+"'";
        org.hibernate.Query query = session.createQuery(hql);
        query.executeUpdate();
        t.commit();
        session.close();
    }

    public void delRole(Role role){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Criteria cr = session.createCriteria(Role.class);
        Transaction t = session.beginTransaction();
        String hql = "Delete from Role where username = '"+role.getUsername()+"' and rolename = '"+role.getRolename()+"'";
        org.hibernate.Query query = session.createQuery(hql);
        query.executeUpdate();
        t.commit();
        session.close();
    }

    public boolean checkPermi(User user,String permission){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Criteria cr = session.createCriteria(Role.class);
        cr.add(Restrictions.eq("username",user.getUsername()));
        List rolesList = cr.list();
        for (Iterator it =rolesList.iterator(); it.hasNext();){
            Role role = (Role) it.next();
            Criteria crt = session.createCriteria(Permission.class);
            crt.add(Restrictions.eq("rolename",role.getRolename()));
            List permiList = crt.list();
            for (Iterator it2 =permiList.iterator(); it2.hasNext();){
                Permission perm = (Permission)it2.next();
                String permi = perm.getPermission();
                if(permi.equals(permission))
                    return true;
            }
        }
        return false;
    }
}