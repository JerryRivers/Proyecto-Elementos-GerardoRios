/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guia;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Gerardo.Rios
 */
@Entity
public class Persona 
{
    @Id
    @GeneratedValue
    private Long id;
    
    @OneToOne
    @JoinColumn(name="id_direccion")
    private Long dir;
   
    private String nombre;
    private String telefono;

    public Persona() {
    }

    public Persona(Long id) {
        this.id = id;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona(Long id, Long dir, String nombre, String telefono) {
        this.id = id;
        this.dir = dir;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDir() {
        return dir;
    }

    public void setDir(Long dir) {
        this.dir = dir;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
            
}
