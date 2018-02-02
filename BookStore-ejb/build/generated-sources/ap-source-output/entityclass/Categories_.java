package entityclass;

import entityclass.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-02T14:12:05")
@StaticMetamodel(Categories.class)
public class Categories_ { 

    public static volatile SingularAttribute<Categories, String> cSummary;
    public static volatile ListAttribute<Categories, Products> productsList;
    public static volatile SingularAttribute<Categories, String> cName;
    public static volatile SingularAttribute<Categories, Integer> cStatus;
    public static volatile SingularAttribute<Categories, Integer> parentId;
    public static volatile SingularAttribute<Categories, Integer> cId;

}