package giovannighirardelli;

import giovannighirardelli.dao.*;
import giovannighirardelli.entities.*;
import giovannighirardelli.enums.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti");

    public static void main(String[] args) {
        System.out.println("Hello World!");
        EntityManager em = emf.createEntityManager();
        TicketOfficeDao tod = new TicketOfficeDao(em);
        CardDao cd = new CardDao(em);
        UserDao ud = new UserDao(em);
        PublicTransportDao ptd = new PublicTransportDao(em);
        RouteDao rd = new RouteDao(em);
        RetailerDao rld = new RetailerDao(em);
        OnDutyDao odd = new OnDutyDao(em);
        MaintanceDao md = new MaintanceDao(em);

        User user = new User("Christian", "Martucci", LocalDate.of(2001, 9, 11));
//        ud.userSave(user);

        Card card = new Card(LocalDate.now(), user);
//        cd.cardSave(card);


        Ticket ticket = new Ticket("Tiburtina", LocalDate.now(), TicketType.ORDINARY);
//        tod.ticketOfficeSave(ticket);

        Subscription sub = new Subscription("Termini", LocalDate.now(), SubscriptionType.WEEKLY, cd.findById("057825cc-477b-4142-8e9f-ab36e3e5f2e5"));
//        tod.ticketOfficeSave(sub);

        PublicTransport pubTr = new PublicTransport(TypePublicTrasport.BUS, 69, StatePublicTrasport.ON_DUTY);
//        ptd.publicTransportSave(pubTr);

        Route route = new Route("Termini", "Tiburtina", 2.5);
//        rd.routeSave(route);

        Maintenance main = new Maintenance("guasto al motore", LocalDate.now().minusMonths(1), LocalDate.now());
//        md.maintananceSave(main);

        OnDuty onDuty = new OnDuty(LocalDate.now().minusWeeks(3), LocalDate.now(), 8.5);
//        odd.ondDutySave(onDuty);

        VendingMachine vdMachine = new VendingMachine("Tiburtina", TaskStatus.ACTIVE);
//        rld.retailerSave(vdMachine);

        Authorised aut = new Authorised("Termini", "Tabacchi", 3568213L);
//        rld.retailerSave(aut);

    }

}


