/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entityclass.Users;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nobita
 */
@Local
public interface UsersFacadeLocal {

    void create(Users users);

    void edit(Users users);

    void remove(Users users);

    Users find(Object id);

    List<Users> findAll();

    List<Users> findRange(int[] range);

    int count();

    public boolean delete(int id);

    public boolean checkLogin(String u_account, String u_password);
  
    public boolean update(String u_account, String u_name, String u_address, String u_email, String u_phone, int u_permiss, int u_status);
    
}
