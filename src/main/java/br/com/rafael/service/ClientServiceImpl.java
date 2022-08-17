package br.com.rafael.service;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafael.model.Client;

@ApplicationScoped
public class ClientServiceImpl implements ClientService{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Client> list() {
        return em.createQuery("select e from Client e", Client.class).getResultList();
    }

    @Override
    public long create(Client client) {
        em.persist(client);
        return client.getId();
    }
    
}
