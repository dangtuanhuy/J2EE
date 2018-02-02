package entityclass;

import entityclass.Products;
import entityclass.Transactions;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-02T14:12:05")
@StaticMetamodel(OrderDetails.class)
public class OrderDetails_ { 

    public static volatile SingularAttribute<OrderDetails, Transactions> tranId;
    public static volatile SingularAttribute<OrderDetails, Integer> pPrice;
    public static volatile SingularAttribute<OrderDetails, Integer> oQuantity;
    public static volatile SingularAttribute<OrderDetails, Products> pId;
    public static volatile SingularAttribute<OrderDetails, Integer> oId;

}