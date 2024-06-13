package giovannighirardelli.dao;

import giovannighirardelli.entities.TransportRoute;
import giovannighirardelli.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

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

    public void findRouteByTransport(String id, String idRoute) {
        TypedQuery<TransportRoute> query = em.createQuery("SELECT a FROM TransportRoute a Where a.publicTransport.id = :id AND a.route.id = :idRoute", TransportRoute.class);
        query.setParameter("id", UUID.fromString(id));
        query.setParameter("idRoute", UUID.fromString(idRoute));
        if (query.getResultList().isEmpty()) System.out.println("Nessuna rotta è stata percorsa dal mezzo con : " + id);
        else {
            query.getResultList().forEach(System.out::println);
            System.out.println("il mezzo di trasporto ha percorso la tratta " + query.getResultList().size() + " volte");
        }
    }
}
