package giovannighirardelli.dao;

import giovannighirardelli.entities.TransportRoute;
import giovannighirardelli.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class TransportRouteDao {
    private final EntityManager em;

    public TransportRouteDao(EntityManager em) {
        this.em = em;
    }

    public void transportRouteSave(TransportRoute transportRoute) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(transportRoute);
        transaction.commit();
        System.out.println("La tratta del mezzo: " + transportRoute.getPublicTransport() + " inserita correttamente nel db!");
    }

    public TransportRoute findById(String id) {
        TransportRoute transportRoute = em.find(TransportRoute.class, UUID.fromString(id));
        if (transportRoute == null) throw new NotFoundException(id);
        return transportRoute;
    }

    public void findAndDeleteById(String id) {
        TransportRoute found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("La tratta del mezzo: " + found.getPublicTransport() + "è stata correttamente eliminato");
    }

}
