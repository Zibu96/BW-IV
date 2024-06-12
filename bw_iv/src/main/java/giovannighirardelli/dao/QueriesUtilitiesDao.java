package giovannighirardelli.dao;

import giovannighirardelli.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.ArrayList;
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
//    public List<Subscription> findAllSubscriptionFromAuthorised (LocalDate intervalloTempo){
//        TypedQuery<Subscription> query = em.createQuery("SELECT a FROM Subcription a WHERE a.ticketOffice.emissionDate = :intervalloTempo", Subscription.class);
//       query.setParameter("intervalloTempo", intervalloTempo);
//       return query.getResultList();
//   }
    public void findAllTicketOfficeFromVendingMachine (LocalDate intervalloTempo, String location){

        TypedQuery<TicketOffice> query = em.createQuery("SELECT  a.ticketOffice FROM VendingMachine a WHERE a.ticketOffice.emissionDate = :intervalloTempo AND LOWER(a.location) LIKE LOWER(:location)", TicketOffice.class);
        query.setParameter("intervalloTempo", intervalloTempo);
        query.setParameter("location", location);
        List<TicketOffice> resultList = query.getResultList();
long ticketCount =
        resultList.stream().filter(el->el instanceof Ticket).count();
long subscriptionCount =
        resultList.stream().filter(el->el instanceof Subscription).count();
        System.out.println("Numero abbonamenti: " + subscriptionCount);
        System.out.println("Numero biglietti:" + ticketCount);
        resultList.forEach(System.out::println);
    }
    public void findAllTicketOfficeFromAuthorised (LocalDate intervalloTempo, String location){
        TypedQuery<TicketOffice> query = em.createQuery("SELECT a.ticketOffice FROM Authorised a WHERE a.ticketOffice.emissionDate = :intervalloTempo AND LOWER(a.location) LIKE LOWER(:location)", TicketOffice.class);
        query.setParameter("intervalloTempo", intervalloTempo);
        query.setParameter("location", location);
        List<TicketOffice> resultList = query.getResultList();
        long ticketCount =
                resultList.stream().filter(el->el instanceof Ticket).count();
        long subscriptionCount =
                resultList.stream().filter(el->el instanceof Subscription).count();
        System.out.println("Numero abbonamenti: " + subscriptionCount);
        System.out.println("Numero biglietti:" + ticketCount);

        resultList.forEach(System.out::println);
    }


}
