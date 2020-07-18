/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.session;

import dao.Diagnosticopaciente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jabre
 */
@Stateless
public class DiagnosticopacienteFacade extends AbstractFacade<Diagnosticopaciente> {

    @PersistenceContext(unitName = "SegundoProyectoPOPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiagnosticopacienteFacade() {
        super(Diagnosticopaciente.class);
    }
    
}
