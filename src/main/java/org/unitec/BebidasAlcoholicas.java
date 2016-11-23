/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec;

//import java.util.ArrayList;

/**
 *
 * @author Jerry
 */
public class BebidasAlcoholicas implements TipoBebida
{
    String nombre;
    //String ObtenerLista()
    @Override
    public String ObtenerRecomendacion() 
    {
        String Bebidas="Brandy, Tequila, Whisky, Ron, Vodka, Mezcal";
        return Bebidas;
    }

    /*@Override
    public String ObtenerRecomendacion() 
    {
        
    }*/
}
