/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclass;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nobita
 */
@Entity
@Table(name = "rules")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rules.findAll", query = "SELECT r FROM Rules r")
    , @NamedQuery(name = "Rules.findByRId", query = "SELECT r FROM Rules r WHERE r.rId = :rId")
    , @NamedQuery(name = "Rules.findByRTitle", query = "SELECT r FROM Rules r WHERE r.rTitle = :rTitle")
    , @NamedQuery(name = "Rules.findByRSort", query = "SELECT r FROM Rules r WHERE r.rSort = :rSort")
    , @NamedQuery(name = "Rules.findByRStatus", query = "SELECT r FROM Rules r WHERE r.rStatus = :rStatus")})
public class Rules implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "r_id")
    private Integer rId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "r_title")
    private String rTitle;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "r_content")
    private String rContent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "r_sort")
    private int rSort;
    @Basic(optional = false)
    @NotNull
    @Column(name = "r_status")
    private int rStatus;

    public Rules() {
    }

    public Rules(Integer rId) {
        this.rId = rId;
    }

    public Rules(Integer rId, String rTitle, String rContent, int rSort, int rStatus) {
        this.rId = rId;
        this.rTitle = rTitle;
        this.rContent = rContent;
        this.rSort = rSort;
        this.rStatus = rStatus;
    }

    public Integer getRId() {
        return rId;
    }

    public void setRId(Integer rId) {
        this.rId = rId;
    }

    public String getRTitle() {
        return rTitle;
    }

    public void setRTitle(String rTitle) {
        this.rTitle = rTitle;
    }

    public String getRContent() {
        return rContent;
    }

    public void setRContent(String rContent) {
        this.rContent = rContent;
    }

    public int getRSort() {
        return rSort;
    }

    public void setRSort(int rSort) {
        this.rSort = rSort;
    }

    public int getRStatus() {
        return rStatus;
    }

    public void setRStatus(int rStatus) {
        this.rStatus = rStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rId != null ? rId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rules)) {
            return false;
        }
        Rules other = (Rules) object;
        if ((this.rId == null && other.rId != null) || (this.rId != null && !this.rId.equals(other.rId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclass.Rules[ rId=" + rId + " ]";
    }
    
}
