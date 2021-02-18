/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelitos;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MOORIS FLORIAN
 */
@Entity
@Table(name = "cat_pais", catalog = "vacunadb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatPais.findAll", query = "SELECT c FROM CatPais c")
    , @NamedQuery(name = "CatPais.findByIdPais", query = "SELECT c FROM CatPais c WHERE c.idPais = :idPais")
    , @NamedQuery(name = "CatPais.findByNombrePais", query = "SELECT c FROM CatPais c WHERE c.nombrePais = :nombrePais")})
public class CatPais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PAIS")
    private Integer idPais;
    @Size(max = 45)
    @Column(name = "NOMBRE_PAIS")
    private String nombrePais;
    @OneToMany(mappedBy = "idPais")
    private Collection<CatLaboratorio> catLaboratorioCollection;

    public CatPais() {
    }

    public CatPais(Integer idPais) {
        this.idPais = idPais;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    @XmlTransient
    public Collection<CatLaboratorio> getCatLaboratorioCollection() {
        return catLaboratorioCollection;
    }

    public void setCatLaboratorioCollection(Collection<CatLaboratorio> catLaboratorioCollection) {
        this.catLaboratorioCollection = catLaboratorioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPais != null ? idPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatPais)) {
            return false;
        }
        CatPais other = (CatPais) object;
        if ((this.idPais == null && other.idPais != null) || (this.idPais != null && !this.idPais.equals(other.idPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelitos.CatPais[ idPais=" + idPais + " ]";
    }
    
}
