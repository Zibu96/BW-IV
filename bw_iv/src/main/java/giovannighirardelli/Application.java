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
        QueriesUtilitiesDao qd = new QueriesUtilitiesDao(em);

        User user = new User("Christian", "Martucci", LocalDate.of(2001, 9, 11));
    //   ud.userSave(user);

        Card card = new Card(LocalDate.now(), user);
//       cd.cardSave(card);


        Ticket ticket = new Ticket("Tiburtina", LocalDate.now(), TicketType.ORDINARY);
 //    tod.ticketOfficeSave(ticket);

 Subscription sub = new Subscription("Termini", LocalDate.now(), SubscriptionType.WEEKLY, cd.findById("60ee4d5c-c045-4645-b2f3-19cb73c62b6b"));
//      tod.ticketOfficeSave(sub);

        PublicTransport pubTr = new PublicTransport(TypePublicTrasport.BUS, 69, StatePublicTrasport.ON_DUTY);
//        ptd.publicTransportSave(pubTr);

        Route route = new Route("Termini", "Tiburtina", 2.5);
//        rd.routeSave(route);

        ;
//        md.maintananceSave(main);


//        odd.ondDutySave(onDuty);

        VendingMachine vdMachine = new VendingMachine("Tiburtina", TaskStatus.ACTIVE);
    //  rld.retailerSave(vdMachine);

        Authorised aut = new Authorised("Termini", "Tabacchi", 3568213L);
//       rld.retailerSave(aut);
      // rld.findById("00713ec8-f763-4b30-8d23-a86f5fbf2142");
       // aut.setTicketOffice( tod.findById("e14c594f-324e-4253-9f7b-ff3d3e5670e5"));
     //  rld.retailerSave(aut);

       qd.findAllTicketOfficeFromVendingMachine(LocalDate.now()).forEach(System.out::println);
        qd.findAllTicketOfficeFromAuthorised(LocalDate.now()).forEach(System.out::println);








    }

}


