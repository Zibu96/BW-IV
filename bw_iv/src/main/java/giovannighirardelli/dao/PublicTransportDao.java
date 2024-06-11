package giovannighirardelli.dao;

import giovannighirardelli.entities.PublicTransport;
import giovannighirardelli.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PublicTransportDao {

    private final EntityManager em;

    public PublicTransportDao(EntityManager em) {
        this.em = em;
    }

    public void publicTransportSave(PublicTransport publicTransport) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(publicTransport);
        transaction.commit();
        System.out.println("Mezzo: " + publicTransport.getTypePublicTrasport() + " inserito correttamente nel db!");
    }

    public PublicTransport findById(String id) {
        PublicTransport publicTransport = em.find(PublicTransport.class, UUID.fromString(id));
        if (publicTransport == null) throw new NotFoundException(id);
        return publicTransport;
    }

    public void findAndDeleteById(String id) {
        PublicTransport publicTransport = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(publicTransport);
        transaction.commit();
        System.out.println("Mezzo: " + publicTransport.getTypePublicTrasport() + " è stato correttamente eliminato");
    }

}
