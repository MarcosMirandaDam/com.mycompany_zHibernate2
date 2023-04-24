
package com.mycompany.zhibernate;

/**
 *
 * @author Marcos Miranda
 */


import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Amarre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;

    @OneToOne(cascade = CascadeType.ALL)
    private Barco barco;

    public Amarre() {
    }

    public Amarre(int numero) {
        this.numero = numero;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
   
    this.barco = barco;

}

}
