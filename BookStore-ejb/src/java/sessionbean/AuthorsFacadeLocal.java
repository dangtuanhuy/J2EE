/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entityclass.Authors;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nobita
 */
@Local
public interface AuthorsFacadeLocal {

    void create(Authors authors);

    void edit(Authors authors);

    void remove(Authors authors);

    Authors find(Object id);

    List<Authors> findAll();

    List<Authors> findRange(int[] range);

    int count();
    
}
