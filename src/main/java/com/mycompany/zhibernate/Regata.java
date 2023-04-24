package com.mycompany.zhibernate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
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
@Table(name = "Regata")
public class Regata implements Serializable {

    @Id
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fechaSalida")
    private String fechaSalida;
    @Column(name = "fechaLlegada")
    private String fechaLlegada;
    
    @ManyToMany(cascade={CascadeType.ALL},mappedBy="regatas")                //mapeado por la lista de barcos
    private Set<Barco> barcos=new HashSet();                                     // HashSet de barcos

    @ManyToMany(cascade={CascadeType.ALL},mappedBy="regatas")
    private Set<Puerto>puertos=new HashSet();
    
    public Regata() {
    }

    public Regata(String nombre, String fechaSalida, String fechaLlegada) {
        this.nombre = nombre;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    
    
}
