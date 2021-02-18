/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelitos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "tb_persona", catalog = "vacunadb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPersona.findAll", query = "SELECT t FROM TbPersona t")
    , @NamedQuery(name = "TbPersona.findByCui", query = "SELECT t FROM TbPersona t WHERE t.cui = :cui")
    , @NamedQuery(name = "TbPersona.findByNombre", query = "SELECT t FROM TbPersona t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TbPersona.findByFechaNacimiento", query = "SELECT t FROM TbPersona t WHERE t.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "TbPersona.findByDireccion", query = "SELECT t FROM TbPersona t WHERE t.direccion = :direccion")
    , @NamedQuery(name = "TbPersona.findByTelefonoMovil", query = "SELECT t FROM TbPersona t WHERE t.telefonoMovil = :telefonoMovil")
    , @NamedQuery(name = "TbPersona.findByTelefonoCasa", query = "SELECT t FROM TbPersona t WHERE t.telefonoCasa = :telefonoCasa")
    , @NamedQuery(name = "TbPersona.findByNombreEncargado", query = "SELECT t FROM TbPersona t WHERE t.nombreEncargado = :nombreEncargado")
    , @NamedQuery(name = "TbPersona.findByCuiEncargado", query = "SELECT t FROM TbPersona t WHERE t.cuiEncargado = :cuiEncargado")})
public class TbPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    private String cui;
    @Size(max = 100)
    private String nombre;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 100)
    private String direccion;
    @Size(max = 20)
    @Column(name = "TELEFONO_MOVIL")
    private String telefonoMovil;
    @Size(max = 20)
    @Column(name = "TELEFONO_CASA")
    private String telefonoCasa;
    @Size(max = 100)
    @Column(name = "NOMBRE_ENCARGADO")
    private String nombreEncargado;
    @Size(max = 13)
    @Column(name = "CUI_ENCARGADO")
    private String cuiEncargado;
    @OneToMany(mappedBy = "cui")
    private Collection<TbAplicacionDosis> tbAplicacionDosisCollection;

    public TbPersona() {
    }

    public TbPersona(String cui) {
        this.cui = cui;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getTelefonoCasa() {
        return telefonoCasa;
    }

    public void setTelefonoCasa(String telefonoCasa) {
        this.telefonoCasa = telefonoCasa;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    public String getCuiEncargado() {
        return cuiEncargado;
    }

    public void setCuiEncargado(String cuiEncargado) {
        this.cuiEncargado = cuiEncargado;
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
        hash += (cui != null ? cui.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPersona)) {
            return false;
        }
        TbPersona other = (TbPersona) object;
        if ((this.cui == null && other.cui != null) || (this.cui != null && !this.cui.equals(other.cui))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelitos.TbPersona[ cui=" + cui + " ]";
    }
    
}
