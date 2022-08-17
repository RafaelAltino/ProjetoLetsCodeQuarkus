package br.com.rafael.service;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
    @Transactional
    public long create(Client client) {
        em.persist(client);
        return client.getId();
    }

    @Override
    public Client getById(long id) {        
        return em.find(Client.class, id);
    }

    @Override
    @Transactional
    public void delete(long id) {
        Client client = getById(id);
        em.remove(client);
        
    }
    
}
