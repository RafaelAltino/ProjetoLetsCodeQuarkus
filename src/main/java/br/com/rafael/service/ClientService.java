package br.com.rafael.service;

import java.util.List;

import br.com.rafael.model.Client;

public interface ClientService {
    
    List<Client> list();

    long create(Client client);

    Client getById(long id);

    void delete(long id);

}
