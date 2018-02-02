/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entityclass.Sliders;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nobita
 */
@Local
public interface SlidersFacadeLocal {

    void create(Sliders sliders);

    void edit(Sliders sliders);

    void remove(Sliders sliders);

    Sliders find(Object id);

    List<Sliders> findAll();

    List<Sliders> findRange(int[] range);

    int count();
    
}
