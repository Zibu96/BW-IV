package giovannighirardelli.dao;

import giovannighirardelli.entities.Route;
import giovannighirardelli.entities.TicketOffice;
import giovannighirardelli.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class TicketOfficeDao {

    private final EntityManager em;

    public TicketOfficeDao(EntityManager em) {
        this.em = em;
    }

    public void ticketOfficeSave(TicketOffice ticketOffice) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(ticketOffice);
        transaction.commit();
        System.out.println("Titolo viaggio con id: " +  ticketOffice.getTitleId() + " inserito correttamente nel db!");
    }

    public TicketOffice findById(String id) {
        TicketOffice ticketOffice = em.find(TicketOffice.class, UUID.fromString(id));
        if (ticketOffice == null) throw new NotFoundException(id);
        return ticketOffice;
    }

    public void findAndDeleteById(String id) {
        TicketOffice found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Titolo viaggio con id: " + found.getTitleId() + "è stato correttamente eliminato");
    }

}
