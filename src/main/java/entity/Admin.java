package entity;

import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admins", schema = "public")
public class Admin {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "firstName")
    private String firstName;


    @Column(name = "lastName")
    private String lastName;


    @Column(name = "login")
    private String login;


    @Column(name = "password")
    private String password;


    @Column(name = "phoneNumber")
    private String phoneNumber;

    public Admin() {

    }

    public int getId() {
        return id;
    }

    public Admin setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Admin setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Admin setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public Admin setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Admin setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Admin setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return id == admin.id &&
                Objects.equals(firstName, admin.firstName) &&
                Objects.equals(lastName, admin.lastName) &&
                Objects.equals(login, admin.login) &&
                Objects.equals(password, admin.password) &&
                Objects.equals(phoneNumber, admin.phoneNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, login, password, phoneNumber);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
