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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cat_laboratorio", catalog = "vacunadb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatLaboratorio.findAll", query = "SELECT c FROM CatLaboratorio c")
    , @NamedQuery(name = "CatLaboratorio.findByIdLaboratorio", query = "SELECT c FROM CatLaboratorio c WHERE c.idLaboratorio = :idLaboratorio")
    , @NamedQuery(name = "CatLaboratorio.findByNombreLaboratorio", query = "SELECT c FROM CatLaboratorio c WHERE c.nombreLaboratorio = :nombreLaboratorio")})
public class CatLaboratorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_LABORATORIO")
    private Integer idLaboratorio;
    @Size(max = 45)
    @Column(name = "NOMBRE_LABORATORIO")
    private String nombreLaboratorio;
    @OneToMany(mappedBy = "idLaboratorio")
    private Collection<CatTipoVacuna> catTipoVacunaCollection;
    @JoinColumn(name = "ID_PAIS", referencedColumnName = "ID_PAIS")
    @ManyToOne
    private CatPais idPais;
    @OneToMany(mappedBy = "idLaboratorio")
    private Collection<TbInventarioVacunas> tbInventarioVacunasCollection;

    public CatLaboratorio() {
    }

    public CatLaboratorio(Integer idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public Integer getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(Integer idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public String getNombreLaboratorio() {
        return nombreLaboratorio;
    }

    public void setNombreLaboratorio(String nombreLaboratorio) {
        this.nombreLaboratorio = nombreLaboratorio;
    }

    @XmlTransient
    public Collection<CatTipoVacuna> getCatTipoVacunaCollection() {
        return catTipoVacunaCollection;
    }

    public void setCatTipoVacunaCollection(Collection<CatTipoVacuna> catTipoVacunaCollection) {
        this.catTipoVacunaCollection = catTipoVacunaCollection;
    }

    public CatPais getIdPais() {
        return idPais;
    }

    public void setIdPais(CatPais idPais) {
        this.idPais = idPais;
    }

    @XmlTransient
    public Collection<TbInventarioVacunas> getTbInventarioVacunasCollection() {
        return tbInventarioVacunasCollection;
    }

    public void setTbInventarioVacunasCollection(Collection<TbInventarioVacunas> tbInventarioVacunasCollection) {
        this.tbInventarioVacunasCollection = tbInventarioVacunasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLaboratorio != null ? idLaboratorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatLaboratorio)) {
            return false;
        }
        CatLaboratorio other = (CatLaboratorio) object;
        if ((this.idLaboratorio == null && other.idLaboratorio != null) || (this.idLaboratorio != null && !this.idLaboratorio.equals(other.idLaboratorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelitos.CatLaboratorio[ idLaboratorio=" + idLaboratorio + " ]";
    }
    
}
