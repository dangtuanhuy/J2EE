/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclass;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nobita
 */
@Entity
@Table(name = "customers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c")
    , @NamedQuery(name = "Customers.findByCusId", query = "SELECT c FROM Customers c WHERE c.cusId = :cusId")
    , @NamedQuery(name = "Customers.findByCusName", query = "SELECT c FROM Customers c WHERE c.cusName = :cusName")
    , @NamedQuery(name = "Customers.findByCusAddress", query = "SELECT c FROM Customers c WHERE c.cusAddress = :cusAddress")
    , @NamedQuery(name = "Customers.findByCusPhone", query = "SELECT c FROM Customers c WHERE c.cusPhone = :cusPhone")
    , @NamedQuery(name = "Customers.findByCusEmail", query = "SELECT c FROM Customers c WHERE c.cusEmail = :cusEmail")
    , @NamedQuery(name = "Customers.findByCusNote", query = "SELECT c FROM Customers c WHERE c.cusNote = :cusNote")
    , @NamedQuery(name = "Customers.findByCusAdddate", query = "SELECT c FROM Customers c WHERE c.cusAdddate = :cusAdddate")
    , @NamedQuery(name = "Customers.findByCusStatus", query = "SELECT c FROM Customers c WHERE c.cusStatus = :cusStatus")})
public class Customers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cus_id")
    private Integer cusId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cus_name")
    private String cusName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cus_address")
    private String cusAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cus_phone")
    private String cusPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cus_email")
    private String cusEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cus_note")
    private String cusNote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cus_adddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cusAdddate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cus_status")
    private int cusStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cusId")
    private List<Transactions> transactionsList;

    public Customers() {
    }

//    public Customers(Integer cusId) {
//        this.cusId = cusId;
//    }

    public Customers(Integer cusId, String cusName, String cusAddress, String cusPhone, String cusEmail, String cusNote, Date cusAdddate, int cusStatus) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.cusAddress = cusAddress;
        this.cusPhone = cusPhone;
        this.cusEmail = cusEmail;
        this.cusNote = cusNote;
        this.cusAdddate = cusAdddate;
        this.cusStatus = cusStatus;
    }

    public Integer getCusId() {
        return cusId;
    }

//    public void setCusId(Integer cusId) {
//        this.cusId = cusId;
//    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getCusNote() {
        return cusNote;
    }

    public void setCusNote(String cusNote) {
        this.cusNote = cusNote;
    }

    public Date getCusAdddate() {
        return cusAdddate;
    }

    public void setCusAdddate(Date cusAdddate) {
        this.cusAdddate = cusAdddate;
    }

    public int getCusStatus() {
        return cusStatus;
    }

    public void setCusStatus(int cusStatus) {
        this.cusStatus = cusStatus;
    }

    @XmlTransient
    public List<Transactions> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cusId != null ? cusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.cusId == null && other.cusId != null) || (this.cusId != null && !this.cusId.equals(other.cusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclass.Customers[ cusId=" + cusId + " ]";
    }
    
}
