/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entityclass.Infomations;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nobita
 */
@Stateless
public class InfomationsFacade extends AbstractFacade<Infomations> implements InfomationsFacadeLocal {

    @PersistenceContext(unitName = "BookStore-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InfomationsFacade() {
        super(Infomations.class);
    }
    
}
