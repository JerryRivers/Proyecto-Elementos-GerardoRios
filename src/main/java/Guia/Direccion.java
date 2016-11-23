/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guia;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Gerardo.Rios
 */
@Entity
public class Direccion {
    @Id
    @GeneratedValue
    private Long id;
    private Integer numero;
    private Integer cp;
    private String colonia;

    public Direccion() {
    }

    public Direccion(Long id) {
        this.id = id;
    }      
    
    public Direccion(Integer numero) {
        this.numero = numero;
    }
    
    public Direccion(String colonia) {
        this.colonia = colonia;
    }
    
    public Direccion(Long id, Integer numero, Integer cp, String colonia) {
        this.id = id;
        this.numero = numero;
        this.cp = cp;
        this.colonia = colonia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    
    
}
