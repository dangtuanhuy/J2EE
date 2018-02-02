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
@Table(name = "news")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n")
    , @NamedQuery(name = "News.findByNId", query = "SELECT n FROM News n WHERE n.nId = :nId")
    , @NamedQuery(name = "News.findByNTitle", query = "SELECT n FROM News n WHERE n.nTitle = :nTitle")
    , @NamedQuery(name = "News.findByNImage", query = "SELECT n FROM News n WHERE n.nImage = :nImage")
    , @NamedQuery(name = "News.findByNSum", query = "SELECT n FROM News n WHERE n.nSum = :nSum")
    , @NamedQuery(name = "News.findByNStatus", query = "SELECT n FROM News n WHERE n.nStatus = :nStatus")})
public class News implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "n_id")
    private Integer nId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "n_title")
    private String nTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "n_image")
    private String nImage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "n_sum")
    private String nSum;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "n_content")
    private String nContent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_status")
    private int nStatus;

    public News() {
    }

    public News(Integer nId) {
        this.nId = nId;
    }

    public News(Integer nId, String nTitle, String nImage, String nSum, String nContent, int nStatus) {
        this.nId = nId;
        this.nTitle = nTitle;
        this.nImage = nImage;
        this.nSum = nSum;
        this.nContent = nContent;
        this.nStatus = nStatus;
    }

    public Integer getNId() {
        return nId;
    }

    public void setNId(Integer nId) {
        this.nId = nId;
    }

    public String getNTitle() {
        return nTitle;
    }

    public void setNTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    public String getNImage() {
        return nImage;
    }

    public void setNImage(String nImage) {
        this.nImage = nImage;
    }

    public String getNSum() {
        return nSum;
    }

    public void setNSum(String nSum) {
        this.nSum = nSum;
    }

    public String getNContent() {
        return nContent;
    }

    public void setNContent(String nContent) {
        this.nContent = nContent;
    }

    public int getNStatus() {
        return nStatus;
    }

    public void setNStatus(int nStatus) {
        this.nStatus = nStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nId != null ? nId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.nId == null && other.nId != null) || (this.nId != null && !this.nId.equals(other.nId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclass.News[ nId=" + nId + " ]";
    }
    
}
