/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venta.maven.hibernate.entity;
////////////////////////Me la pelan todoos
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author emili
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdproducto", query = "SELECT p FROM Producto p WHERE p.idproducto = :idproducto"),
    @NamedQuery(name = "Producto.findByNombrep", query = "SELECT p FROM Producto p WHERE p.nombrep = :nombrep"),
    @NamedQuery(name = "Producto.findByPreciop", query = "SELECT p FROM Producto p WHERE p.preciop = :preciop"),
    @NamedQuery(name = "Producto.findByCantidadp", query = "SELECT p FROM Producto p WHERE p.cantidadp = :cantidadp")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproducto")
    private Integer idproducto;
    @Size(max = 50)
    @Column(name = "nombrep")
    private String nombrep;
    @Column(name = "preciop")
    private Integer preciop;
    @Column(name = "cantidadp")
    private Integer cantidadp;

    public Producto() {
    }

    public Producto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombrep() {
        return nombrep;
    }

    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }

    public Integer getPreciop() {
        return preciop;
    }

    public void setPreciop(Integer preciop) {
        this.preciop = preciop;
    }

    public Integer getCantidadp() {
        return cantidadp;
    }

    public void setCantidadp(Integer cantidadp) {
        this.cantidadp = cantidadp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "venta.maven.hibernate.entity.Producto[ idproducto=" + idproducto + " ]";
    }
    
}
