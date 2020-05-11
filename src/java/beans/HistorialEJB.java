/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Empleado;
import entities.Historial;
import entities.Incidencia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author vicent
 */
@Stateless
public class HistorialEJB {

    @PersistenceUnit
    EntityManagerFactory emf;
    
    public List findAllHistorials() {
        return emf.createEntityManager().createNamedQuery("Historial.findAll").getResultList();
    }
    
    public int numhistorial() {
        int k = 0;
        List <Incidencia> inc = findAllHistorials();
        for(int i = 0; i<inc.size(); i++){
        k++;
        }
        return k;
    }

    public void guardarHistorial(Historial H) {
        EntityManager em = emf.createEntityManager();
        em.persist(H);
        em.close();
    }
    
    public List<Historial> historialxempleado (Empleado e) {
        EntityManager em = emf.createEntityManager();
        List <Historial> listado = emf.createEntityManager().createQuery("SELECT h FROM Historial h WHERE h.empleado = "+ e).getResultList();
        return listado;
    }

}
