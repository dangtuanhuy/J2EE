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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nobita
 */
@Entity
@Table(name = "transactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t")
    , @NamedQuery(name = "Transactions.findByTranId", query = "SELECT t FROM Transactions t WHERE t.tranId = :tranId")
    , @NamedQuery(name = "Transactions.findByTranBuydate", query = "SELECT t FROM Transactions t WHERE t.tranBuydate = :tranBuydate")
    , @NamedQuery(name = "Transactions.findByTranTotalprice", query = "SELECT t FROM Transactions t WHERE t.tranTotalprice = :tranTotalprice")})
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tran_id")
    private Integer tranId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tran_buydate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tranBuydate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tran_totalprice")
    private int tranTotalprice;
    @JoinColumn(name = "cus_id", referencedColumnName = "cus_id")
    @ManyToOne(optional = false)
    private Customers cusId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tranId")
    private List<OrderDetails> orderDetailsList;

    public Transactions() {
    }

    public Transactions(Integer tranId) {
        this.tranId = tranId;
    }

    public Transactions(Integer tranId, Date tranBuydate, int tranTotalprice) {
        this.tranId = tranId;
        this.tranBuydate = tranBuydate;
        this.tranTotalprice = tranTotalprice;
    }

    public Integer getTranId() {
        return tranId;
    }

    public void setTranId(Integer tranId) {
        this.tranId = tranId;
    }

    public Date getTranBuydate() {
        return tranBuydate;
    }

    public void setTranBuydate(Date tranBuydate) {
        this.tranBuydate = tranBuydate;
    }

    public int getTranTotalprice() {
        return tranTotalprice;
    }

    public void setTranTotalprice(int tranTotalprice) {
        this.tranTotalprice = tranTotalprice;
    }

    public Customers getCusId() {
        return cusId;
    }

    public void setCusId(Customers cusId) {
        this.cusId = cusId;
    }

    @XmlTransient
    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tranId != null ? tranId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.tranId == null && other.tranId != null) || (this.tranId != null && !this.tranId.equals(other.tranId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclass.Transactions[ tranId=" + tranId + " ]";
    }
    
}
