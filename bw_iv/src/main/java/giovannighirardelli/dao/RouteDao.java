package giovannighirardelli.dao;

import giovannighirardelli.entities.Retailer;
import giovannighirardelli.entities.Route;
import giovannighirardelli.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class RouteDao {

    private final EntityManager em;

    public RouteDao(EntityManager em) {
        this.em = em;
    }

    public void routeSave(Route route) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(route);
        transaction.commit();
        System.out.println("Tratta con id: " +  route.getId() + " inserito correttamente nel db!");
    }

    public Route findById(String id) {
        Route route = em.find(Route.class, UUID.fromString(id));
        if (route == null) throw new NotFoundException(id);
        return route;
    }

    public void findAndDeleteById(String id) {
        Route found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Tratta con id: " + found.getId() + "è stato correttamente eliminato");
    }

}
