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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jabre
 */
@Entity
@Table(name = "catalogotratamientos")
@NamedQueries({
    @NamedQuery(name = "Catalogotratamientos.findAll", query = "SELECT c FROM Catalogotratamientos c")
    , @NamedQuery(name = "Catalogotratamientos.findByTratamiento", query = "SELECT c FROM Catalogotratamientos c WHERE c.tratamiento = :tratamiento")})
public class Catalogotratamientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tratamiento", nullable = false, length = 50)
    private String tratamiento;
    @JoinColumn(name = "nombreDiagnostico", referencedColumnName = "nombreDiagnostico")
    @ManyToOne
    private Catalogodiagnosticos nombreDiagnostico;

    public Catalogotratamientos() {
    }

    public Catalogotratamientos(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Catalogodiagnosticos getNombreDiagnostico() {
        return nombreDiagnostico;
    }

    public void setNombreDiagnostico(Catalogodiagnosticos nombreDiagnostico) {
        this.nombreDiagnostico = nombreDiagnostico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tratamiento != null ? tratamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalogotratamientos)) {
            return false;
        }
        Catalogotratamientos other = (Catalogotratamientos) object;
        if ((this.tratamiento == null && other.tratamiento != null) || (this.tratamiento != null && !this.tratamiento.equals(other.tratamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Catalogotratamientos[ tratamiento=" + tratamiento + " ]";
    }
    
}
