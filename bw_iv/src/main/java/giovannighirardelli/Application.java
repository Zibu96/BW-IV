package giovannighirardelli;

import giovannighirardelli.dao.*;
import giovannighirardelli.entities.*;
import giovannighirardelli.enums.*;
import giovannighirardelli.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti");

    public static void main(String[] args) {


        EntityManager em = emf.createEntityManager();
        TicketOfficeDao tod = new TicketOfficeDao(em);
        CardDao cd = new CardDao(em);
        UserDao ud = new UserDao(em);
        PublicTransportDao ptd = new PublicTransportDao(em);
        RouteDao rd = new RouteDao(em);
        RetailerDao rld = new RetailerDao(em);
        OnDutyDao odd = new OnDutyDao(em);
        MaintanceDao md = new MaintanceDao(em);
        QueriesUtilitiesDao qd = new QueriesUtilitiesDao(em);

        User user = new User("Christian", "Martucci", LocalDate.of(2001, 9, 11));
      //  ud.userSave(user);

        Card card = new Card(LocalDate.now(), user);
       // cd.cardSave(card);


       // Ticket ticket = new Ticket("Tiburtina", LocalDate.now(), TicketType.ORDINARY);
        // tod.ticketOfficeSave(ticket);

       // Subscription sub = new Subscription("Termini", LocalDate.now(), SubscriptionType.WEEKLY, cd.findById("924ce772-91d3-4d3b-948c-e640b35454a8"));
       // tod.ticketOfficeSave(sub);

        PublicTransport pubTr = new PublicTransport(TypePublicTrasport.BUS, 69, StatePublicTrasport.ON_DUTY);
       // ptd.publicTransportSave(pubTr);

        Route route = new Route("Termini", "Tiburtina", 2.5);
        // rd.routeSave(route);


//        md.maintananceSave(main);


//        odd.ondDutySave(onDuty);

        VendingMachine vdMachine = new VendingMachine("Tiburtina", TaskStatus.ACTIVE);
       // rld.retailerSave(vdMachine);

        Authorised aut = new Authorised("Termini", "Tabacchi", 3568213L);
       // rld.retailerSave(aut);

        Retailer retailer = rld.findById("492269d4-1d3e-428e-a497-71c996f21e89");
//        vdMachine.setTicketOffice(tod.findById("3ada0c08-e436-4c9b-a2f0-8ee8d7ad7474"));
//        rld.retailerSave(vdMachine);

//       qd.findAllTicketOfficeFromVendingMachine(LocalDate.now(), "Termini");
//        qd.findAllTicketOfficeFromAuthorised(LocalDate.now(), "Termini");

//        qd.findAllTicketsFromVendingMachine(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1)).forEach(System.out::println);



      // qd.findAllTicketFromRetailer(LocalDate.now().minusDays(2), LocalDate.now().plusDays(2), retailer.getId().toString());

       // qd.subscriptionValidationCheck("924ce772-91d3-4d3b-948c-e640b35454a8");

       try {
           rld.setStatusOfVendingMachine(TaskStatus.ACTIVE, "492269d4-1d3e-428e-a497-71c996f21e89");
       } catch (NotFoundException err) {
           System.out.println(err.getMessage());
       }

       ptd.findAllPublicTransportByStatus(StatePublicTrasport.MAINTENANCE);

       ptd.getAPublicTransportStatus("e5e57aec-1b8d-4a1d-a089-335fcda54a57");

    }

}


