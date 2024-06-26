package giovannighirardelli.dao;

import giovannighirardelli.entities.Subscription;
import giovannighirardelli.entities.Ticket;
import giovannighirardelli.entities.TicketOffice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.UUID;

public class QueriesUtilitiesDao {
    private EntityManager em;

    public QueriesUtilitiesDao(EntityManager em) {
        this.em = em;
    }

    public void findAllTicketFromRetailer(LocalDate init, LocalDate end, String id) {

        TypedQuery<Ticket> query = em.createQuery("SELECT a FROM Ticket a WHERE a.emissionDate > :inizioIntervallo AND a.emissionDate < :fineIntervallo AND a.retailerId.id = :id", Ticket.class);
        query.setParameter("inizioIntervallo", init);
        query.setParameter("fineIntervallo", end);
        query.setParameter("id", UUID.fromString(id));

        if (query.getResultList().isEmpty()) System.out.println("Nessun ticket trovato!");
        else {
            System.out.println((long) query.getResultList().size());
            query.getResultList().forEach(System.out::println);
        }
    }

    public void findAllSubscriptionFromRetailer(LocalDate init, LocalDate end, String id) {
        TypedQuery<Subscription> query = em.createQuery("SELECT a FROM Subscription a WHERE a.emissionDate > :inizioIntervallo AND a.emissionDate < :fineIntervallo AND a.retailerId.id = :id", Subscription.class);
        query.setParameter("inizioIntervallo", init);
        query.setParameter("fineIntervallo", end);
        query.setParameter("id", UUID.fromString(id));

        if (query.getResultList().isEmpty()) System.out.println("Nessun abbonamento trovato!");
        else {
            System.out.println((long) query.getResultList().size());
            query.getResultList().forEach(System.out::println);
        }
    }

    public void findAllTicketOfficeFromRetailer(LocalDate init, LocalDate end, String id) {

        TypedQuery<TicketOffice> query = em.createQuery("SELECT a FROM TicketOffice a WHERE a.emissionDate > :inizioIntervallo AND a.emissionDate < :fineIntervallo AND a.retailerId.id = :id", TicketOffice.class);
        query.setParameter("inizioIntervallo", init);
        query.setParameter("fineIntervallo", end);
        query.setParameter("id", UUID.fromString(id));

        if (query.getResultList().isEmpty()) System.out.println("Nessun titolo di viaggio trovato!");
        else {
            System.out.println((long) query.getResultList().size());
            query.getResultList().forEach(System.out::println);
        }

//        List<TicketOffice> resultList = query.getResultList();
//        long ticketCount =
//                resultList.stream().filter(el -> el instanceof Ticket).count();
//        long subscriptionCount =
//                resultList.stream().filter(el -> el instanceof Subscription).count();
//        System.out.println("Numero abbonamenti: " + subscriptionCount);
//        System.out.println("Numero biglietti:" + ticketCount);
//        resultList.forEach(System.out::println);
    }

    public void subscriptionValidationCheck(String cardId) {
        LocalDate today = LocalDate.now();
        TypedQuery<Subscription> query = em.createQuery("SELECT a FROM Subscription a WHERE a.card.cardId = :cardId AND a.expirationDate > :today", Subscription.class);
        query.setParameter("today", today);
        query.setParameter("cardId", UUID.fromString(cardId));

        if (query.getResultList().isEmpty()) System.out.println("Nessun abbonamento valido!");
        else
            query.getResultList().forEach(subscription -> System.out.println("Abbonamento con id: " + subscription.getTitleId() + " è attivo"));
    }


}
