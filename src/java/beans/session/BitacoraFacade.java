/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.session;

import dao.Bitacora;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jabre
 */
@Stateless
public class BitacoraFacade extends AbstractFacade<Bitacora> {

    @PersistenceContext(unitName = "SegundoProyectoPOPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BitacoraFacade() {
        super(Bitacora.class);
    }
    
}
