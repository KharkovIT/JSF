package services;

import dao.postgreSQL.AdminDAOImpl;
import entity.Admin;
import hibernate.HibernateMethods;
import utils.Encoder;

import java.util.List;

public class AdminService {
    private static AdminDAOImpl adminDAO;
    private HibernateMethods hibernateMethods;

    public AdminService() {
        adminDAO = new AdminDAOImpl();
        hibernateMethods = new HibernateMethods();
    }

    public void persist(Admin entity) {
        adminDAO.hibernateMethods.openCurrentSessionwithTransaction();
        adminDAO.persist(entity);
        adminDAO.hibernateMethods.closeCurrentSessionwithTransaction();
    }

    public void update(Admin entity) {
        adminDAO.hibernateMethods.openCurrentSessionwithTransaction();
        adminDAO.update(entity);
        adminDAO.hibernateMethods.closeCurrentSessionwithTransaction();
    }

    public Admin findById(int id) {
        adminDAO.hibernateMethods.openCurrentSession();
        Admin admin = adminDAO.findById(id);
        adminDAO.hibernateMethods.closeCurrentSession();
        return admin;
    }

    public void delete(int id) {
        adminDAO.hibernateMethods.openCurrentSessionwithTransaction();
        Admin admin = adminDAO.findById(id);
        adminDAO.delete(admin);
        adminDAO.hibernateMethods.closeCurrentSessionwithTransaction();
    }

    public List<Admin> findAll() {
        adminDAO.hibernateMethods.openCurrentSession();
        List<Admin> admins = adminDAO.findAll();
        adminDAO.hibernateMethods.closeCurrentSession();
        return admins;
    }

    public void deleteAll() {
        adminDAO.hibernateMethods.openCurrentSessionwithTransaction();
        adminDAO.deleteAll();
        adminDAO.hibernateMethods.closeCurrentSessionwithTransaction();
    }

    public Admin findbyLoginPassword(String login, String password) {
        adminDAO.hibernateMethods.openCurrentSession();
        Admin admin = adminDAO.findByLoginAndPassword(login, Encoder.encode(password));
        adminDAO.hibernateMethods.closeCurrentSession();
        return admin;
    }

    public AdminDAOImpl AdminDAOImpl() {
        return adminDAO;
    }
}
