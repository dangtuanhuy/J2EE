package entityclass;

import entityclass.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-02T14:12:05")
@StaticMetamodel(Authors.class)
public class Authors_ { 

    public static volatile ListAttribute<Authors, Products> productsList;
    public static volatile SingularAttribute<Authors, String> aName;
    public static volatile SingularAttribute<Authors, Integer> aStatus;
    public static volatile SingularAttribute<Authors, Integer> aId;

}