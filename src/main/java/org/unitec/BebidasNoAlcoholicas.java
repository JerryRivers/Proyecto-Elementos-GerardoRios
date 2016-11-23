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
public class BebidasNoAlcoholicas implements TipoBebida
{
    String nombre;
    //String ObtenerLista()
    @Override
    public String ObtenerRecomendacion() 
    {
        String Bebidas="Coca-Cola, Agua, Ginger Ale, Gatorade";
        return Bebidas;
    }  
}
