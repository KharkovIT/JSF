package dao.postgreSQL;

import dao.AdminDAO;
import entity.Admin;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;


import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO<Admin> {
    private Session currentSession;
    private Transaction currentTransaction;

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    public AdminDAOImpl() {
    }

    public Session openCurrentSession() {
        currentSession = sessionFactory.openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = sessionFactory.openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }


    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(Admin entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public void update(Admin entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    public Admin findById(int id) {
        Admin book = (Admin) getCurrentSession().get(Admin.class, id);
        return book;
    }

    public void delete(Admin entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Admin> findAll() {
        List<Admin> books = (List<Admin>) getCurrentSession().createQuery("FROM Admin ").list();
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
        Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
        Query query = sessionFactory.getCurrentSession().createQuery("from Admin where login = :login and password = :password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        try {
            Admin returnedAdmin = (Admin) query.getSingleResult();
            tx.commit();
            return returnedAdmin;
        }catch (NoResultException ex){
            tx.commit();
            return null;
        }
    }
}
