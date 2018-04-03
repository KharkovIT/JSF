package dao.postgreSQL;

import dao.AdminDAO;
import entity.Admin;
import hibernate.HibernateMethods;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;


import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO<Admin> {

    public HibernateMethods hibernateMethods;

    public AdminDAOImpl() {
        hibernateMethods = new HibernateMethods();
    }

    public void persist(Admin entity) {
        hibernateMethods.sessionFactory.getCurrentSession().save(entity);
    }

    public void update(Admin entity) {
        hibernateMethods.sessionFactory.getCurrentSession().update(entity);
    }

    public Admin findById(int id) {
        Admin book = (Admin) hibernateMethods.getCurrentSession().get(Admin.class, id);
        return book;
    }

    public void delete(Admin entity) {
        hibernateMethods.sessionFactory.getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Admin> findAll() {
        List<Admin> books = (List<Admin>) hibernateMethods.getCurrentSession().createQuery("FROM Admin ").list();
        return books;
    }

    public void deleteAll() {
        List<Admin> entityList = findAll();
        for (Admin entity : entityList) {
            delete(entity);
        }
    }

    @Override
    public Admin findByLoginAndPassword(String login, String password) {
        Transaction tx = hibernateMethods.sessionFactory.getCurrentSession().beginTransaction();
        Query query = hibernateMethods.sessionFactory.getCurrentSession().createQuery("from Admin where login = :login and password = :password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        try {
            Admin returnedAdmin = (Admin) query.getSingleResult();
            tx.commit();
            return returnedAdmin;
        } catch (NoResultException ex) {
            tx.commit();
            return null;
        }
    }
}
