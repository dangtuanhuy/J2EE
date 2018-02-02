/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entityclass.Categories;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import sessionbean.CategoriesFacadeLocal;

/**
 *
 * @author Nobita
 */
@Named(value = "categoriesMB")
@Dependent
public class CategoriesMB {

    @EJB
    private CategoriesFacadeLocal categoriesFacade;
    
    private Integer c_id;
    private String c_name;
    private String c_summary;
    private Integer c_status;
    private Integer parent_id;
    
    private Categories cat = new Categories();
    
    public CategoriesMB() {
    }
    
    public CategoriesMB(Integer c_id, String c_name, String c_summary, Integer c_status, Integer parent_id) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_summary = c_summary;
        this.c_status = c_status;
        this.parent_id = parent_id;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_summary() {
        return c_summary;
    }

    public void setC_summary(String c_summary) {
        this.c_summary = c_summary;
    }

    public Integer getC_status() {
        return c_status;
    }

    public void setC_status(Integer c_status) {
        this.c_status = c_status;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Categories getCat() {
        return cat;
    }

    public void setCat(Categories cat) {
        this.cat = cat;
    }
    
    public List<Categories> allCat() {
        return categoriesFacade.findAll();
    }
   
    public void resetInsertCat() {
        this.c_name = "";
        this.c_summary = "";
    }
    
    public String insertCat() {   
        System.setProperty("file.encoding","UTF-8");
        cat.setCName(c_name);
        cat.setCSummary(c_summary);
        cat.setCStatus(1);
        cat.setParentId(parent_id);
        categoriesFacade.create(cat);
        return "categories";
    }

    public void updateCat() {
        this.c_name = c_name;
        this.c_summary = c_summary;
        this.c_status = c_status;
        this.parent_id = parent_id;
    }

    public String doUpdateCat() {
        cat.setCName(c_name);
        cat.setCSummary(c_summary);
        cat.setCStatus(c_status);
        cat.setParentId(parent_id);
        categoriesFacade.create(cat);
        return "categories";
    }
    
    public String deleteCat(int id) {
        if(categoriesFacade.delete(id)) {
            messageRequest("message", "Xóa " + cat.getCName()+ " thành công!");
            return "categories";
        } else {
            messageRequest("error", "Xóa " + cat.getCName()+ " thất bại!");
            return "categories";
        }        
    }
    
    public void messageRequest(String type, String text) {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.setAttribute(type, text);
    }
}
