/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jabre
 */
@Entity
@Table(name = "funcionario")
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
    , @NamedQuery(name = "Funcionario.findByCedula", query = "SELECT f FROM Funcionario f WHERE f.cedula = :cedula")
    , @NamedQuery(name = "Funcionario.findByNombre", query = "SELECT f FROM Funcionario f WHERE f.nombre = :nombre")
    , @NamedQuery(name = "Funcionario.findByTipo", query = "SELECT f FROM Funcionario f WHERE f.tipo = :tipo")
    , @NamedQuery(name = "Funcionario.findByFechaEntrega", query = "SELECT f FROM Funcionario f WHERE f.fechaEntrega = :fechaEntrega")
    , @NamedQuery(name = "Funcionario.findByArea", query = "SELECT f FROM Funcionario f WHERE f.area = :area")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula", nullable = false)
    private Integer cedula;
    @Size(max = 50)
    @Column(name = "nombre", length = 50)
    private String nombre;
    @Size(max = 50)
    @Column(name = "tipo", length = 50)
    private String tipo;
    @Size(max = 50)
    @Column(name = "fechaEntrega", length = 50)
    private String fechaEntrega;
    @Size(max = 50)
    @Column(name = "area", length = 50)
    private String area;
    @OneToMany(mappedBy = "cedulaFuncionario")
    private Collection<Seguimientopaciente> seguimientopacienteCollection;
    @OneToMany(mappedBy = "cedulaFuncionario")
    private Collection<Citas> citasCollection;
    @OneToMany(mappedBy = "cedulaFuncionario")
    private Collection<Pacientehospitalizado> pacientehospitalizadoCollection;

    public Funcionario() {
    }

    public Funcionario(Integer cedula) {
        this.cedula = cedula;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Collection<Seguimientopaciente> getSeguimientopacienteCollection() {
        return seguimientopacienteCollection;
    }

    public void setSeguimientopacienteCollection(Collection<Seguimientopaciente> seguimientopacienteCollection) {
        this.seguimientopacienteCollection = seguimientopacienteCollection;
    }

    public Collection<Citas> getCitasCollection() {
        return citasCollection;
    }

    public void setCitasCollection(Collection<Citas> citasCollection) {
        this.citasCollection = citasCollection;
    }

    public Collection<Pacientehospitalizado> getPacientehospitalizadoCollection() {
        return pacientehospitalizadoCollection;
    }

    public void setPacientehospitalizadoCollection(Collection<Pacientehospitalizado> pacientehospitalizadoCollection) {
        this.pacientehospitalizadoCollection = pacientehospitalizadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Funcionario[ cedula=" + cedula + " ]";
    }
    
}
