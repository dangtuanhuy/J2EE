/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entityclass.Publishers;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nobita
 */
@Local
public interface PublishersFacadeLocal {

    void create(Publishers publishers);

    void edit(Publishers publishers);

    void remove(Publishers publishers);

    Publishers find(Object id);

    List<Publishers> findAll();

    List<Publishers> findRange(int[] range);

    int count();
    
}
