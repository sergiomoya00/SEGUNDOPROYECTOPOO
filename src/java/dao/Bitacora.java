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
@Table(name = "bitacora")
@NamedQueries({
    @NamedQuery(name = "Bitacora.findAll", query = "SELECT b FROM Bitacora b")
    , @NamedQuery(name = "Bitacora.findByFecha", query = "SELECT b FROM Bitacora b WHERE b.fecha = :fecha")
    , @NamedQuery(name = "Bitacora.findByHora", query = "SELECT b FROM Bitacora b WHERE b.hora = :hora")
    , @NamedQuery(name = "Bitacora.findByUsuario", query = "SELECT b FROM Bitacora b WHERE b.usuario = :usuario")
    , @NamedQuery(name = "Bitacora.findByCodigoCita", query = "SELECT b FROM Bitacora b WHERE b.codigoCita = :codigoCita")
    , @NamedQuery(name = "Bitacora.findByEstado", query = "SELECT b FROM Bitacora b WHERE b.estado = :estado")})
public class Bitacora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "fecha", length = 50)
    private String fecha;
    @Size(max = 50)
    @Column(name = "hora", length = 50)
    private String hora;
    @Size(max = 50)
    @Column(name = "usuario", length = 50)
    private String usuario;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoCita", nullable = false)
    private Integer codigoCita;
    @Size(max = 50)
    @Column(name = "estado", length = 50)
    private String estado;
    @JoinColumn(name = "codigoCita", referencedColumnName = "codigoCita", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Citas citas;

    public Bitacora() {
    }

    public Bitacora(Integer codigoCita) {
        this.codigoCita = codigoCita;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getCodigoCita() {
        return codigoCita;
    }

    public void setCodigoCita(Integer codigoCita) {
        this.codigoCita = codigoCita;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Citas getCitas() {
        return citas;
    }

    public void setCitas(Citas citas) {
        this.citas = citas;
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
        if (!(object instanceof Bitacora)) {
            return false;
        }
        Bitacora other = (Bitacora) object;
        if ((this.codigoCita == null && other.codigoCita != null) || (this.codigoCita != null && !this.codigoCita.equals(other.codigoCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Bitacora[ codigoCita=" + codigoCita + " ]";
    }
    
}
