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
@Table(name = "infomations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Infomations.findAll", query = "SELECT i FROM Infomations i")
    , @NamedQuery(name = "Infomations.findByIId", query = "SELECT i FROM Infomations i WHERE i.iId = :iId")
    , @NamedQuery(name = "Infomations.findByICompany", query = "SELECT i FROM Infomations i WHERE i.iCompany = :iCompany")
    , @NamedQuery(name = "Infomations.findByIAddress", query = "SELECT i FROM Infomations i WHERE i.iAddress = :iAddress")
    , @NamedQuery(name = "Infomations.findByIEmail", query = "SELECT i FROM Infomations i WHERE i.iEmail = :iEmail")
    , @NamedQuery(name = "Infomations.findByIPhone", query = "SELECT i FROM Infomations i WHERE i.iPhone = :iPhone")
    , @NamedQuery(name = "Infomations.findByILogo", query = "SELECT i FROM Infomations i WHERE i.iLogo = :iLogo")
    , @NamedQuery(name = "Infomations.findByIFacebook", query = "SELECT i FROM Infomations i WHERE i.iFacebook = :iFacebook")})
public class Infomations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "i_id")
    private Integer iId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "i_company")
    private String iCompany;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "i_address")
    private String iAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "i_email")
    private String iEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "i_phone")
    private String iPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "i_logo")
    private String iLogo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "i_facebook")
    private String iFacebook;

    public Infomations() {
    }

    public Infomations(Integer iId) {
        this.iId = iId;
    }

    public Infomations(Integer iId, String iCompany, String iAddress, String iEmail, String iPhone, String iLogo, String iFacebook) {
        this.iId = iId;
        this.iCompany = iCompany;
        this.iAddress = iAddress;
        this.iEmail = iEmail;
        this.iPhone = iPhone;
        this.iLogo = iLogo;
        this.iFacebook = iFacebook;
    }

    public Integer getIId() {
        return iId;
    }

    public void setIId(Integer iId) {
        this.iId = iId;
    }

    public String getICompany() {
        return iCompany;
    }

    public void setICompany(String iCompany) {
        this.iCompany = iCompany;
    }

    public String getIAddress() {
        return iAddress;
    }

    public void setIAddress(String iAddress) {
        this.iAddress = iAddress;
    }

    public String getIEmail() {
        return iEmail;
    }

    public void setIEmail(String iEmail) {
        this.iEmail = iEmail;
    }

    public String getIPhone() {
        return iPhone;
    }

    public void setIPhone(String iPhone) {
        this.iPhone = iPhone;
    }

    public String getILogo() {
        return iLogo;
    }

    public void setILogo(String iLogo) {
        this.iLogo = iLogo;
    }

    public String getIFacebook() {
        return iFacebook;
    }

    public void setIFacebook(String iFacebook) {
        this.iFacebook = iFacebook;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iId != null ? iId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Infomations)) {
            return false;
        }
        Infomations other = (Infomations) object;
        if ((this.iId == null && other.iId != null) || (this.iId != null && !this.iId.equals(other.iId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclass.Infomations[ iId=" + iId + " ]";
    }
    
}
