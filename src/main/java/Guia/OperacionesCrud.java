/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guia;

import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.Position;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Gerardo.Rios
 */
public class OperacionesCrud extends UI
{
    @Autowired RepositorioDireccion repoDir;
    @Autowired RepositorioPersona repoPer;

    @Override
    protected void init(VaadinRequest request) 
    {
        //Creamos un LayOut
        VerticalLayout layout=new VerticalLayout();
        //layout.setWidth("1000");
        layout.setMargin(true);
        
        //Generamos una Etiqueta
        Label etiqueta=new Label("Mi primera etiqueta");
        layout.addComponent(etiqueta);
        layout.setComponentAlignment(etiqueta, Alignment.TOP_CENTER);
        
        //Creamos un boton para guardar
        Button boton=new Button("Guardar");
        layout.addComponent(boton);
        
        //Creaos otro boton 
        Button boton2=new Button("Buscar por ID");
        layout.addComponent(boton2);
        boton2.setDescription("BuscarID");
        
        //Label etiqueta=new Label();
        boton.setDescription("Guardar");
        
        boton.addClickListener(
            (Button.ClickEvent cliqueo) -> 
            {    
                //Creamos un objeto Persona llamado p1 y llamamos su método, save.
                Persona p1=new Persona();
                repoPer.save(p1);

                //El siguiente es el constructor de la clase Notification:
                Notification notif = new Notification(
                "Registro Guardado",Notification.Type.HUMANIZED_MESSAGE);

                //Algunas propiedades de la clase notificacion
                notif.setDelayMsec(2000);
                notif.setPosition(Position.MIDDLE_CENTER);

                notif.show(Page.getCurrent());
            });
        
        boton2.addClickListener(
            (Button.ClickEvent cliqueo) -> 
            {    
                //Creamos un objeto Direccion llamado d1 y llamamos su método, save.
                Direccion d1=new Direccion();
                repoDir.findAll();

                //El siguiente es el constructor de la clase Notification:
                Notification notif = new Notification(
                "Registro Guardado",Notification.Type.HUMANIZED_MESSAGE);

                //Algunas propiedades de la clase notificacion
                notif.setDelayMsec(2000);
                notif.setPosition(Position.MIDDLE_CENTER);

                notif.show(Page.getCurrent());
            });
            /*

            repoDir.findOne(Long.MIN_VALUE);
            */
            
        //La siguiente linea siempre va al final ya que carga todo el contenido
        setContent(layout); 
    }   
}
