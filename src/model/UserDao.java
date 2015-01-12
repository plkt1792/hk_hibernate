package model;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;


import java.util.List;

/**
 * Created by Pulkit.singh on 1/12/2015.
 */
public class UserDao {
    public boolean authenticate(User u) {

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Criteria cr = session.createCriteria(User.class);
        System.out.print("hello");
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
}