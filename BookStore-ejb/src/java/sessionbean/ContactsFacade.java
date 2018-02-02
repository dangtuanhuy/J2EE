/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entityclass.Contacts;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nobita
 */
@Stateless
public class ContactsFacade extends AbstractFacade<Contacts> implements ContactsFacadeLocal {

    @PersistenceContext(unitName = "BookStore-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactsFacade() {
        super(Contacts.class);
    }
    
}
