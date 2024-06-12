package giovannighirardelli.dao;

import giovannighirardelli.entities.Retailer;
import giovannighirardelli.entities.Ticket;
import giovannighirardelli.entities.VendingMachine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class QueriesUtilitiesDao {
    private EntityManager em;

    public QueriesUtilitiesDao (EntityManager em){
        this.em = em;
    }
    public List<Ticket> findAllTicketsFromVendingMachine (LocalDate intervalloTempo){
        TypedQuery<Ticket> query = em.createQuery("SELECT a.ticketOffice FROM VendingMachine a WHERE a.ticketOffice.emissionDate = :intervalloTempo", Ticket.class);
        query.setParameter("intervalloTempo", intervalloTempo);
        return query.getResultList();
    }
    public List<Ticket> findAllTicketsFromAuthorised (LocalDate intervalloTempo){
        TypedQuery<Ticket> query = em.createQuery("SELECT a.ticketOffice FROM Authorised a WHERE a.ticketOffice.emissionDate = :intervalloTempo", Ticket.class);
        query.setParameter("intervalloTempo", intervalloTempo);
        return query.getResultList();
    }

}
