/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComandosSQL.sql;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HOME
 */
@Entity
@Table(name = "ORGANIZACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organizacion.findAll", query = "SELECT o FROM Organizacion o")
    , @NamedQuery(name = "Organizacion.findById", query = "SELECT o FROM Organizacion o WHERE o.id = :id")
    , @NamedQuery(name = "Organizacion.findByNombre", query = "SELECT o FROM Organizacion o WHERE o.nombre = :nombre")})
public class Organizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    private Collection<Producto> productoCollection;
    @JoinColumn(name = "DIRECCION_ORG_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private DireccionOrg direccionOrgId;
    @JoinColumn(name = "TELEFONO_ORG_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TelefonoOrg telefonoOrgId;

    public Organizacion() {
    }

    public Organizacion(Integer id) {
        this.id = id;
    }

    public Organizacion(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    public DireccionOrg getDireccionOrgId() {
        return direccionOrgId;
    }

    public void setDireccionOrgId(DireccionOrg direccionOrgId) {
        this.direccionOrgId = direccionOrgId;
    }

    public TelefonoOrg getTelefonoOrgId() {
        return telefonoOrgId;
    }

    public void setTelefonoOrgId(TelefonoOrg telefonoOrgId) {
        this.telefonoOrgId = telefonoOrgId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organizacion)) {
            return false;
        }
        Organizacion other = (Organizacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ComandosSQL.sql.Organizacion[ id=" + id + " ]";
    }
    
}
