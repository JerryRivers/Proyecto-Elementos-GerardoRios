/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec;

import com.vaadin.annotations.Theme;
import com.vaadin.server.ClassResource;
import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.Position;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import java.io.File;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author T-107
 */
@SpringUI
@Theme("valo")
public class MiUI extends UI
{
    @Autowired AplicacionServicio bebidas;
    @Autowired RepositorioEstacionamiento repoPark;
    @Autowired RepositorioCliente repoCliente;
    
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
         
        //Generamos un boton
        Button boton=new Button("Mi primer boton");
        layout.addComponent(boton);
        Label etiquetaRecomendacion=new Label();
        
        //Agregamos
        //TipoBebida bebidas=new BebidasEnergeticas();
        etiquetaRecomendacion.setValue(bebidas.ObtenerBebida().ObtenerRecomendacion());
        layout.addComponent(etiquetaRecomendacion);
        
        //Cambiamos el estilo del boton
        boton.addStyleName(ValoTheme.BUTTON_DANGER);
        boton.setDescription("Clickeame");
        
                //Generamos una lambda para dar funcionalidad
        boton.addClickListener((Button.ClickEvent cliqueo) -> {
        
        Estacionamiento esta=new Estacionamiento(new Date());
        repoPark.save(esta);
        
        repoCliente.save(new Cliente(esta));
        
        
     //   repoPark.save(esta);
     //   repoCliente.save(new Cliente());
            
        //El siguiente es el constructor de la clase Notification:
        Notification notif = new Notification(
        "PELIGRO",
        "Haz oprimido el boton ",
        Type.HUMANIZED_MESSAGE);
            
        //Algunas propiedades de la clase notificacion
        notif.setDelayMsec(2000);
        notif.setPosition(Position.MIDDLE_CENTER);
        notif.setStyleName(ValoTheme.NOTIFICATION_SYSTEM);
          notif.setIcon(new FileResource(new File("src/main/resources/camera_test.png")));
        //notif.setIcon(new ClassResource("camera_test.png")); 

        // Mostrar el mensaje de notificacion en la pagina actual
        notif.show(Page.getCurrent());
        });
        
        //La siguiente linea siempre va al final ya que carga todo el contenido
        setContent(layout);
    } 
}
