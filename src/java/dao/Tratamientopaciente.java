/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jabre
 */
@Entity
@Table(name = "tratamientopaciente")
@NamedQueries({
    @NamedQuery(name = "Tratamientopaciente.findAll", query = "SELECT t FROM Tratamientopaciente t")
    , @NamedQuery(name = "Tratamientopaciente.findByCedulaPaciente", query = "SELECT t FROM Tratamientopaciente t WHERE t.cedulaPaciente = :cedulaPaciente")
    , @NamedQuery(name = "Tratamientopaciente.findByNombreTratamiento", query = "SELECT t FROM Tratamientopaciente t WHERE t.nombreTratamiento = :nombreTratamiento")
    , @NamedQuery(name = "Tratamientopaciente.findByCantidadUnidades", query = "SELECT t FROM Tratamientopaciente t WHERE t.cantidadUnidades = :cantidadUnidades")
    , @NamedQuery(name = "Tratamientopaciente.findByTipo", query = "SELECT t FROM Tratamientopaciente t WHERE t.tipo = :tipo")})
public class Tratamientopaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedulaPaciente", nullable = false)
    private Integer cedulaPaciente;
    @Size(max = 50)
    @Column(name = "nombreTratamiento", length = 50)
    private String nombreTratamiento;
    @Column(name = "cantidadUnidades")
    private Integer cantidadUnidades;
    @Size(max = 50)
    @Column(name = "tipo", length = 50)
    private String tipo;
    @JoinColumn(name = "cedulaPaciente", referencedColumnName = "cedula", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Paciente paciente;

    public Tratamientopaciente() {
    }

    public Tratamientopaciente(Integer cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public Integer getCedulaPaciente() {
        return cedulaPaciente;
    }

    public void setCedulaPaciente(Integer cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public String getNombreTratamiento() {
        return nombreTratamiento;
    }

    public void setNombreTratamiento(String nombreTratamiento) {
        this.nombreTratamiento = nombreTratamiento;
    }

    public Integer getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(Integer cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulaPaciente != null ? cedulaPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tratamientopaciente)) {
            return false;
        }
        Tratamientopaciente other = (Tratamientopaciente) object;
        if ((this.cedulaPaciente == null && other.cedulaPaciente != null) || (this.cedulaPaciente != null && !this.cedulaPaciente.equals(other.cedulaPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Tratamientopaciente[ cedulaPaciente=" + cedulaPaciente + " ]";
    }
    
}
