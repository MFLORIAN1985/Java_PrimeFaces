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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MOORIS FLORIAN
 */
@Entity
@Table(name = "cat_tipo_vacuna", catalog = "vacunadb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatTipoVacuna.findAll", query = "SELECT c FROM CatTipoVacuna c")
    , @NamedQuery(name = "CatTipoVacuna.findByIdTipoVacuna", query = "SELECT c FROM CatTipoVacuna c WHERE c.idTipoVacuna = :idTipoVacuna")
    , @NamedQuery(name = "CatTipoVacuna.findByNombreVacuna", query = "SELECT c FROM CatTipoVacuna c WHERE c.nombreVacuna = :nombreVacuna")
    , @NamedQuery(name = "CatTipoVacuna.findByEfectosAdversos", query = "SELECT c FROM CatTipoVacuna c WHERE c.efectosAdversos = :efectosAdversos")
    , @NamedQuery(name = "CatTipoVacuna.findByModoAlmacen", query = "SELECT c FROM CatTipoVacuna c WHERE c.modoAlmacen = :modoAlmacen")
    , @NamedQuery(name = "CatTipoVacuna.findByCantidadAplicaciones", query = "SELECT c FROM CatTipoVacuna c WHERE c.cantidadAplicaciones = :cantidadAplicaciones")})
public class CatTipoVacuna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_VACUNA")
    private Integer idTipoVacuna;
    @Size(max = 45)
    @Column(name = "NOMBRE_VACUNA")
    private String nombreVacuna;
    @Size(max = 100)
    @Column(name = "EFECTOS_ADVERSOS")
    private String efectosAdversos;
    @Size(max = 100)
    @Column(name = "MODO_ALMACEN")
    private String modoAlmacen;
    @Size(max = 30)
    @Column(name = "CANTIDAD_APLICACIONES")
    private String cantidadAplicaciones;
    @JoinColumn(name = "ID_LABORATORIO", referencedColumnName = "ID_LABORATORIO")
    @ManyToOne
    private CatLaboratorio idLaboratorio;
    @OneToMany(mappedBy = "idTipoVacuna")
    private Collection<TbInventarioVacunas> tbInventarioVacunasCollection;

    public CatTipoVacuna() {
    }

    public CatTipoVacuna(Integer idTipoVacuna) {
        this.idTipoVacuna = idTipoVacuna;
    }

    public Integer getIdTipoVacuna() {
        return idTipoVacuna;
    }

    public void setIdTipoVacuna(Integer idTipoVacuna) {
        this.idTipoVacuna = idTipoVacuna;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public String getEfectosAdversos() {
        return efectosAdversos;
    }

    public void setEfectosAdversos(String efectosAdversos) {
        this.efectosAdversos = efectosAdversos;
    }

    public String getModoAlmacen() {
        return modoAlmacen;
    }

    public void setModoAlmacen(String modoAlmacen) {
        this.modoAlmacen = modoAlmacen;
    }

    public String getCantidadAplicaciones() {
        return cantidadAplicaciones;
    }

    public void setCantidadAplicaciones(String cantidadAplicaciones) {
        this.cantidadAplicaciones = cantidadAplicaciones;
    }

    public CatLaboratorio getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(CatLaboratorio idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
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
        hash += (idTipoVacuna != null ? idTipoVacuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatTipoVacuna)) {
            return false;
        }
        CatTipoVacuna other = (CatTipoVacuna) object;
        if ((this.idTipoVacuna == null && other.idTipoVacuna != null) || (this.idTipoVacuna != null && !this.idTipoVacuna.equals(other.idTipoVacuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelitos.CatTipoVacuna[ idTipoVacuna=" + idTipoVacuna + " ]";
    }
    
}
