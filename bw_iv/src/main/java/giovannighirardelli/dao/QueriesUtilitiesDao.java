package giovannighirardelli.dao;

import giovannighirardelli.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class QueriesUtilitiesDao {
    private EntityManager em;

    public QueriesUtilitiesDao (EntityManager em){
        this.em = em;
    }
//    public List<Ticket> findAllTicketsFromVendingMachine (String intervalloTempo){
//        TypedQuery<Ticket> query = em.createQuery("SELECT a FROM TicketOffice a WHERE a.retailer.tipo_distributore LIKE :intervalloTempo", Ticket.class);
//        query.setParameter("intervalloTempo", intervalloTempo);
//        return query.getResultList();
//    }
//    public List<Ticket> findAllTicketsFromAuthorised (LocalDate intervalloTempo){
//        TypedQuery<Ticket> query = em.createQuery("SELECT a.ticketOffice FROM Authorised a WHERE a.ticketOffice.emissionDate = :intervalloTempo", Ticket.class);
//        query.setParameter("intervalloTempo", intervalloTempo);
//        return query.getResultList();
//    }
//    public List<Subscription> findAllTSubscriptionFromVendingMachine (LocalDate intervalloTempo){
//        TypedQuery<Subscription> query = em.createQuery("SELECT a.ticketOffice FROM VendingMachine a WHERE a.ticketOffice.emissionDate = :intervalloTempo", Subscription.class);
//        query.setParameter("intervalloTempo", intervalloTempo);
//        return query.getResultList();
//    }
    public List<Subscription> findAllSubscriptionFromAuthorised (LocalDate intervalloTempo){
        TypedQuery<Subscription> query = em.createQuery("SELECT a FROM Subcription a WHERE a.ticketOffice.emissionDate = :intervalloTempo", Subscription.class);
       query.setParameter("intervalloTempo", intervalloTempo);
       return query.getResultList();
   }
    public List<TicketOffice> findAllTicketOfficeFromVendingMachine (LocalDate intervalloTempo){
        TypedQuery<TicketOffice> query = em.createQuery("SELECT  a.ticketOffice, COUNT(a.ticketOffice) FROM VendingMachine a WHERE a.ticketOffice.emissionDate = :intervalloTempo ", TicketOffice.class);
        query.setParameter("intervalloTempo", intervalloTempo);
        return query.getResultList();
    }
    public List<TicketOffice> findAllTicketOfficeFromAuthorised (LocalDate intervalloTempo){
        TypedQuery<TicketOffice> query = em.createQuery("SELECT a.ticketOffice FROM Authorised a WHERE a.ticketOffice.emissionDate = :intervalloTempo", TicketOffice.class);
        query.setParameter("intervalloTempo", intervalloTempo);
        return query.getResultList();
    }


}
