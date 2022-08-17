package br.com.rafael.rest;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.rafael.model.Client;
import br.com.rafael.service.ClientService;

@Path("/client")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientResource {

    @Inject
    ClientService clientService;
    
    @GET
    @Path("/list")
    public List<Client> listClients(){
        return clientService.list();
    }

    @PUT
    public Response create(Client client){
        long id = clientService.create(client);
        return Response.created(URI.create("http://localhost:8080/client/list" + id)).build();
    }

    @Path("/{id}")
    @GET
    public Client getClientById(@PathParam("id") long id){
        return clientService.getById(id);
    }

    @DELETE
    @Path("/{id}")
    public void deleteClient(@PathParam("id") long id){
        Client client = clientService.getById(id);
        if(client == null){
            throw new WebApplicationException(404);
        }
        clientService.delete(id);
    }
}
