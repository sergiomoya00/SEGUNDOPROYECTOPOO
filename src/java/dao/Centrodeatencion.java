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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author jabre
 */
@Entity
@Table(name = "centrodeatencion")
@NamedQueries({
    @NamedQuery(name = "Centrodeatencion.findAll", query = "SELECT c FROM Centrodeatencion c")
    , @NamedQuery(name = "Centrodeatencion.findByCodigo", query = "SELECT c FROM Centrodeatencion c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Centrodeatencion.findByNombre", query = "SELECT c FROM Centrodeatencion c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Centrodeatencion.findByLugar", query = "SELECT c FROM Centrodeatencion c WHERE c.lugar = :lugar")
    , @NamedQuery(name = "Centrodeatencion.findByUbicacion", query = "SELECT c FROM Centrodeatencion c WHERE c.ubicacion = :ubicacion")
    , @NamedQuery(name = "Centrodeatencion.findByCapacidad", query = "SELECT c FROM Centrodeatencion c WHERE c.capacidad = :capacidad")
    , @NamedQuery(name = "Centrodeatencion.findByTipo", query = "SELECT c FROM Centrodeatencion c WHERE c.tipo = :tipo")})
public class Centrodeatencion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo", nullable = false)
    private Integer codigo;
    @Size(max = 50)
    @Column(name = "nombre", length = 50)
    private String nombre;
    @Size(max = 50)
    @Column(name = "lugar", length = 50)
    private String lugar;
    @Size(max = 50)
    @Column(name = "ubicacion", length = 50)
    private String ubicacion;
    @Column(name = "capacidad")
    private Integer capacidad;
    @Size(max = 50)
    @Column(name = "tipo", length = 50)
    private String tipo;
    @OneToMany(mappedBy = "centroAtencion")
    private Collection<Pacientehospitalizado> pacientehospitalizadoCollection;

    public Centrodeatencion() {
    }

    public Centrodeatencion(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Centrodeatencion)) {
            return false;
        }
        Centrodeatencion other = (Centrodeatencion) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Centrodeatencion[ codigo=" + codigo + " ]";
    }
    
}
