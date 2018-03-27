package beans;

import entity.Admin;
import services.AdminService;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name = "TryToLogin")
@SessionScoped
public class TryToLogin extends  Admin{




    AdminService adminService;
    private Boolean remember;


    public TryToLogin() {
    }

    @PostConstruct
    public void onCreate() {
        adminService = new AdminService();

    }

    public Boolean getRemember() {
        return remember;
    }

    public String tryToLogin() {
        Admin foundAdmin = adminService.findbyLoginPassword(getLogin(),getPassword());
        return foundAdmin != null ? "fields.jsf" : "userNotFound.jsf";
    }


}
