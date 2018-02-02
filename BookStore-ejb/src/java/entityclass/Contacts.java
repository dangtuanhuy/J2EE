/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclass;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nobita
 */
@Entity
@Table(name = "contacts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacts.findAll", query = "SELECT c FROM Contacts c")
    , @NamedQuery(name = "Contacts.findByLId", query = "SELECT c FROM Contacts c WHERE c.lId = :lId")
    , @NamedQuery(name = "Contacts.findByLName", query = "SELECT c FROM Contacts c WHERE c.lName = :lName")
    , @NamedQuery(name = "Contacts.findByLEmail", query = "SELECT c FROM Contacts c WHERE c.lEmail = :lEmail")
    , @NamedQuery(name = "Contacts.findByLPhone", query = "SELECT c FROM Contacts c WHERE c.lPhone = :lPhone")
    , @NamedQuery(name = "Contacts.findByLAdddate", query = "SELECT c FROM Contacts c WHERE c.lAdddate = :lAdddate")
    , @NamedQuery(name = "Contacts.findByLStatus", query = "SELECT c FROM Contacts c WHERE c.lStatus = :lStatus")})
public class Contacts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "l_id")
    private Integer lId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "l_name")
    private String lName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "l_email")
    private String lEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "l_phone")
    private String lPhone;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "l_content")
    private String lContent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "l_adddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lAdddate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "l_status")
    private int lStatus;

    public Contacts() {
    }

    public Contacts(Integer lId) {
        this.lId = lId;
    }

    public Contacts(Integer lId, String lName, String lEmail, String lPhone, String lContent, Date lAdddate, int lStatus) {
        this.lId = lId;
        this.lName = lName;
        this.lEmail = lEmail;
        this.lPhone = lPhone;
        this.lContent = lContent;
        this.lAdddate = lAdddate;
        this.lStatus = lStatus;
    }

    public Integer getLId() {
        return lId;
    }

    public void setLId(Integer lId) {
        this.lId = lId;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getLEmail() {
        return lEmail;
    }

    public void setLEmail(String lEmail) {
        this.lEmail = lEmail;
    }

    public String getLPhone() {
        return lPhone;
    }

    public void setLPhone(String lPhone) {
        this.lPhone = lPhone;
    }

    public String getLContent() {
        return lContent;
    }

    public void setLContent(String lContent) {
        this.lContent = lContent;
    }

    public Date getLAdddate() {
        return lAdddate;
    }

    public void setLAdddate(Date lAdddate) {
        this.lAdddate = lAdddate;
    }

    public int getLStatus() {
        return lStatus;
    }

    public void setLStatus(int lStatus) {
        this.lStatus = lStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lId != null ? lId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacts)) {
            return false;
        }
        Contacts other = (Contacts) object;
        if ((this.lId == null && other.lId != null) || (this.lId != null && !this.lId.equals(other.lId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclass.Contacts[ lId=" + lId + " ]";
    }
    
}
