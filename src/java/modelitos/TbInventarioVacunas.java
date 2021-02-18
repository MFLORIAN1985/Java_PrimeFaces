/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelitos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MOORIS FLORIAN
 */
@Entity
@Table(name = "tb_inventario_vacunas", catalog = "vacunadb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbInventarioVacunas.findAll", query = "SELECT t FROM TbInventarioVacunas t")
    , @NamedQuery(name = "TbInventarioVacunas.findByIdInventarioVacuna", query = "SELECT t FROM TbInventarioVacunas t WHERE t.idInventarioVacuna = :idInventarioVacuna")
    , @NamedQuery(name = "TbInventarioVacunas.findByFechaCompra", query = "SELECT t FROM TbInventarioVacunas t WHERE t.fechaCompra = :fechaCompra")
    , @NamedQuery(name = "TbInventarioVacunas.findByFechaCaducidad", query = "SELECT t FROM TbInventarioVacunas t WHERE t.fechaCaducidad = :fechaCaducidad")
    , @NamedQuery(name = "TbInventarioVacunas.findByNumeroLote", query = "SELECT t FROM TbInventarioVacunas t WHERE t.numeroLote = :numeroLote")
    , @NamedQuery(name = "TbInventarioVacunas.findByPrecioLote", query = "SELECT t FROM TbInventarioVacunas t WHERE t.precioLote = :precioLote")
    , @NamedQuery(name = "TbInventarioVacunas.findByCantidadLote", query = "SELECT t FROM TbInventarioVacunas t WHERE t.cantidadLote = :cantidadLote")})
public class TbInventarioVacunas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INVENTARIO_VACUNA")
    private Integer idInventarioVacuna;
    @Column(name = "FECHA_COMPRA")
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    @Column(name = "FECHA_CADUCIDAD")
    @Temporal(TemporalType.DATE)
    private Date fechaCaducidad;
    @Size(max = 30)
    @Column(name = "NUMERO_LOTE")
    private String numeroLote;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO_LOTE")
    private BigDecimal precioLote;
    @Column(name = "CANTIDAD_LOTE")
    private Integer cantidadLote;
    @JoinColumn(name = "ID_TIPO_VACUNA", referencedColumnName = "ID_TIPO_VACUNA")
    @ManyToOne
    private CatTipoVacuna idTipoVacuna;
    @JoinColumn(name = "ID_LABORATORIO", referencedColumnName = "ID_LABORATORIO")
    @ManyToOne
    private CatLaboratorio idLaboratorio;
    @OneToMany(mappedBy = "idInventarioVacuna")
    private Collection<TbAplicacionDosis> tbAplicacionDosisCollection;

    public TbInventarioVacunas() {
    }

    public TbInventarioVacunas(Integer idInventarioVacuna) {
        this.idInventarioVacuna = idInventarioVacuna;
    }

    public Integer getIdInventarioVacuna() {
        return idInventarioVacuna;
    }

    public void setIdInventarioVacuna(Integer idInventarioVacuna) {
        this.idInventarioVacuna = idInventarioVacuna;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    public BigDecimal getPrecioLote() {
        return precioLote;
    }

    public void setPrecioLote(BigDecimal precioLote) {
        this.precioLote = precioLote;
    }

    public Integer getCantidadLote() {
        return cantidadLote;
    }

    public void setCantidadLote(Integer cantidadLote) {
        this.cantidadLote = cantidadLote;
    }

    public CatTipoVacuna getIdTipoVacuna() {
        return idTipoVacuna;
    }

    public void setIdTipoVacuna(CatTipoVacuna idTipoVacuna) {
        this.idTipoVacuna = idTipoVacuna;
    }

    public CatLaboratorio getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(CatLaboratorio idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    @XmlTransient
    public Collection<TbAplicacionDosis> getTbAplicacionDosisCollection() {
        return tbAplicacionDosisCollection;
    }

    public void setTbAplicacionDosisCollection(Collection<TbAplicacionDosis> tbAplicacionDosisCollection) {
        this.tbAplicacionDosisCollection = tbAplicacionDosisCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInventarioVacuna != null ? idInventarioVacuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbInventarioVacunas)) {
            return false;
        }
        TbInventarioVacunas other = (TbInventarioVacunas) object;
        if ((this.idInventarioVacuna == null && other.idInventarioVacuna != null) || (this.idInventarioVacuna != null && !this.idInventarioVacuna.equals(other.idInventarioVacuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelitos.TbInventarioVacunas[ idInventarioVacuna=" + idInventarioVacuna + " ]";
    }
    
}
