/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelitos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MOORIS FLORIAN
 */
@Entity
@Table(name = "tb_aplicacion_dosis", catalog = "vacunadb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAplicacionDosis.findAll", query = "SELECT t FROM TbAplicacionDosis t")
    , @NamedQuery(name = "TbAplicacionDosis.findByIdAplicacion", query = "SELECT t FROM TbAplicacionDosis t WHERE t.idAplicacion = :idAplicacion")
    , @NamedQuery(name = "TbAplicacionDosis.findByFechaAplicacion", query = "SELECT t FROM TbAplicacionDosis t WHERE t.fechaAplicacion = :fechaAplicacion")
    , @NamedQuery(name = "TbAplicacionDosis.findByCantidadAplicada", query = "SELECT t FROM TbAplicacionDosis t WHERE t.cantidadAplicada = :cantidadAplicada")})
public class TbAplicacionDosis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_APLICACION")
    private Integer idAplicacion;
    @Column(name = "FECHA_APLICACION")
    @Temporal(TemporalType.DATE)
    private Date fechaAplicacion;
    @Column(name = "CANTIDAD_APLICADA")
    private Integer cantidadAplicada;
    @JoinColumn(name = "ID_INVENTARIO_VACUNA", referencedColumnName = "ID_INVENTARIO_VACUNA")
    @ManyToOne
    private TbInventarioVacunas idInventarioVacuna;
    @JoinColumn(name = "CUI", referencedColumnName = "CUI")
    @ManyToOne
    private TbPersona cui;

    public TbAplicacionDosis() {
    }

    public TbAplicacionDosis(Integer idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public Integer getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(Integer idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public Date getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(Date fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public Integer getCantidadAplicada() {
        return cantidadAplicada;
    }

    public void setCantidadAplicada(Integer cantidadAplicada) {
        this.cantidadAplicada = cantidadAplicada;
    }

    public TbInventarioVacunas getIdInventarioVacuna() {
        return idInventarioVacuna;
    }

    public void setIdInventarioVacuna(TbInventarioVacunas idInventarioVacuna) {
        this.idInventarioVacuna = idInventarioVacuna;
    }

    public TbPersona getCui() {
        return cui;
    }

    public void setCui(TbPersona cui) {
        this.cui = cui;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAplicacion != null ? idAplicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAplicacionDosis)) {
            return false;
        }
        TbAplicacionDosis other = (TbAplicacionDosis) object;
        if ((this.idAplicacion == null && other.idAplicacion != null) || (this.idAplicacion != null && !this.idAplicacion.equals(other.idAplicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelitos.TbAplicacionDosis[ idAplicacion=" + idAplicacion + " ]";
    }
    
}
