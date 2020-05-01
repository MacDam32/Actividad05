
package beans;

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
}
