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
@Table(name = "diagnosticopaciente")
@NamedQueries({
    @NamedQuery(name = "Diagnosticopaciente.findAll", query = "SELECT d FROM Diagnosticopaciente d")
    , @NamedQuery(name = "Diagnosticopaciente.findByCedulaPaciente", query = "SELECT d FROM Diagnosticopaciente d WHERE d.cedulaPaciente = :cedulaPaciente")
    , @NamedQuery(name = "Diagnosticopaciente.findByNombreDiagnostico", query = "SELECT d FROM Diagnosticopaciente d WHERE d.nombreDiagnostico = :nombreDiagnostico")
    , @NamedQuery(name = "Diagnosticopaciente.findByNivel", query = "SELECT d FROM Diagnosticopaciente d WHERE d.nivel = :nivel")
    , @NamedQuery(name = "Diagnosticopaciente.findByObservaciones", query = "SELECT d FROM Diagnosticopaciente d WHERE d.observaciones = :observaciones")
    , @NamedQuery(name = "Diagnosticopaciente.findByTratamiento", query = "SELECT d FROM Diagnosticopaciente d WHERE d.tratamiento = :tratamiento")})
public class Diagnosticopaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedulaPaciente", nullable = false)
    private Integer cedulaPaciente;
    @Size(max = 50)
    @Column(name = "nombreDiagnostico", length = 50)
    private String nombreDiagnostico;
    @Size(max = 50)
    @Column(name = "nivel", length = 50)
    private String nivel;
    @Size(max = 50)
    @Column(name = "observaciones", length = 50)
    private String observaciones;
    @Size(max = 50)
    @Column(name = "tratamiento", length = 50)
    private String tratamiento;
    @JoinColumn(name = "cedulaPaciente", referencedColumnName = "cedula", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Paciente paciente;

    public Diagnosticopaciente() {
    }

    public Diagnosticopaciente(Integer cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public Integer getCedulaPaciente() {
        return cedulaPaciente;
    }

    public void setCedulaPaciente(Integer cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public String getNombreDiagnostico() {
        return nombreDiagnostico;
    }

    public void setNombreDiagnostico(String nombreDiagnostico) {
        this.nombreDiagnostico = nombreDiagnostico;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
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
        if (!(object instanceof Diagnosticopaciente)) {
            return false;
        }
        Diagnosticopaciente other = (Diagnosticopaciente) object;
        if ((this.cedulaPaciente == null && other.cedulaPaciente != null) || (this.cedulaPaciente != null && !this.cedulaPaciente.equals(other.cedulaPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Diagnosticopaciente[ cedulaPaciente=" + cedulaPaciente + " ]";
    }
    
}
