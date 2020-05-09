/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vicent
 */
@Entity
@Table(name = "incidencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incidencia.findAll", query = "SELECT i FROM Incidencia i")
    , @NamedQuery(name = "Incidencia.findByIdincidencia", query = "SELECT i FROM Incidencia i WHERE i.idincidencia = :idincidencia")
    , @NamedQuery(name = "Incidencia.findByFechahora", query = "SELECT i FROM Incidencia i WHERE i.fechahora = :fechahora")
    , @NamedQuery(name = "Incidencia.findByTipo", query = "SELECT i FROM Incidencia i WHERE i.tipo = :tipo")})
public class Incidencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idincidencia")
    private Integer idincidencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fechahora")
    private String fechahora;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "detalle")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "origen", referencedColumnName = "nombreusuario")
    @ManyToOne(optional = false)
    private Empleado origen;
    @JoinColumn(name = "destino", referencedColumnName = "nombreusuario")
    @ManyToOne(optional = false)
    private Empleado destino;

    public Incidencia() {
    }

    public Incidencia(Integer idincidencia) {
        this.idincidencia = idincidencia;
    }

    public Incidencia(Integer idincidencia, String fechahora, String detalle, String tipo, Empleado origen, Empleado destino) {
        this.idincidencia = idincidencia;
        this.fechahora = fechahora;
        this.detalle = detalle;
        this.tipo = tipo;
        this.origen = origen;
        this.destino = destino;
    }

    public Integer getIdincidencia() {
        return idincidencia;
    }

    public void setIdincidencia(Integer idincidencia) {
        this.idincidencia = idincidencia;
    }

    public String getFechahora() {
        return fechahora;
    }

    public void setFechahora(String fechahora) {
        this.fechahora = fechahora;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Empleado getOrigen() {
        return origen;
    }

    public void setOrigen(Empleado origen) {
        this.origen = origen;
    }

    public Empleado getDestino() {
        return destino;
    }

    public void setDestino(Empleado destino) {
        this.destino = destino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idincidencia != null ? idincidencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incidencia)) {
            return false;
        }
        Incidencia other = (Incidencia) object;
        if ((this.idincidencia == null && other.idincidencia != null) || (this.idincidencia != null && !this.idincidencia.equals(other.idincidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Incidencia[ idincidencia=" + idincidencia + ", fecha y hora= "+ fechahora + ", detalle = " + detalle + ", tipo = " + tipo + ", origen = " + origen.getNombreusuario() + ", destino = " + destino.getNombreusuario() +" ]";
    }
    
}
