package entityclass;

import entityclass.Customers;
import entityclass.OrderDetails;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-02T14:12:05")
@StaticMetamodel(Transactions.class)
public class Transactions_ { 

    public static volatile SingularAttribute<Transactions, Integer> tranId;
    public static volatile SingularAttribute<Transactions, Integer> tranTotalprice;
    public static volatile SingularAttribute<Transactions, Customers> cusId;
    public static volatile SingularAttribute<Transactions, Date> tranBuydate;
    public static volatile ListAttribute<Transactions, OrderDetails> orderDetailsList;

}