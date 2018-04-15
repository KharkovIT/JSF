package beans;

import entity.Admin;
import services.AdminService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Map;


@ManagedBean(name = "TryToLogin", eager = true)
@SessionScoped
public class TryToLogin extends Admin {

    private AdminService adminService;


    private FacesContext context;
    private Map<String, Object> requestMap;

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
        Admin foundAdmin = adminService.findbyLoginPassword(getEmail(), getPassword());
        if (foundAdmin != null) {
            context = FacesContext.getCurrentInstance();
            requestMap = context.getExternalContext().getSessionMap();
            requestMap.put("user", foundAdmin);
            return "admin/fields.xhtml";
        } else {
            return "errors/401.xhtml";
        }
    }

    public String singUp() {
        return "singUp.jsf";
    }


}
