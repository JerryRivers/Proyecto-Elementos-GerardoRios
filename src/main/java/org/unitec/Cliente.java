/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Gerardo.Rios
 */
@Entity
public class Cliente implements Serializable
{
    @Id
    @GeneratedValue
    private Long id;
    
    @OneToOne
    @JoinColumn(name="id_estacionamiento")
    private Estacionamiento parking;
    private float pago;

    public Cliente(Estacionamiento parking) {
        this.parking = parking;
    }

    public Cliente(Estacionamiento parking, float pago) 
    {
        this.parking = parking;
        this.pago = pago;
    }

    public Cliente(Long id) 
    {
        this.id = id;
    }

    public Cliente(Long id, Estacionamiento parking, float pago) 
    {
        this.id = id;
        this.parking = parking;
        this.pago = pago;
    }

    public Cliente() 
    {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estacionamiento getParking() {
        return parking;
    }

    public void setParking(Estacionamiento parking) {
        this.parking = parking;
    }

    public float getPago() {
        return pago;
    }

    public void setPago(float pago) {
        this.pago = pago;
    }
}
