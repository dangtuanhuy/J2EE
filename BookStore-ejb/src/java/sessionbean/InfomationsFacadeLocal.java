/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entityclass.Infomations;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nobita
 */
@Local
public interface InfomationsFacadeLocal {

    void create(Infomations infomations);

    void edit(Infomations infomations);

    void remove(Infomations infomations);

    Infomations find(Object id);

    List<Infomations> findAll();

    List<Infomations> findRange(int[] range);

    int count();
    
}
