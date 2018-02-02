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
@Table(name = "publishers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publishers.findAll", query = "SELECT p FROM Publishers p")
    , @NamedQuery(name = "Publishers.findByPlId", query = "SELECT p FROM Publishers p WHERE p.plId = :plId")
    , @NamedQuery(name = "Publishers.findByPlName", query = "SELECT p FROM Publishers p WHERE p.plName = :plName")
    , @NamedQuery(name = "Publishers.findByPlStatus", query = "SELECT p FROM Publishers p WHERE p.plStatus = :plStatus")})
public class Publishers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pl_id")
    private Integer plId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "pl_name")
    private String plName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pl_status")
    private int plStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plId")
    private List<Products> productsList;

    public Publishers() {
    }

    public Publishers(Integer plId) {
        this.plId = plId;
    }

    public Publishers(Integer plId, String plName, int plStatus) {
        this.plId = plId;
        this.plName = plName;
        this.plStatus = plStatus;
    }

    public Integer getPlId() {
        return plId;
    }

    public void setPlId(Integer plId) {
        this.plId = plId;
    }

    public String getPlName() {
        return plName;
    }

    public void setPlName(String plName) {
        this.plName = plName;
    }

    public int getPlStatus() {
        return plStatus;
    }

    public void setPlStatus(int plStatus) {
        this.plStatus = plStatus;
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
        hash += (plId != null ? plId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publishers)) {
            return false;
        }
        Publishers other = (Publishers) object;
        if ((this.plId == null && other.plId != null) || (this.plId != null && !this.plId.equals(other.plId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclass.Publishers[ plId=" + plId + " ]";
    }
    
}
