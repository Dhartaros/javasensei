/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasensei.tutor.rest;

import java.time.ZonedDateTime;
import java.util.Date;
import javasensei.db.managments.ChatManager;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Rock
 */
@Path("chat")
public class ChatRest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Chat
     */
    public ChatRest() {
    }

    @POST
    @Path("agregarmensaje")
    @Produces(MediaType.TEXT_HTML)
    public String agregarMensaje(@FormParam("message") String message, 
            @FormParam("nombreUsuario") String nombreUsuario, 
            @FormParam("idUsuario") String idUsuario,
            @FormParam("idEjercicio") Integer idEjercicio,
            @FormParam("color") String color){        
        String result = new ChatManager().agregarMensaje(message, nombreUsuario, idUsuario, idEjercicio, color);
        
        return result;
    }
    
    @POST
    @Path("leermensajes")
    @Produces(MediaType.APPLICATION_JSON)
    public String leerMensajes(@FormParam("fechaActual") Long fechaActual, @FormParam("idEjercicio") Integer idEjercicio){        
        return new ChatManager().leerMensajes(fechaActual, idEjercicio);
    }
    
    @POST
    @Path("cargarmensajes")
    @Produces(MediaType.APPLICATION_JSON)
    public String cargarMensajes(@FormParam("cantidad") Integer cantidad, @FormParam("idEjercicio") Integer idEjercicio){
        return new ChatManager().cargarMensajes(cantidad, idEjercicio);
    }
}
