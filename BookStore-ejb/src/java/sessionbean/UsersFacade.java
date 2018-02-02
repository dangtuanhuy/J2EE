/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entityclass.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Nobita
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> implements UsersFacadeLocal {

    @PersistenceContext(unitName = "BookStore-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }

    @Override
    public boolean checkLogin(String u_account, String u_password) {
        String sql = "select u from Users u where u.uAccount=:u_account and u.uPassword=:u_password";
        Query query = em.createQuery(sql);
        query.setParameter("u_account", u_account);
        query.setParameter("u_password", u_password);
        try {
            Users utem = (Users) query.getSingleResult();
            if(utem != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(String u_account, String u_name, String u_address, String u_email, String u_phone, int u_permiss, int u_status) {
        String sql = "update Users u set u.uAccount=:u_account,u.uName=:u_name,u.uAddress=:u_address,u.uEmail=:u_email,u.uPhone=:u_phone,u.uPermiss=:u_permiss,u.uStatus=:u_status";
        Query query = em.createQuery(sql);
        query.setParameter("u_account", u_account);
        query.setParameter("u_name", u_name);
        query.setParameter("u_address", u_address);
        query.setParameter("u_email", u_email);
        query.setParameter("u_phone", u_phone);
        query.setParameter("u_permiss", u_permiss);
        query.setParameter("u_status", u_status);
        try {
            Users utem = (Users) query.getSingleResult();
            if(utem != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        Users u = em.find(Users.class, id);
        if (u != null) {
            em.remove(u);
            return true;
        }
        return false;
    }

    public void persist(Object object) {
        em.persist(object);
    }
}