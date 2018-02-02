/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entityclass.Categories;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nobita
 */
@Local
public interface CategoriesFacadeLocal {

    void create(Categories categories);

    void edit(Categories categories);

    void remove(Categories categories);

    Categories find(Object id);

    List<Categories> findAll();

    List<Categories> findRange(int[] range);

    int count();

    public boolean delete(int id);

    public boolean uppdate(String c_name, String c_summary, int c_status, int parent_id);
    
}
