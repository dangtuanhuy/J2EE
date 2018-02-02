package entityclass;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-02T14:12:05")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, Integer> uId;
    public static volatile SingularAttribute<Users, String> uEmail;
    public static volatile SingularAttribute<Users, String> uName;
    public static volatile SingularAttribute<Users, String> uAddress;
    public static volatile SingularAttribute<Users, String> uPhone;
    public static volatile SingularAttribute<Users, Date> uAdddate;
    public static volatile SingularAttribute<Users, String> uPassword;
    public static volatile SingularAttribute<Users, Integer> uPermiss;
    public static volatile SingularAttribute<Users, Integer> uStatus;
    public static volatile SingularAttribute<Users, String> uAccount;

}