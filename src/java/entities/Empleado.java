/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vicent
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByNombreusuario", query = "SELECT e FROM Empleado e WHERE e.nombreusuario = :nombreusuario")
    , @NamedQuery(name = "Empleado.findByPassword", query = "SELECT e FROM Empleado e WHERE e.password = :password")
    , @NamedQuery(name = "Empleado.findByNombrecompleto", query = "SELECT e FROM Empleado e WHERE e.nombrecompleto = :nombrecompleto")
    , @NamedQuery(name = "Empleado.findByTelefono", query = "SELECT e FROM Empleado e WHERE e.telefono = :telefono")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nombreusuario")
    private String nombreusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombrecompleto")
    private String nombrecompleto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private Collection<Historial> historialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "origen")
    private Collection<Incidencia> incidenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destino")
    private Collection<Incidencia> incidenciaCollection1;

    public Empleado() {
    }

    public Empleado(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }
    
    public Empleado(String nombreusuario, String nombrecompleto, String telefono){
        this.nombreusuario = nombreusuario;
        this.nombrecompleto = nombrecompleto;
        this.telefono = telefono;
    }
    
    public Empleado(String nombreusuario, String password){
        this.nombreusuario = nombreusuario;
        this.password = password;
    }

    public Empleado(String nombreusuario, String password, String nombrecompleto, String telefono) {
        this.nombreusuario = nombreusuario;
        this.password = password;
        this.nombrecompleto = nombrecompleto;
        this.telefono = telefono;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public Collection<Historial> getHistorialCollection() {
        return historialCollection;
    }

    public void setHistorialCollection(Collection<Historial> historialCollection) {
        this.historialCollection = historialCollection;
    }

    @XmlTransient
    public Collection<Incidencia> getIncidenciaCollection() {
        return incidenciaCollection;
    }

    public void setIncidenciaCollection(Collection<Incidencia> incidenciaCollection) {
        this.incidenciaCollection = incidenciaCollection;
    }

    @XmlTransient
    public Collection<Incidencia> getIncidenciaCollection1() {
        return incidenciaCollection1;
    }

    public void setIncidenciaCollection1(Collection<Incidencia> incidenciaCollection1) {
        this.incidenciaCollection1 = incidenciaCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreusuario != null ? nombreusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.nombreusuario == null && other.nombreusuario != null) || (this.nombreusuario != null && !this.nombreusuario.equals(other.nombreusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Empleado[ nombreusuario=" + nombreusuario + " ]";
    }
    
}
