
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
    
    public boolean existeSocio(Empleado e) {
    EntityManager em = emf.createEntityManager();
    em.contains(e);
    em.close();
    return e != null;
    }
}
