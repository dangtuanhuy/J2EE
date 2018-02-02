/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entityclass.Categories;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Nobita
 */
@Stateless
public class CategoriesFacade extends AbstractFacade<Categories> implements CategoriesFacadeLocal {

    @PersistenceContext(unitName = "BookStore-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriesFacade() {
        super(Categories.class);
    }

    @Override
    public boolean uppdate(String c_name, String c_summary, int c_status, int parent_id) {
        String sql = "update Categories c set c.cName=:c_name,c.cSummary=:c_summary,c.cStatus=:c_status,c.parentId=:parent_id";
        Query query = em.createQuery(sql);
        query.setParameter("c_name", c_name);
        query.setParameter("c_summary", c_summary);
        query.setParameter("c_status", c_status);
        query.setParameter("parent_id", parent_id);
        try {
            Categories ctem = (Categories) query.getSingleResult();
            if(ctem != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        Categories u = em.find(Categories.class, id);
        if (u != null) {
            em.remove(u);
            return true;
        }
        return false;
    }
}
