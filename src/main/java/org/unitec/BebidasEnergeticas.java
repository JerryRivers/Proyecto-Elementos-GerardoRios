/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec;

/**
 *
 * @author T-107
 */
public class BebidasEnergeticas implements TipoBebida
{
    @Override
    public String ObtenerRecomendacion() 
    {
        String Bebidas="Gatorade, Red Bull, Vive100, Monster, Viper";
        return Bebidas;
    }
}
