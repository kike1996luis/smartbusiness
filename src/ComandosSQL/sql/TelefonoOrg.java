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
@Table(name = "TELEFONO_ORG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelefonoOrg.findAll", query = "SELECT t FROM TelefonoOrg t")
    , @NamedQuery(name = "TelefonoOrg.findById", query = "SELECT t FROM TelefonoOrg t WHERE t.id = :id")
    , @NamedQuery(name = "TelefonoOrg.findByTelefono", query = "SELECT t FROM TelefonoOrg t WHERE t.telefono = :telefono")})
public class TelefonoOrg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TELEFONO")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "telefonoOrgId")
    private Collection<Organizacion> organizacionCollection;

    public TelefonoOrg() {
    }

    public TelefonoOrg(Integer id) {
        this.id = id;
    }

    public TelefonoOrg(Integer id, String telefono) {
        this.id = id;
        this.telefono = telefono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public Collection<Organizacion> getOrganizacionCollection() {
        return organizacionCollection;
    }

    public void setOrganizacionCollection(Collection<Organizacion> organizacionCollection) {
        this.organizacionCollection = organizacionCollection;
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
        if (!(object instanceof TelefonoOrg)) {
            return false;
        }
        TelefonoOrg other = (TelefonoOrg) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ComandosSQL.sql.TelefonoOrg[ id=" + id + " ]";
    }
    
}
