/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entityclass.Users;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import sessionbean.UsersFacadeLocal;

/**
 *
 * @author Nobita
 */
@Named(value = "usersMB")
@SessionScoped
public class UsersMB implements Serializable {        

    @Resource(name = "myData")
    private DataSource myData;

    @EJB
    private UsersFacadeLocal usersFacade;
    
    private Users users = new Users();
    Date today = new Date();
    
    private int u_id;
    private String u_account;
    private String u_password;
    private String u_name;
    private String u_address;
    private String u_email;
    private String u_phone;
    private Date u_addDate;
    private int u_permiss;
    private int u_status;    
    
    public UsersMB() {
    }    
    
    public UsersMB(int u_id, String u_account, String u_password, String u_name, String u_address, String u_email, String u_phone, Date u_addDate, int u_permiss, int u_status) {
        this.u_id = u_id;
        this.u_account = u_account;
        this.u_password = u_password;
        this.u_name = u_name;
        this.u_address = u_address;
        this.u_email = u_email;
        this.u_phone = u_phone;
        this.u_addDate = u_addDate;
        this.u_permiss = u_permiss;
        this.u_status = u_status;
    }    

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_account() {
        return u_account;
    }

    public void setU_account(String u_account) {
        this.u_account = u_account;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_address() {
        return u_address;
    }

    public void setU_address(String u_address) {
        this.u_address = u_address;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public String getU_phone() {
        return u_phone;
    }

    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }

    public Date getU_addDate() {
        return u_addDate;
    }

    public void setU_addDate(Date u_addDate) {
        this.u_addDate = u_addDate;
    }

    public int getU_permiss() {
        return u_permiss;
    }

    public void setU_permiss(int u_permiss) {
        this.u_permiss = u_permiss;
    }

    public int getU_status() {
        return u_status;
    }

    public void setU_status(int u_status) {
        this.u_status = u_status;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    
    public List<Users> allUsers() {
        return usersFacade.findAll();
    }
    
    public String md5(String str) {
        String result = "";
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(str.getBytes());
            BigInteger bigInteger = new BigInteger(1, digest.digest());
            result = bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public String login() {
        if(usersFacade.checkLogin(u_account, md5(u_password))) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            session.setAttribute("u_account", u_account);
            return "admin/user";
        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Nhập sai tên đăng nhập hoặc mật khẩu!"));
            return "index";
       }
    }
    
    public void logout() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        ec.redirect(ec.getRequestContextPath() + "/faces/index.xhtml");
    }

    public void resetInsert() {
        this.u_account = "";
        this.u_password = "";
        this.u_name = "";
        this.u_address = "";
        this.u_email = "";
        this.u_phone = "";
    }
    
    public String insetUser() {        
        users.setUAccount(u_account);
        users.setUPassword(md5(u_password));
        users.setUName(u_name);
        users.setUAddress(u_address);
        users.setUPermiss(2);
        users.setUStatus(1);
        users.setUAdddate(today);
        users.setUEmail(u_email);
        users.setUPhone(u_phone);
        usersFacade.create(users);
        return "user";
    }
    
    public String showPer(int u_permiss) {
        if(users.getUPermiss() == 1) {
            return "Nhân viên";
        }
        return "Quản trị";
    }

    public void updateUser(String u_account, String u_name, String u_address, String u_email, String u_phone, Date u_addDate, int u_permiss, int u_status) {
        this.u_account = u_account;
        this.u_name = u_name;
        this.u_address = u_address;
        this.u_email = u_email;
        this.u_phone = u_phone;
        this.u_addDate = u_addDate;
        this.u_permiss = u_permiss;
        this.u_status = u_status;
    }

    public String doUpdateUser() {
        users.setUAccount(u_account);
        users.setUName(u_name);
        users.setUAddress(u_address);
        users.setUEmail(u_email);
        users.setUPhone(u_phone);
        users.setUPermiss(u_permiss);
        users.setUStatus(u_status);
        usersFacade.update(u_account, u_name, u_address, u_email, u_phone, u_permiss, u_status);
        return "user";
    }
    
    public String deleteUser(int id) {
        if(usersFacade.delete(id)) {
            messageRequest("message", "Xóa " + users.getUName() + " thành công!");
            return "user";
        } else {
            messageRequest("error", "Xóa " + users.getUName() + " thất bại!");
            return "user";
        }        
    }

    public void messageRequest(String type, String text) {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.setAttribute(type, text);
    }
}
