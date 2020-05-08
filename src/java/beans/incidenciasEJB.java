
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
    
    public boolean existeEmpleado(Empleado e) {
    EntityManager em = emf.createEntityManager();
    Empleado encontrado = em.find(Empleado.class, e.getNombreusuario());       
    em.close();  
    return encontrado != null; 
    }
    
    public Empleado Emplxusu (Empleado e){
    EntityManager em = emf.createEntityManager();
    Empleado encontrado = em.find(Empleado.class, e.getNombreusuario());
    return encontrado;
    }

    public boolean insertarEmpleado(Empleado e) {
        if (!existeEmpleado(e)) {
            EntityManager em = emf.createEntityManager();
            em.persist(e);
            //        em.flush();   Para forzar que se haga ahora
            em.close();
            return true;
        }
        return false;      
    }

    public boolean modempl(Empleado e) {
        EntityManager em = emf.createEntityManager();
        Empleado mod = em.find(Empleado.class, e.getNombreusuario());
        if (mod != null) {
            mod.setNombrecompleto(e.getNombrecompleto());
            mod.setTelefono(e.getTelefono());
            em.persist(mod);
            em.close();
            return true;
        }
        return false;
    }
    
        public boolean modpsswd(Empleado e) {
        EntityManager em = emf.createEntityManager();
        Empleado mod = em.find(Empleado.class, e.getNombreusuario());
        if (mod != null) {
            mod.setPassword(e.getPassword());
            em.persist(mod);
            em.close();
            return true;
        }
        return false;
    }

    public boolean elempl(Empleado e) {
        EntityManager em = emf.createEntityManager();
        Empleado mod = em.find(Empleado.class, e.getNombreusuario());
        if (mod != null) {
            em.remove(mod);
            em.close();
            return true;
        }
        return false;
    }
}
