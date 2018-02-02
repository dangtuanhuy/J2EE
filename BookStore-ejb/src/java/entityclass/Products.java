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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p")
    , @NamedQuery(name = "Products.findByPId", query = "SELECT p FROM Products p WHERE p.pId = :pId")
    , @NamedQuery(name = "Products.findByPName", query = "SELECT p FROM Products p WHERE p.pName = :pName")
    , @NamedQuery(name = "Products.findByPPrice", query = "SELECT p FROM Products p WHERE p.pPrice = :pPrice")
    , @NamedQuery(name = "Products.findByPImage", query = "SELECT p FROM Products p WHERE p.pImage = :pImage")
    , @NamedQuery(name = "Products.findByPStatus", query = "SELECT p FROM Products p WHERE p.pStatus = :pStatus")
    , @NamedQuery(name = "Products.findByPSale", query = "SELECT p FROM Products p WHERE p.pSale = :pSale")
    , @NamedQuery(name = "Products.findByPFeature", query = "SELECT p FROM Products p WHERE p.pFeature = :pFeature")
    , @NamedQuery(name = "Products.findByPPage", query = "SELECT p FROM Products p WHERE p.pPage = :pPage")
    , @NamedQuery(name = "Products.findByPAdddate", query = "SELECT p FROM Products p WHERE p.pAdddate = :pAdddate")
    , @NamedQuery(name = "Products.findByPThumbsImg", query = "SELECT p FROM Products p WHERE p.pThumbsImg = :pThumbsImg")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "p_id")
    private Integer pId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "p_name")
    private String pName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_price")
    private int pPrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "p_image")
    private String pImage;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "p_describe")
    private String pDescribe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_status")
    private int pStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_sale")
    private int pSale;
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_feature")
    private int pFeature;
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_page")
    private int pPage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_adddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pAdddate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "p_thumbs_img")
    private String pThumbsImg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pId")
    private List<OrderDetails> orderDetailsList;
    @JoinColumn(name = "c_id", referencedColumnName = "c_id")
    @ManyToOne(optional = false)
    private Categories cId;
    @JoinColumn(name = "a_id", referencedColumnName = "a_id")
    @ManyToOne(optional = false)
    private Authors aId;
    @JoinColumn(name = "pl_id", referencedColumnName = "pl_id")
    @ManyToOne(optional = false)
    private Publishers plId;

    public Products() {
    }

    public Products(Integer pId) {
        this.pId = pId;
    }

    public Products(Integer pId, String pName, int pPrice, String pImage, String pDescribe, int pStatus, int pSale, int pFeature, int pPage, Date pAdddate, String pThumbsImg) {
        this.pId = pId;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pImage = pImage;
        this.pDescribe = pDescribe;
        this.pStatus = pStatus;
        this.pSale = pSale;
        this.pFeature = pFeature;
        this.pPage = pPage;
        this.pAdddate = pAdddate;
        this.pThumbsImg = pThumbsImg;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public int getPPrice() {
        return pPrice;
    }

    public void setPPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public String getPImage() {
        return pImage;
    }

    public void setPImage(String pImage) {
        this.pImage = pImage;
    }

    public String getPDescribe() {
        return pDescribe;
    }

    public void setPDescribe(String pDescribe) {
        this.pDescribe = pDescribe;
    }

    public int getPStatus() {
        return pStatus;
    }

    public void setPStatus(int pStatus) {
        this.pStatus = pStatus;
    }

    public int getPSale() {
        return pSale;
    }

    public void setPSale(int pSale) {
        this.pSale = pSale;
    }

    public int getPFeature() {
        return pFeature;
    }

    public void setPFeature(int pFeature) {
        this.pFeature = pFeature;
    }

    public int getPPage() {
        return pPage;
    }

    public void setPPage(int pPage) {
        this.pPage = pPage;
    }

    public Date getPAdddate() {
        return pAdddate;
    }

    public void setPAdddate(Date pAdddate) {
        this.pAdddate = pAdddate;
    }

    public String getPThumbsImg() {
        return pThumbsImg;
    }

    public void setPThumbsImg(String pThumbsImg) {
        this.pThumbsImg = pThumbsImg;
    }

    @XmlTransient
    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    public Categories getCId() {
        return cId;
    }

    public void setCId(Categories cId) {
        this.cId = cId;
    }

    public Authors getAId() {
        return aId;
    }

    public void setAId(Authors aId) {
        this.aId = aId;
    }

    public Publishers getPlId() {
        return plId;
    }

    public void setPlId(Publishers plId) {
        this.plId = plId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pId != null ? pId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclass.Products[ pId=" + pId + " ]";
    }
    
}
