/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entityclass.Customers;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import sessionbean.CustomersFacadeLocal;

/**
 *
 * @author HUYHP
 */
@Named(value = "customerMB")
@Dependent
public class CustomerMB {

    @EJB
    private CustomersFacadeLocal customersFacade;
     private Customers custom = new Customers();
    private Date today = new Date();

    public CustomerMB(int cus_id, String cus_name, String cus_address, String cus_phone, String cus_email, String cus_note, Date cus_adddate, String cus_status) {
        this.cus_id = cus_id;
        this.cus_name = cus_name;
        this.cus_address = cus_address;
        this.cus_phone = cus_phone;
        this.cus_email = cus_email;
        this.cus_note = cus_note;
        this.cus_adddate = cus_adddate;
        this.cus_status = cus_status;
    }
    
    private int cus_id;
    private String cus_name;
    private String cus_address;
    private String cus_phone;
    private String cus_email;
    private String cus_note;
    private Date cus_adddate = new Date();
    private String cus_status;
    public CustomerMB() {
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public int getCus_id() {
        return cus_id;
    }

    public void setCus_id(int cus_id) {
        this.cus_id = cus_id;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getCus_address() {
        return cus_address;
    }

    public void setCus_address(String cus_address) {
        this.cus_address = cus_address;
    }

    public String getCus_phone() {
        return cus_phone;
    }

    public void setCus_phone(String cus_phone) {
        this.cus_phone = cus_phone;
    }

    public String getCus_email() {
        return cus_email;
    }

    public void setCus_email(String cus_email) {
        this.cus_email = cus_email;
    }

    public String getCus_note() {
        return cus_note;
    }

    public void setCus_note(String cus_note) {
        this.cus_note = cus_note;
    }

    public Date getCus_adddate() {
        return cus_adddate;
    }

    public void setCus_adddate(Date cus_adddate) {
        this.cus_adddate = cus_adddate;
    }

    public String getCus_status() {
        return cus_status;
    }

    public void setCus_status(String cus_status) {
        this.cus_status = cus_status;
    }

    public Customers getCustom() {
        return custom;
    }

    public void setCustom(Customers custom) {
        this.custom = custom;
    }
    public List<Customers> allCus() {
        return customersFacade.findAll();
    }
     //Insert
    public void resetInset()
    {
        this.cus_name ="";
       // this.cus_adddate = "";
        this.cus_email = "";
        this.cus_phone = "";
        this.cus_note ="";
        this.cus_address="";
    }
    public String insertCus() {     
        Customers custom1 = new Customers();
        custom1.setCusName(cus_name);
        custom1.setCusAddress(cus_address);
        custom1.setCusPhone(cus_phone);
        custom1.setCusEmail(cus_email);
        custom1.setCusNote(cus_note);
        custom1.setCusAdddate(new Date());
        custom1.setCusStatus(1);
        customersFacade.create(custom1);
        return "custom1";
    }
}
