package beans;

import entity.Admin;
import services.AdminService;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name = "TryToLogin", eager = true)
@SessionScoped
public class TryToLogin extends  Admin{




    AdminService adminService;

    public Boolean getRemember() {
        return remember;
    }

    public void setRemember(Boolean remember) {
        this.remember = remember;
    }

    private Boolean remember;


    public TryToLogin() {
    }

    @PostConstruct
    public void onCreate() {
        adminService = new AdminService();

    }



    public String tryToLogin() {
        Admin foundAdmin = adminService.findbyLoginPassword(getLogin(),getPassword());
        return foundAdmin != null ? "fields.xhtml" : "401.xhtml";
    }

    public String singUp() {
        return  "singUp.jsf" ;
    }


}
