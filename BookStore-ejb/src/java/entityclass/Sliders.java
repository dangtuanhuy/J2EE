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
@Table(name = "sliders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sliders.findAll", query = "SELECT s FROM Sliders s")
    , @NamedQuery(name = "Sliders.findBySId", query = "SELECT s FROM Sliders s WHERE s.sId = :sId")
    , @NamedQuery(name = "Sliders.findBySImage", query = "SELECT s FROM Sliders s WHERE s.sImage = :sImage")
    , @NamedQuery(name = "Sliders.findBySLink", query = "SELECT s FROM Sliders s WHERE s.sLink = :sLink")
    , @NamedQuery(name = "Sliders.findBySButton", query = "SELECT s FROM Sliders s WHERE s.sButton = :sButton")
    , @NamedQuery(name = "Sliders.findBySActive", query = "SELECT s FROM Sliders s WHERE s.sActive = :sActive")
    , @NamedQuery(name = "Sliders.findBySStatus", query = "SELECT s FROM Sliders s WHERE s.sStatus = :sStatus")})
public class Sliders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "s_id")
    private Integer sId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "s_image")
    private String sImage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "s_link")
    private String sLink;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "s_button")
    private String sButton;
    @Basic(optional = false)
    @NotNull
    @Column(name = "s_active")
    private int sActive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "s_status")
    private int sStatus;

    public Sliders() {
    }

    public Sliders(Integer sId) {
        this.sId = sId;
    }

    public Sliders(Integer sId, String sImage, String sLink, String sButton, int sActive, int sStatus) {
        this.sId = sId;
        this.sImage = sImage;
        this.sLink = sLink;
        this.sButton = sButton;
        this.sActive = sActive;
        this.sStatus = sStatus;
    }

    public Integer getSId() {
        return sId;
    }

    public void setSId(Integer sId) {
        this.sId = sId;
    }

    public String getSImage() {
        return sImage;
    }

    public void setSImage(String sImage) {
        this.sImage = sImage;
    }

    public String getSLink() {
        return sLink;
    }

    public void setSLink(String sLink) {
        this.sLink = sLink;
    }

    public String getSButton() {
        return sButton;
    }

    public void setSButton(String sButton) {
        this.sButton = sButton;
    }

    public int getSActive() {
        return sActive;
    }

    public void setSActive(int sActive) {
        this.sActive = sActive;
    }

    public int getSStatus() {
        return sStatus;
    }

    public void setSStatus(int sStatus) {
        this.sStatus = sStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sId != null ? sId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sliders)) {
            return false;
        }
        Sliders other = (Sliders) object;
        if ((this.sId == null && other.sId != null) || (this.sId != null && !this.sId.equals(other.sId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclass.Sliders[ sId=" + sId + " ]";
    }
    
}
