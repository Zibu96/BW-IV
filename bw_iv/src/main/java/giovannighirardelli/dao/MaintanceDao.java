package giovannighirardelli.dao;

import giovannighirardelli.entities.Card;
import giovannighirardelli.entities.Maintenance;
import giovannighirardelli.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class MaintanceDao {

    private final EntityManager em;

    public MaintanceDao(EntityManager em) {
        this.em = em;
    }

    public void maintananceSave(Maintenance maintenance ) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(maintenance);
        transaction.commit();
        System.out.println("Manutenzione:" + maintenance.getDescription() + "inserita correttamente nel db!");
    }

    public Maintenance findById(String id) {
        Maintenance maintenance = em.find(Maintenance.class, UUID.fromString(id));
        if (maintenance == null) throw new NotFoundException(id);
        return maintenance;
    }

    public void findAndDeleteById(String id) {
        Maintenance found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Manutenzione:" + found.getDescription() + "è stata correttamente eliminata");
    }
}
