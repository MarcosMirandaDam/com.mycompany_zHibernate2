
package com.mycompany.zhibernate;



import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Barco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private float eslora;

    @OneToOne(mappedBy = "barco", cascade = CascadeType.ALL)
    private Amarre amarre;
    
    @ManyToOne                                              //añadimos relacion a Propietario
    private Propietario propietario;

    @ManyToMany(cascade={CascadeType.ALL})                  //añadimos relacion a Regata
    private Set<Regata>regatas=new HashSet();
    
    public Barco() {
    }

    public Barco(String nombre, float eslora) {
        this.nombre = nombre;
        this.eslora = eslora;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getEslora() {
        return eslora;
    }

    public void setEslora(float eslora) {
        this.eslora = eslora;
    }

    public Amarre getAmarre() {
        return amarre;
    }

   public void setAmarre(Amarre amarre) {
    this.amarre = amarre;
   }

}