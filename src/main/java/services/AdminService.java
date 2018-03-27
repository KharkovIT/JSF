package services;

import dao.postgreSQL.AdminDAOImpl;
import entity.Admin;

import java.util.List;

public class AdminService {
    private static AdminDAOImpl adminDAO;

    public AdminService() {
        adminDAO = new AdminDAOImpl();
    }

    public void persist(Admin entity) {
        adminDAO.openCurrentSessionwithTransaction();
        adminDAO.persist(entity);
        adminDAO.closeCurrentSessionwithTransaction();
    }

    public void update(Admin entity) {
        adminDAO.openCurrentSessionwithTransaction();
        adminDAO.update(entity);
        adminDAO.closeCurrentSessionwithTransaction();
    }

    public Admin findById(int id) {
        adminDAO.openCurrentSession();
        Admin admin = adminDAO.findById(id);
        adminDAO.closeCurrentSession();
        return admin;
    }

    public void delete(int id) {
        adminDAO.openCurrentSessionwithTransaction();
        Admin admin = adminDAO.findById(id);
        adminDAO.delete(admin);
        adminDAO.closeCurrentSessionwithTransaction();
    }

    public List<Admin> findAll() {
        adminDAO.openCurrentSession();
        List<Admin> admins = adminDAO.findAll();
        adminDAO.closeCurrentSession();
        return admins;
    }

    public void deleteAll() {
        adminDAO.openCurrentSessionwithTransaction();
        adminDAO.deleteAll();
        adminDAO.closeCurrentSessionwithTransaction();
    }
    public Admin findbyLoginPassword(String login, String password) {
        adminDAO.openCurrentSession();
        Admin admin = adminDAO.findByLoginAndPassword(login,password );
        adminDAO.closeCurrentSession();
        return admin;
    }
    public AdminDAOImpl AdminDAOImpl() {
        return adminDAO;
    }
}
