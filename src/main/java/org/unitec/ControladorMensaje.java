/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gerardo.Rios
 */
@RestController
public class ControladorMensaje 
{
    @Autowired RepositorioMensaje repoMsg;
    //@CrossOrigin sirve para que las funciones REST funcionen en el navegador web
    @CrossOrigin
    //Primero hacemos método para guardar
    //Sintaxis de: @RequestMapping(uri,metodo,formato_de_info(recepcion/envio))
    //----------------------Guardar---------------------------
    @RequestMapping(value="/mensaje/[titulo]/{cuerpo}", method=RequestMethod.POST, headers={"Accept=text/html"})
    public String guardar(@PathVariable String titulo, @PathVariable String cuerpo)
    {
        repoMsg.save(new Mensaje(titulo, cuerpo));
        return "Mensaje guardado con exito!!!";
    }
    //----------------------BuscarTodos-----------------------
    @CrossOrigin
    @RequestMapping(value="/mensaje", method=RequestMethod.GET, headers={"Accept=application/json"})
    public String buscarTodos() throws Exception
    {
        ArrayList<Mensaje> mensajes=(ArrayList<Mensaje>) repoMsg.findAll();
        ObjectMapper mapeo=new ObjectMapper();
        return mapeo.writeValueAsString(mensajes);
    }
    //-----------------------BuscarId-------------------------
    @CrossOrigin
    @RequestMapping(value="/mensaje/{id}", method=RequestMethod.GET, headers={"Accept=application/json"})
    public String buscarId(@PathVariable Long id) throws Exception
    {
        Mensaje mensajes=repoMsg.findOne(id);
        ObjectMapper mapeo=new ObjectMapper();
        return mapeo.writeValueAsString(mensajes);
    }
    //---------------------Actualizar-------------------------
    @CrossOrigin
    @RequestMapping(value="/mensaje/{id}/{titulo}/{cuerpo}", method=RequestMethod.PUT, headers={"Accept=text/html"})
    public String Actualizar(@PathVariable Long id, @PathVariable String titulo, @PathVariable String cuerpo)
    {
        Mensaje mensajes=new Mensaje(id,titulo,cuerpo);
        repoMsg.save(mensajes);
        return "Mensaje Actualizado con éxito";
    }
    //----------------------BorrarID--------------------------
    @CrossOrigin
    @RequestMapping(value="/mensaje/{id}", method=RequestMethod.DELETE, headers={"Accept=text/html"})
    public String BorrarId(@PathVariable Long id)throws Exception
    {
        //Mensaje mensajes=new Mensaje(id);
        repoMsg.delete(id);
        return "Registro borrado con éxito";
    }
    
}
