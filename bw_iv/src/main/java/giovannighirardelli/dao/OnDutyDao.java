package giovannighirardelli.dao;

import giovannighirardelli.entities.OnDuty;
import giovannighirardelli.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class OnDutyDao {
    private final EntityManager em;

    public OnDutyDao(EntityManager em) {
        this.em = em;
    }

    public void ondDutySave(OnDuty onDuty) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(onDuty);
        transaction.commit();
        System.out.println("Servizio:" + onDuty.getId() + "inserito correttamente nel db!");
    }

    public OnDuty findById(String id) {
        OnDuty onDuty = em.find(OnDuty.class, UUID.fromString(id));
        if (onDuty == null) throw new NotFoundException(id);
        return onDuty;
    }

    public void findAndDeleteById(String id) {
        OnDuty found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Servizio:" + found.getId() + "è stato correttamente eliminato");
    }

}
