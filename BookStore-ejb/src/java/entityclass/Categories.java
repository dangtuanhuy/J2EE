/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclass;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nobita
 */
@Entity
@Table(name = "categories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categories.findAll", query = "SELECT c FROM Categories c")
    , @NamedQuery(name = "Categories.findByCId", query = "SELECT c FROM Categories c WHERE c.cId = :cId")
    , @NamedQuery(name = "Categories.findByCName", query = "SELECT c FROM Categories c WHERE c.cName = :cName")
    , @NamedQuery(name = "Categories.findByCSummary", query = "SELECT c FROM Categories c WHERE c.cSummary = :cSummary")
    , @NamedQuery(name = "Categories.findByCStatus", query = "SELECT c FROM Categories c WHERE c.cStatus = :cStatus")
    , @NamedQuery(name = "Categories.findByParentId", query = "SELECT c FROM Categories c WHERE c.parentId = :parentId")})
public class Categories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_id")
    private Integer cId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "c_name")
    private String cName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "c_summary")
    private String cSummary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_status")
    private int cStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "parent_id")
    private int parentId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cId")
    private List<Products> productsList;

    public Categories() {
    }

    public Categories(Integer cId) {
        this.cId = cId;
    }

    public Categories(Integer cId, String cName, String cSummary, int cStatus, int parentId) {
        this.cId = cId;
        this.cName = cName;
        this.cSummary = cSummary;
        this.cStatus = cStatus;
        this.parentId = parentId;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getCSummary() {
        return cSummary;
    }

    public void setCSummary(String cSummary) {
        this.cSummary = cSummary;
    }

    public int getCStatus() {
        return cStatus;
    }

    public void setCStatus(int cStatus) {
        this.cStatus = cStatus;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @XmlTransient
    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cId != null ? cId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categories)) {
            return false;
        }
        Categories other = (Categories) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclass.Categories[ cId=" + cId + " ]";
    }
    
}
