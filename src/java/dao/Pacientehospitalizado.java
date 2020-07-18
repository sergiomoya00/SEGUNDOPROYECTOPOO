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
@Table(name = "pacientehospitalizado")
@NamedQueries({
    @NamedQuery(name = "Pacientehospitalizado.findAll", query = "SELECT p FROM Pacientehospitalizado p")
    , @NamedQuery(name = "Pacientehospitalizado.findByCedulaPaciente", query = "SELECT p FROM Pacientehospitalizado p WHERE p.cedulaPaciente = :cedulaPaciente")
    , @NamedQuery(name = "Pacientehospitalizado.findByNombrePaciente", query = "SELECT p FROM Pacientehospitalizado p WHERE p.nombrePaciente = :nombrePaciente")
    , @NamedQuery(name = "Pacientehospitalizado.findByDiagnostico", query = "SELECT p FROM Pacientehospitalizado p WHERE p.diagnostico = :diagnostico")
    , @NamedQuery(name = "Pacientehospitalizado.findByFechaInicio", query = "SELECT p FROM Pacientehospitalizado p WHERE p.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Pacientehospitalizado.findByFechaSalida", query = "SELECT p FROM Pacientehospitalizado p WHERE p.fechaSalida = :fechaSalida")
    , @NamedQuery(name = "Pacientehospitalizado.findByArea", query = "SELECT p FROM Pacientehospitalizado p WHERE p.area = :area")})
public class Pacientehospitalizado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedulaPaciente", nullable = false)
    private Integer cedulaPaciente;
    @Size(max = 50)
    @Column(name = "nombrePaciente", length = 50)
    private String nombrePaciente;
    @Size(max = 50)
    @Column(name = "diagnostico", length = 50)
    private String diagnostico;
    @Size(max = 50)
    @Column(name = "fechaInicio", length = 50)
    private String fechaInicio;
    @Size(max = 50)
    @Column(name = "fechaSalida", length = 50)
    private String fechaSalida;
    @Size(max = 50)
    @Column(name = "area", length = 50)
    private String area;
    @JoinColumn(name = "cedulaPaciente", referencedColumnName = "cedula", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Paciente paciente;
    @JoinColumn(name = "cedulaFuncionario", referencedColumnName = "cedula")
    @ManyToOne
    private Funcionario cedulaFuncionario;
    @JoinColumn(name = "centroAtencion", referencedColumnName = "codigo")
    @ManyToOne
    private Centrodeatencion centroAtencion;

    public Pacientehospitalizado() {
    }

    public Pacientehospitalizado(Integer cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public Integer getCedulaPaciente() {
        return cedulaPaciente;
    }

    public void setCedulaPaciente(Integer cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public Centrodeatencion getCentroAtencion() {
        return centroAtencion;
    }

    public void setCentroAtencion(Centrodeatencion centroAtencion) {
        this.centroAtencion = centroAtencion;
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
        if (!(object instanceof Pacientehospitalizado)) {
            return false;
        }
        Pacientehospitalizado other = (Pacientehospitalizado) object;
        if ((this.cedulaPaciente == null && other.cedulaPaciente != null) || (this.cedulaPaciente != null && !this.cedulaPaciente.equals(other.cedulaPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Pacientehospitalizado[ cedulaPaciente=" + cedulaPaciente + " ]";
    }
    
}
