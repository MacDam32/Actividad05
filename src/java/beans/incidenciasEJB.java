
package beans;

import entities.Empleado;
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
public class incidenciasEJB {

    @PersistenceUnit
    EntityManagerFactory emf;
    
    public List findAllEmpleados() {
        return emf.createEntityManager().createNamedQuery("Empleado.findAll").getResultList();
    }
    
    /*public boolean existeSocio(Empleado e) {
    EntityManager em = emf.createEntityManager();
    Empleado encontrado = em.find(Empleado.class, e.getNombreusuario());
    if (encontrado.getPassword().equals(e.getPassword())){        
        em.close();
        return true;      
    }else {
        em.close(); 
        return false;    
        } 
    }*/
    
    public Empleado Emplxusu (Empleado e){
    EntityManager em = emf.createEntityManager();
    Empleado encontrado = em.find(Empleado.class, e.getNombreusuario());
    return encontrado;
    }
}
