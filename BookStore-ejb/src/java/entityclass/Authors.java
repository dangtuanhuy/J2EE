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
@Table(name = "authors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Authors.findAll", query = "SELECT a FROM Authors a")
    , @NamedQuery(name = "Authors.findByAId", query = "SELECT a FROM Authors a WHERE a.aId = :aId")
    , @NamedQuery(name = "Authors.findByAName", query = "SELECT a FROM Authors a WHERE a.aName = :aName")
    , @NamedQuery(name = "Authors.findByAStatus", query = "SELECT a FROM Authors a WHERE a.aStatus = :aStatus")})
public class Authors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "a_id")
    private Integer aId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "a_name")
    private String aName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "a_status")
    private int aStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aId")
    private List<Products> productsList;

    public Authors() {
    }

    public Authors(Integer aId) {
        this.aId = aId;
    }

    public Authors(Integer aId, String aName, int aStatus) {
        this.aId = aId;
        this.aName = aName;
        this.aStatus = aStatus;
    }

    public Integer getAId() {
        return aId;
    }

    public void setAId(Integer aId) {
        this.aId = aId;
    }

    public String getAName() {
        return aName;
    }

    public void setAName(String aName) {
        this.aName = aName;
    }

    public int getAStatus() {
        return aStatus;
    }

    public void setAStatus(int aStatus) {
        this.aStatus = aStatus;
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
        hash += (aId != null ? aId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Authors)) {
            return false;
        }
        Authors other = (Authors) object;
        if ((this.aId == null && other.aId != null) || (this.aId != null && !this.aId.equals(other.aId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclass.Authors[ aId=" + aId + " ]";
    }
    
}
