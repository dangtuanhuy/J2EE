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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nobita
 */
@Entity
@Table(name = "order_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetails.findAll", query = "SELECT o FROM OrderDetails o")
    , @NamedQuery(name = "OrderDetails.findByOId", query = "SELECT o FROM OrderDetails o WHERE o.oId = :oId")
    , @NamedQuery(name = "OrderDetails.findByOQuantity", query = "SELECT o FROM OrderDetails o WHERE o.oQuantity = :oQuantity")
    , @NamedQuery(name = "OrderDetails.findByPPrice", query = "SELECT o FROM OrderDetails o WHERE o.pPrice = :pPrice")})
public class OrderDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "o_id")
    private Integer oId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "o_quantity")
    private int oQuantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_price")
    private int pPrice;
    @JoinColumn(name = "tran_id", referencedColumnName = "tran_id")
    @ManyToOne(optional = false)
    private Transactions tranId;
    @JoinColumn(name = "p_id", referencedColumnName = "p_id")
    @ManyToOne(optional = false)
    private Products pId;

    public OrderDetails() {
    }

    public OrderDetails(Integer oId) {
        this.oId = oId;
    }

    public OrderDetails(Integer oId, int oQuantity, int pPrice) {
        this.oId = oId;
        this.oQuantity = oQuantity;
        this.pPrice = pPrice;
    }

    public Integer getOId() {
        return oId;
    }

    public void setOId(Integer oId) {
        this.oId = oId;
    }

    public int getOQuantity() {
        return oQuantity;
    }

    public void setOQuantity(int oQuantity) {
        this.oQuantity = oQuantity;
    }

    public int getPPrice() {
        return pPrice;
    }

    public void setPPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public Transactions getTranId() {
        return tranId;
    }

    public void setTranId(Transactions tranId) {
        this.tranId = tranId;
    }

    public Products getPId() {
        return pId;
    }

    public void setPId(Products pId) {
        this.pId = pId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oId != null ? oId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetails)) {
            return false;
        }
        OrderDetails other = (OrderDetails) object;
        if ((this.oId == null && other.oId != null) || (this.oId != null && !this.oId.equals(other.oId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclass.OrderDetails[ oId=" + oId + " ]";
    }
    
}
