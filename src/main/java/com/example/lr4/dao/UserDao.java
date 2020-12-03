package com.example.lr4.dao;

import com.example.lr4.models.Users;
import com.example.lr4.models.Messages;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.lr4.util.HibernateSessionFactoryUtil;
import java.util.List;


public class UserDao {

    public Users findUserById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Users.class, id);
    }

    public void save(Users user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(Users user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(Users user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public Messages findMessageById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Messages.class, id);
    }

    public List<Users> findAll() {
        List<Users> users = (List<Users>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }

}
