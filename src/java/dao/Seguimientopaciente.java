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
import javax.persistence.ManyToOne;
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
@Table(name = "seguimientopaciente")
@NamedQueries({
    @NamedQuery(name = "Seguimientopaciente.findAll", query = "SELECT s FROM Seguimientopaciente s")
    , @NamedQuery(name = "Seguimientopaciente.findByCedulaPaciente", query = "SELECT s FROM Seguimientopaciente s WHERE s.cedulaPaciente = :cedulaPaciente")
    , @NamedQuery(name = "Seguimientopaciente.findByFechaSeguimiento", query = "SELECT s FROM Seguimientopaciente s WHERE s.fechaSeguimiento = :fechaSeguimiento")
    , @NamedQuery(name = "Seguimientopaciente.findByEvolucion", query = "SELECT s FROM Seguimientopaciente s WHERE s.evolucion = :evolucion")
    , @NamedQuery(name = "Seguimientopaciente.findByTratamiento", query = "SELECT s FROM Seguimientopaciente s WHERE s.tratamiento = :tratamiento")})
public class Seguimientopaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedulaPaciente", nullable = false)
    private Integer cedulaPaciente;
    @Size(max = 50)
    @Column(name = "fechaSeguimiento", length = 50)
    private String fechaSeguimiento;
    @Size(max = 50)
    @Column(name = "evolucion", length = 50)
    private String evolucion;
    @Size(max = 50)
    @Column(name = "tratamiento", length = 50)
    private String tratamiento;
    @JoinColumn(name = "cedulaPaciente", referencedColumnName = "cedula", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Paciente paciente;
    @JoinColumn(name = "cedulaFuncionario", referencedColumnName = "cedula")
    @ManyToOne
    private Funcionario cedulaFuncionario;

    public Seguimientopaciente() {
    }

    public Seguimientopaciente(Integer cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public Integer getCedulaPaciente() {
        return cedulaPaciente;
    }

    public void setCedulaPaciente(Integer cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public String getFechaSeguimiento() {
        return fechaSeguimiento;
    }

    public void setFechaSeguimiento(String fechaSeguimiento) {
        this.fechaSeguimiento = fechaSeguimiento;
    }

    public String getEvolucion() {
        return evolucion;
    }

    public void setEvolucion(String evolucion) {
        this.evolucion = evolucion;
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

    public Funcionario getCedulaFuncionario() {
        return cedulaFuncionario;
    }

    public void setCedulaFuncionario(Funcionario cedulaFuncionario) {
        this.cedulaFuncionario = cedulaFuncionario;
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
        if (!(object instanceof Seguimientopaciente)) {
            return false;
        }
        Seguimientopaciente other = (Seguimientopaciente) object;
        if ((this.cedulaPaciente == null && other.cedulaPaciente != null) || (this.cedulaPaciente != null && !this.cedulaPaciente.equals(other.cedulaPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Seguimientopaciente[ cedulaPaciente=" + cedulaPaciente + " ]";
    }
    
}
