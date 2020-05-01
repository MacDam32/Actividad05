
package beans;

import java.util.List;
import javax.ejb.Stateless;
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
}
