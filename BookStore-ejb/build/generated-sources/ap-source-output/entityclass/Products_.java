package entityclass;

import entityclass.Authors;
import entityclass.Categories;
import entityclass.OrderDetails;
import entityclass.Publishers;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-02T14:12:05")
@StaticMetamodel(Products.class)
public class Products_ { 

    public static volatile SingularAttribute<Products, String> pDescribe;
    public static volatile SingularAttribute<Products, Integer> pPrice;
    public static volatile SingularAttribute<Products, Publishers> plId;
    public static volatile SingularAttribute<Products, Integer> pSale;
    public static volatile SingularAttribute<Products, Integer> pId;
    public static volatile SingularAttribute<Products, Integer> pStatus;
    public static volatile SingularAttribute<Products, Integer> pPage;
    public static volatile SingularAttribute<Products, Date> pAdddate;
    public static volatile SingularAttribute<Products, String> pName;
    public static volatile SingularAttribute<Products, String> pThumbsImg;
    public static volatile ListAttribute<Products, OrderDetails> orderDetailsList;
    public static volatile SingularAttribute<Products, Integer> pFeature;
    public static volatile SingularAttribute<Products, String> pImage;
    public static volatile SingularAttribute<Products, Authors> aId;
    public static volatile SingularAttribute<Products, Categories> cId;

}