package giovannighirardelli.utilities;

import giovannighirardelli.dao.*;
import giovannighirardelli.entities.Subscription;
import giovannighirardelli.entities.Ticket;
import giovannighirardelli.enums.SubscriptionType;
import giovannighirardelli.enums.TicketType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Scanner;

public class MyScanner {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti");

    public static void myScanner() {
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
        TransportRouteDao trd = new TransportRouteDao(em);


        int el = 0;
        Scanner scn = new Scanner(System.in);
        while (el != 3) {
            System.out.println("Inserisci 1 per accedere alla sezione ADMIN");
            System.out.println("Inserisci 2 per accedere alla sezione UTENTE");
            System.out.println("Inserisci 3 per uscire");
            el = Integer.parseInt(scn.nextLine());
            switch (el) {
                case 1: {
                    System.out.println("Quale operazione vuoi effettuare?");



                    break;
                }
                case 2: {
                    int el1 = 0;
                    while (el1 != 4) {
                        System.out.println("Benvenuto nel sistema PopiPopi Transport");
                        System.out.println("Inserisci 1 se desideri acquistare un biglietto");
                        System.out.println("Inserisci 2 se vuoi acquistare un abbonamento (TESSERA NECESSARIA)");
                        System.out.println("inserisci 3 se possiedi un titolo di viaggio");
                        System.out.println("inserisci 4 per tornare indietro");
                        el1 = Integer.parseInt(scn.nextLine());

                        switch (el1) {
                            case 1: {
                                int el2 = 0;
                                while (el2!=4){
                                    System.out.println("Da quale punto vendita vuoi acquistare?");
                                    System.out.println("inserisci 1 per selezionare il rivenditore a Tiburtina");
                                    System.out.println("inserisci 2 per selezionare il rivenditore a Termini");
                                    System.out.println("inserisci 3 per selezionare il rivenditore a Colosseo");
                                    System.out.println("inserisci 4 per tornare indietro");
                                    el2 = Integer.parseInt(scn.nextLine());
                                    switch (el2){
                                        case 1:
                                        {
                                            int el3 = 0;
                                            while (el3 !=3) {
                                                System.out.println("Vuoi acquistare dal rivenditore autorizzato o dal distributore automatico?");
                                                System.out.println("Inserisci 1 per selezionare il rivenditore autorizzato.");
                                                System.out.println("Inserisci 2 per selezionare il distributore automatico");
                                                System.out.println("inserisci 3 per tornare indietro");
                                                el3 = Integer.parseInt(scn.nextLine());

                                                switch (el3) {
                                                    case 1:
                                                    {
                                                        int el4 =0;
                                                        while (el4 != 4) {
                                                            System.out.println("Che tipo di biglietto vuoi acquistare?");
                                                            System.out.println("Inserisci 1 per selezionare il biglietto ordinario (1,50 €).");
                                                            System.out.println("Inserisci 2 per selezionare il biglietto a breve distanza 15 km (2,00 €)");
                                                            System.out.println("Inserisci 3 per selezionare il biglietto a lunga distanza 30 km (3,00 €)");
                                                            System.out.println("inserisci 4 per tornare indietro");
                                                            el4 = Integer.parseInt(scn.nextLine());

                                                            ticketTypeFunctionSel(el4, "Tiburtina", "2419fa42-0b92-44ac-a949-422752214d48" );

                                                        }

                                                        break;
                                                    }

                                                    case 2: {
                                                        int el5 =0;
                                                        while (el5 != 4) {
                                                            System.out.println("Che tipo di biglietto vuoi acquistare?");
                                                            System.out.println("Inserisci 1 per selezionare il biglietto ordinario (1,50 €).");
                                                            System.out.println("Inserisci 2 per selezionare il biglietto a breve distanza 15 km (2,00 €)");
                                                            System.out.println("Inserisci 3 per selezionare il biglietto a lunga distanza 30 km (3,00 €)");
                                                            System.out.println("inserisci 4 per tornare indietro");
                                                            el5 = Integer.parseInt(scn.nextLine());

                                                            ticketTypeFunctionSel(el5, "Tiburtina", "492269d4-1d3e-428e-a497-71c996f21e89" );

                                                        }
                                                        break;
                                                    }

                                                    case 3: break;

                                                    default:
                                                        System.out.println("Dato inserito non valido");
                                                }
                                            }
                                            break;
                                        }
                                        case 2:
                                        {
                                            int el6 = 0;
                                            while (el6 !=3) {
                                                System.out.println("Vuoi acquistare dal rivenditore autorizzato o dal distributore automatico?");
                                                System.out.println("Inserisci 1 per selezionare il rivenditore autorizzato.");
                                                System.out.println("Inserisci 2 per selezionare il distributore automatico");
                                                System.out.println("inserisci 3 per tornare indietro");
                                                el6 = Integer.parseInt(scn.nextLine());

                                                switch (el6) {
                                                    case 1:
                                                    {
                                                        int el7 =0;
                                                        while (el7 != 4) {
                                                            System.out.println("Che tipo di biglietto vuoi acquistare?");
                                                            System.out.println("Inserisci 1 per selezionare il biglietto ordinario (1,50 €).");
                                                            System.out.println("Inserisci 2 per selezionare il biglietto a breve distanza 15 km (2,00 €)");
                                                            System.out.println("Inserisci 3 per selezionare il biglietto a lunga distanza 30 km (3,00 €)");
                                                            System.out.println("inserisci 4 per tornare indietro");
                                                            el7 = Integer.parseInt(scn.nextLine());

                                                            ticketTypeFunctionSel(el7,  "Termini", "676cdca1-4bbc-4a82-9640-01499391caa5" );

                                                        }

                                                        break;
                                                    }

                                                    case 2: {
                                                        int el8 =0;
                                                        while (el8 != 4) {
                                                            System.out.println("Che tipo di biglietto vuoi acquistare?");
                                                            System.out.println("Inserisci 1 per selezionare il biglietto ordinario (1,50 €).");
                                                            System.out.println("Inserisci 2 per selezionare il biglietto a breve distanza 15 km (2,00 €)");
                                                            System.out.println("Inserisci 3 per selezionare il biglietto a lunga distanza 30 km (3,00 €)");
                                                            System.out.println("inserisci 4 per tornare indietro");
                                                            el8 = Integer.parseInt(scn.nextLine());

                                                            ticketTypeFunctionSel(el8, "Termini", "c7bb2c28-de41-48e9-bc1c-00d7fe06f01b" );

                                                        }
                                                        break;
                                                    }

                                                    case 3: break;

                                                    default:
                                                        System.out.println("Dato inserito non valido");
                                                }
                                            }

                                            break;
                                        }
                                        case 3:
                                        {
                                            int el9 = 0;
                                            while (el9 !=3) {
                                                System.out.println("Vuoi acquistare dal rivenditore autorizzato o dal distributore automatico?");
                                                System.out.println("Inserisci 1 per selezionare il rivenditore autorizzato.");
                                                System.out.println("Inserisci 2 per selezionare il distributore automatico");
                                                System.out.println("inserisci 3 per tornare indietro");
                                                el9= Integer.parseInt(scn.nextLine());

                                                switch (el9) {
                                                    case 1:
                                                    {
                                                        int el10 =0;
                                                        while (el10 != 4) {

                                                            System.out.println("Che tipo di biglietto vuoi acquistare?");
                                                            System.out.println("Inserisci 1 per selezionare il biglietto ordinario (1,50 €).");
                                                            System.out.println("Inserisci 2 per selezionare il biglietto a breve distanza 15 km (2,00 €)");
                                                            System.out.println("Inserisci 3 per selezionare il biglietto a lunga distanza 30 km (3,00 €)");
                                                            System.out.println("inserisci 4 per tornare indietro");
                                                            el10 = Integer.parseInt(scn.nextLine());

                                                            ticketTypeFunctionSel(el10, "Colosseo", "05a2e1dc-653a-42f5-8e55-0cf50427a38d" );

                                                        }

                                                        break;
                                                    }

                                                    case 2: {
                                                        int el11 =0;
                                                        while (el11 != 4) {

                                                            System.out.println("Che tipo di biglietto vuoi acquistare?");
                                                            System.out.println("Inserisci 1 per selezionare il biglietto ordinario (1,50 €).");
                                                            System.out.println("Inserisci 2 per selezionare il biglietto a breve distanza 15 km (2,00 €)");
                                                            System.out.println("Inserisci 3 per selezionare il biglietto a lunga distanza 30 km (3,00 €)");
                                                            System.out.println("inserisci 4 per tornare indietro");
                                                            el11 = Integer.parseInt(scn.nextLine());

                                                            ticketTypeFunctionSel(el11,  "Colosseo", "fe235d37-a3fa-4c6b-966e-47ac76b8c2ea" );

                                                        }
                                                        break;
                                                    }

                                                    case 3: break;

                                                    default:
                                                        System.out.println("Dato inserito non valido");
                                                }
                                            }
                                            break;
                                        }
                                        case 4: break;
                                        default:
                                            System.out.println("Dato inserito non valido");
                                    }
                                }

                                break;
                            }
                            case 2: {

                                break;
                            }
                            case 3: {

                                break;
                            }
                            case 4:
                                break;
                            default:
                                System.out.println("Scelta non valida");
                        }

                    }
                    break;
                }
                case 3:
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        }
    }

    private static void subTypeFunctionSel (int el, Scanner scn, String location, String idRetailer, String idCard) {
        EntityManager em = emf.createEntityManager();
        TicketOfficeDao tod = new TicketOfficeDao(em);
        RetailerDao rld = new RetailerDao(em);
        CardDao cd = new CardDao(em);

        System.out.println("Che tipo di abbonamento vuoi acquistare?");
        System.out.println("Inserisci 1 per selezionare l'abbonamento settimanale (15.99 €).");
        System.out.println("Inserisci 2 per selezionare l'abbonamento mensile (30.59 €).");
        System.out.println("inserisci 3 per tornare indietro");
        el = Integer.parseInt(scn.nextLine());

        switch (el) {
            case 1:
            {
                Subscription subscription = new Subscription(location, LocalDate.now(),  rld.findById(idRetailer), SubscriptionType.WEEKLY, cd.findById(idCard));
                System.out.println("Grazie per l'acquisto!");
                break;
            }

            case 2: {
                Subscription subscription = new Subscription(location, LocalDate.now(),  rld.findById(idRetailer), SubscriptionType.MONTLY, cd.findById(idCard));
                System.out.println("Grazie per l'acquisto!");
                break;
            }

            case 3: break;

            default:
                System.out.println("Dato inserito non valido");
        }
    }

    private static void ticketTypeFunctionSel(int el, String location, String id ) {

        EntityManager em = emf.createEntityManager();
        TicketOfficeDao tod = new TicketOfficeDao(em);
        RetailerDao rld = new RetailerDao(em);

        switch (el ) {
            case 1: {
                Ticket ticket = new Ticket(location, LocalDate.now(), rld.findById(id), TicketType.ORDINARY);
                tod.ticketOfficeSave(ticket);
                System.out.println("Grazie per l'acquisto!");
                break;
            }

            case 2: {
                Ticket ticket = new Ticket(location, LocalDate.now(), rld.findById(id), TicketType.SHORT_DISTANCE);
                tod.ticketOfficeSave(ticket);
                System.out.println("Grazie per l'acquisto!");
                break;
            }

            case 3: {
                Ticket ticket = new Ticket(location, LocalDate.now(), rld.findById(id), TicketType.LONG_DISTANCE);
                tod.ticketOfficeSave(ticket);
                System.out.println("Grazie per l'acquisto!");
                break;
            }

            case 4: break;

            default:
                System.out.println("Dato inserito non valido");
        }
    }

}
