package entityclass;

import entityclass.Transactions;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-02T14:12:05")
@StaticMetamodel(Customers.class)
public class Customers_ { 

    public static volatile SingularAttribute<Customers, Date> cusAdddate;
    public static volatile SingularAttribute<Customers, String> cusEmail;
    public static volatile SingularAttribute<Customers, Integer> cusId;
    public static volatile SingularAttribute<Customers, String> cusName;
    public static volatile SingularAttribute<Customers, String> cusAddress;
    public static volatile SingularAttribute<Customers, String> cusNote;
    public static volatile SingularAttribute<Customers, Integer> cusStatus;
    public static volatile ListAttribute<Customers, Transactions> transactionsList;
    public static volatile SingularAttribute<Customers, String> cusPhone;

}