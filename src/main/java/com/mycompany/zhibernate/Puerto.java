
package com.mycompany.zhibernate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Marcos Miranda
 */

@Entity
@Table(name="Puerto")
public class Puerto implements Serializable{
    
    @Id
    @Column(name="Ciudad")
    private String ciudad;
    @Column(name="longitud")
    private String longitud;
    @Column(name="latitud")
    private String latitud;
    
    @ManyToMany(cascade={CascadeType.ALL},mappedBy="puertos")
    private Set<Regata>regatas=new HashSet();

    public Puerto() {
    }

    public Puerto(String ciudad, String longitud, String latitud) {
        this.ciudad = ciudad;
        this.longitud = longitud;
        this.latitud = latitud;
        
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

       
    
    
}
