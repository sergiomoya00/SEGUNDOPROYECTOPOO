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
@Table(name = "catalogodiagnosticos")
@NamedQueries({
    @NamedQuery(name = "Catalogodiagnosticos.findAll", query = "SELECT c FROM Catalogodiagnosticos c")
    , @NamedQuery(name = "Catalogodiagnosticos.findByNombreDiagnostico", query = "SELECT c FROM Catalogodiagnosticos c WHERE c.nombreDiagnostico = :nombreDiagnostico")})
public class Catalogodiagnosticos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombreDiagnostico", nullable = false, length = 50)
    private String nombreDiagnostico;
    @OneToMany(mappedBy = "nombreDiagnostico")
    private Collection<Catalogotratamientos> catalogotratamientosCollection;

    public Catalogodiagnosticos() {
    }

    public Catalogodiagnosticos(String nombreDiagnostico) {
        this.nombreDiagnostico = nombreDiagnostico;
    }

    public String getNombreDiagnostico() {
        return nombreDiagnostico;
    }

    public void setNombreDiagnostico(String nombreDiagnostico) {
        this.nombreDiagnostico = nombreDiagnostico;
    }

    public Collection<Catalogotratamientos> getCatalogotratamientosCollection() {
        return catalogotratamientosCollection;
    }

    public void setCatalogotratamientosCollection(Collection<Catalogotratamientos> catalogotratamientosCollection) {
        this.catalogotratamientosCollection = catalogotratamientosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreDiagnostico != null ? nombreDiagnostico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalogodiagnosticos)) {
            return false;
        }
        Catalogodiagnosticos other = (Catalogodiagnosticos) object;
        if ((this.nombreDiagnostico == null && other.nombreDiagnostico != null) || (this.nombreDiagnostico != null && !this.nombreDiagnostico.equals(other.nombreDiagnostico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Catalogodiagnosticos[ nombreDiagnostico=" + nombreDiagnostico + " ]";
    }
    
}
