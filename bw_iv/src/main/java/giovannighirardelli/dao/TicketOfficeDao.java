package giovannighirardelli.dao;

import giovannighirardelli.entities.PublicTransport;
import giovannighirardelli.entities.Ticket;
import giovannighirardelli.entities.TicketOffice;
import giovannighirardelli.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
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
        System.out.println("Titolo viaggio con id: " + ticketOffice.getTitleId() + " inserito correttamente nel db!");
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

    public void validateTicket(String ticketId, String transportId) {
        Ticket foundTicket = em.find(Ticket.class, UUID.fromString(ticketId));
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        foundTicket.setValidation(true);
        foundTicket.setValidationDate(LocalDate.now());
        PublicTransport foundPublicTransport = em.find(PublicTransport.class, UUID.fromString(transportId));
        foundTicket.setPublicTransport(foundPublicTransport);
        transaction.commit();
        System.out.println("Biglietto con id: " + foundTicket + "validato sul mezzo " + foundPublicTransport);
    }

    public void getTicketByTransport(String id) {
        TypedQuery<Ticket> query = em.createQuery("SELECT a FROM Ticket a WHERE a.publicTransport.id = :id", Ticket.class);
        query.setParameter("id", UUID.fromString(id));
        if (query.getResultList().isEmpty()) System.out.println("Nessun biglietto validato su questo mezzo");
        else {
            query.getResultList().forEach(System.out::println);
            System.out.println("su questo mezzo sono stati validati " + query.getResultList().size() + " biglietti");
        }
    }

    public void getTicketByDate(LocalDate init, LocalDate end) {
        TypedQuery<Ticket> query = em.createQuery("SELECT a FROM Ticket a WHERE a.validationDate  > :init AND a.validationDate < :end", Ticket.class);
        query.setParameter("init", init);
        query.setParameter("end", end);
        if (query.getResultList().isEmpty()) System.out.println("Nessun biglietto validato su questo mezzo");
        else {
            query.getResultList().forEach(System.out::println);
            System.out.println("In questo intervallo di tempo sono stati validati " + query.getResultList().size() + " biglietti");
        }
    }
}
