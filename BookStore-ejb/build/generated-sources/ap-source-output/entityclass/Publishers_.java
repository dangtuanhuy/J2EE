package entityclass;

import entityclass.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-02T14:12:05")
@StaticMetamodel(Publishers.class)
public class Publishers_ { 

    public static volatile SingularAttribute<Publishers, String> plName;
    public static volatile ListAttribute<Publishers, Products> productsList;
    public static volatile SingularAttribute<Publishers, Integer> plId;
    public static volatile SingularAttribute<Publishers, Integer> plStatus;

}