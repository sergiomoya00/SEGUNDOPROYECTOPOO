/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "citas")
@NamedQueries({
    @NamedQuery(name = "Citas.findAll", query = "SELECT c FROM Citas c")
    , @NamedQuery(name = "Citas.findByCodigoCita", query = "SELECT c FROM Citas c WHERE c.codigoCita = :codigoCita")
    , @NamedQuery(name = "Citas.findByArea", query = "SELECT c FROM Citas c WHERE c.area = :area")
    , @NamedQuery(name = "Citas.findByFecha", query = "SELECT c FROM Citas c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "Citas.findByHora", query = "SELECT c FROM Citas c WHERE c.hora = :hora")
    , @NamedQuery(name = "Citas.findByObservacion", query = "SELECT c FROM Citas c WHERE c.observacion = :observacion")
    , @NamedQuery(name = "Citas.findByEstado", query = "SELECT c FROM Citas c WHERE c.estado = :estado")})
public class Citas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoCita", nullable = false)
    private Integer codigoCita;
    @Size(max = 50)
    @Column(name = "area", length = 50)
    private String area;
    @Size(max = 50)
    @Column(name = "fecha", length = 50)
    private String fecha;
    @Size(max = 50)
    @Column(name = "hora", length = 50)
    private String hora;
    @Size(max = 50)
    @Column(name = "observacion", length = 50)
    private String observacion;
    @Size(max = 50)
    @Column(name = "estado", length = 50)
    private String estado;
    @JoinColumn(name = "cedulaPaciente", referencedColumnName = "cedula")
    @ManyToOne
    private Paciente cedulaPaciente;
    @JoinColumn(name = "cedulaFuncionario", referencedColumnName = "cedula")
    @ManyToOne
    private Funcionario cedulaFuncionario;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "citas")
    private Bitacora bitacora;

    public Citas() {
    }

    public Citas(Integer codigoCita) {
        this.codigoCita = codigoCita;
    }

    public Integer getCodigoCita() {
        return codigoCita;
    }

    public void setCodigoCita(Integer codigoCita) {
        this.codigoCita = codigoCita;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Paciente getCedulaPaciente() {
        return cedulaPaciente;
    }

    public void setCedulaPaciente(Paciente cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public Funcionario getCedulaFuncionario() {
        return cedulaFuncionario;
    }

    public void setCedulaFuncionario(Funcionario cedulaFuncionario) {
        this.cedulaFuncionario = cedulaFuncionario;
    }

    public Bitacora getBitacora() {
        return bitacora;
    }

    public void setBitacora(Bitacora bitacora) {
        this.bitacora = bitacora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCita != null ? codigoCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citas)) {
            return false;
        }
        Citas other = (Citas) object;
        if ((this.codigoCita == null && other.codigoCita != null) || (this.codigoCita != null && !this.codigoCita.equals(other.codigoCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Citas[ codigoCita=" + codigoCita + " ]";
    }
    
}
