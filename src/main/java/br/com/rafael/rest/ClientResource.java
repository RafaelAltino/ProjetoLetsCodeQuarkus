package br.com.rafael.rest;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.rafael.model.Client;
import br.com.rafael.service.ClientService;

@Path("/client/list")
public class ClientResource {

    @Inject
    ClientService clientService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> listClients(){
        return clientService.list();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Client client){
        long id = clientService.create(client);
        return Response.created(URI.create("http://localhost:8080/client/" + id)).build();
    }
}
