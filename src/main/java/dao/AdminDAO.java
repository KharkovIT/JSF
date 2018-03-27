package dao;

import entity.Admin;

public interface AdminDAO<T> extends GenericDAO<Admin> {
    T findByLoginAndPassword(String login, String password);
}
