/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.session;

import dao.Centrodeatencion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jabre
 */
@Stateless
public class CentrodeatencionFacade extends AbstractFacade<Centrodeatencion> {

    @PersistenceContext(unitName = "SegundoProyectoPOPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CentrodeatencionFacade() {
        super(Centrodeatencion.class);
    }
    
}
