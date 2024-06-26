package giovannighirardelli.dao;

import giovannighirardelli.entities.OnDuty;
import giovannighirardelli.entities.Retailer;
import giovannighirardelli.entities.VendingMachine;
import giovannighirardelli.enums.TaskStatus;
import giovannighirardelli.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class RetailerDao {

    private final EntityManager em;

    public RetailerDao(EntityManager em) {
        this.em = em;
    }

    public void retailerSave(Retailer retailer) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(retailer);
        transaction.commit();
        System.out.println("Rivenditore: " +  retailer + " inserito correttamente nel db!");
    }

    public Retailer findById(String id) {
        Retailer retailer = em.find(Retailer.class, UUID.fromString(id));
        if (retailer == null) throw new NotFoundException(id);
        return retailer;
    }

    public void findAndDeleteById(String id) {
        Retailer found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Rivenditore: " + found.getId() + "è stato correttamente eliminato");
    }

    public void setStatusOfVendingMachine(TaskStatus taskStatus, String id) {
        VendingMachine vendingMachine = em.find(VendingMachine.class, UUID.fromString(id));
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        if (vendingMachine == null) throw new NotFoundException(id);
        else vendingMachine.setTaskStatus(taskStatus);
        transaction.commit();

        System.out.println("Rivenditore automatico: " + id + " ora è: " + taskStatus);
    }

}
