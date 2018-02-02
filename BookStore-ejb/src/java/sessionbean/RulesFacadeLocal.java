/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entityclass.Rules;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nobita
 */
@Local
public interface RulesFacadeLocal {

    void create(Rules rules);

    void edit(Rules rules);

    void remove(Rules rules);

    Rules find(Object id);

    List<Rules> findAll();

    List<Rules> findRange(int[] range);

    int count();
    
}
