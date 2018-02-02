/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entityclass.Authors;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import sessionbean.AuthorsFacadeLocal;

/**
 *
 * @author HUYHP
 */
@Named(value = "authorsMB")
@SessionScoped
public class AuthorsMB implements Serializable {

    @EJB
    private AuthorsFacadeLocal authorsFacade;

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public int getA_status() {
        return a_status;
    }

    public void setA_status(int a_status) {
        this.a_status = a_status;
    }

    public AuthorsMB(int a_id, String a_name, int a_status) {
        this.a_id = a_id;
        this.a_name = a_name;
        this.a_status = a_status;
    }

    private int a_id;
    private String a_name;
    private int a_status;
    public AuthorsMB() {
    }
    
    public List<Authors> getAll() {
        return authorsFacade.findAll();
    }
}
