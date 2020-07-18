/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jabre
 */
@Entity
@Table(name = "paciente")
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
    , @NamedQuery(name = "Paciente.findByCedula", query = "SELECT p FROM Paciente p WHERE p.cedula = :cedula")
    , @NamedQuery(name = "Paciente.findByNombre", query = "SELECT p FROM Paciente p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Paciente.findByFechaNacimiento", query = "SELECT p FROM Paciente p WHERE p.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Paciente.findByTipoSangre", query = "SELECT p FROM Paciente p WHERE p.tipoSangre = :tipoSangre")
    , @NamedQuery(name = "Paciente.findByNacionalidad", query = "SELECT p FROM Paciente p WHERE p.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "Paciente.findByProvincia", query = "SELECT p FROM Paciente p WHERE p.provincia = :provincia")
    , @NamedQuery(name = "Paciente.findByCanton", query = "SELECT p FROM Paciente p WHERE p.canton = :canton")
    , @NamedQuery(name = "Paciente.findByTelefono", query = "SELECT p FROM Paciente p WHERE p.telefono = :telefono")})
public class Paciente implements Serializable {

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
    @Column(name = "fechaNacimiento", length = 50)
    private String fechaNacimiento;
    @Size(max = 50)
    @Column(name = "tipoSangre", length = 50)
    private String tipoSangre;
    @Size(max = 50)
    @Column(name = "nacionalidad", length = 50)
    private String nacionalidad;
    @Size(max = 50)
    @Column(name = "provincia", length = 50)
    private String provincia;
    @Size(max = 50)
    @Column(name = "canton", length = 50)
    private String canton;
    @Column(name = "telefono")
    private Integer telefono;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Seguimientopaciente seguimientopaciente;
    @OneToMany(mappedBy = "cedulaPaciente")
    private Collection<Citas> citasCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Tratamientopaciente tratamientopaciente;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Pacientehospitalizado pacientehospitalizado;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Diagnosticopaciente diagnosticopaciente;

    public Paciente() {
    }

    public Paciente(Integer cedula) {
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Seguimientopaciente getSeguimientopaciente() {
        return seguimientopaciente;
    }

    public void setSeguimientopaciente(Seguimientopaciente seguimientopaciente) {
        this.seguimientopaciente = seguimientopaciente;
    }

    public Collection<Citas> getCitasCollection() {
        return citasCollection;
    }

    public void setCitasCollection(Collection<Citas> citasCollection) {
        this.citasCollection = citasCollection;
    }

    public Tratamientopaciente getTratamientopaciente() {
        return tratamientopaciente;
    }

    public void setTratamientopaciente(Tratamientopaciente tratamientopaciente) {
        this.tratamientopaciente = tratamientopaciente;
    }

    public Pacientehospitalizado getPacientehospitalizado() {
        return pacientehospitalizado;
    }

    public void setPacientehospitalizado(Pacientehospitalizado pacientehospitalizado) {
        this.pacientehospitalizado = pacientehospitalizado;
    }

    public Diagnosticopaciente getDiagnosticopaciente() {
        return diagnosticopaciente;
    }

    public void setDiagnosticopaciente(Diagnosticopaciente diagnosticopaciente) {
        this.diagnosticopaciente = diagnosticopaciente;
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
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Paciente[ cedula=" + cedula + " ]";
    }
    
}
