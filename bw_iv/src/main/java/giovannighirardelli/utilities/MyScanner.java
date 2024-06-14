package giovannighirardelli.utilities;

import giovannighirardelli.dao.*;
import giovannighirardelli.entities.Subscription;
import giovannighirardelli.entities.Ticket;
import giovannighirardelli.entities.TransportRoute;
import giovannighirardelli.enums.StatePublicTransport;
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
                    int elem = 0;

                    while (elem != 4) {
                        System.out.println("Quale operazione vuoi effettuare?");

                        System.out.println("Inserisci 1 per effettuare controlli sui titoli di viaggio");
                        System.out.println("Inserisci 2 per effettuare controlli sul parco mezzi");
                        System.out.println("Inserisci 3 per effettuare controlli sulle tratte");
                        System.out.println("inserisci 4 per tornare indietro");
                        elem = Integer.parseInt(scn.nextLine());
                        switch (elem) {
                            case 1: {
                                int elem1 = 0;
                                while (elem1 != 4) {
                                    System.out.println("Quale controllo vuoi effettuare?");
                                    System.out.println("Inserisci 1 per controllare i biglietti");
                                    System.out.println("Inserisci 2 per controllare gli abbonamenti");
                                    System.out.println("Inserisci 3 per controllare i titoli di viaggio");
                                    System.out.println("Inserisci 4 tornare indietro");
                                    elem1 = Integer.parseInt(scn.nextLine());
                                    switch (elem1) {
                                        case 1: {
                                            int elem2 = 0;
                                            while (elem2 != 4) {
                                                System.out.println("Cosa vuoi controllare dei biglietti?");
                                                System.out.println("Inserisci 1 per controllare i biglietti venduti da un venditore");
                                                System.out.println("Inserisci 2 per controllare i biglietti validati su uno specifico mezzo");
                                                System.out.println("Inserisci 3 per controllare i biglietti validati in un arco temporale");
                                                System.out.println("Inserisci 4 per tornare indietro");
                                                elem2 = Integer.parseInt(scn.nextLine());
                                                switch (elem2) {
                                                    case 1: {

                                                        System.out.println("Inserisci l'ID del rivenditore");
                                                        String elem3 = scn.nextLine();
                                                        qd.findAllTicketFromRetailer(LocalDate.now().minusYears(1), LocalDate.now().plusDays(1), elem3);
                                                        break;
                                                    }
                                                    case 2: {
                                                        System.out.println("Inserisci l'ID del mezzo");
                                                        String elem4 = scn.nextLine();
                                                        tod.getTicketByTransport(elem4);
                                                        break;
                                                    }
                                                    case 3: {
                                                        System.out.println("Inserisci la data da cui iniziare il controllo");
                                                        LocalDate elem5 = LocalDate.parse(scn.nextLine());
                                                        System.out.println("Inserisci la data in cui finire il controllo");
                                                        LocalDate elem6 = LocalDate.parse(scn.nextLine());
                                                        tod.getTicketByDate(elem5, elem6);
                                                        break;
                                                    }
                                                    case 4:
                                                        break;

                                                    default:
                                                        System.out.println("Dato inserito non valido");
                                                }

                                            }
                                            break;


                                        }

                                        case 2: {
                                            int elem3 = 0;
                                            while (elem3 != 3) {
                                                System.out.println("Cosa vuoi controllare degli abbonamenti?");
                                                System.out.println("Inserisci 1 per controllare gli abbonamenti venduti da un venditore");
                                                System.out.println("Inserisci 2 per controllare la validità di un abbonamento");
                                                System.out.println("Inserisci 3 per tornare indietro");
                                                elem3 = Integer.parseInt(scn.nextLine());
                                                switch (elem3) {
                                                    case 1: {
                                                        System.out.println("Inserisci l'ID del rivenditore");
                                                        String elem4 = scn.nextLine();
                                                        qd.findAllSubscriptionFromRetailer(LocalDate.now().minusYears(1), LocalDate.now().plusDays(1), elem4);
                                                        break;
                                                    }
                                                    case 2: {
                                                        System.out.println("Inserisci l'ID della tessera dell'utente di cui vuoi controllare la validità dell'abbonamento");
                                                        String elem5 = scn.nextLine();
                                                        qd.subscriptionValidationCheck(elem5);
                                                        break;
                                                    }
                                                    case 3:
                                                        break;
                                                    default:
                                                        System.out.println("Dato inserito non valido");
                                                }

                                            }
                                            break;
                                        }

                                        case 3: {

                                            int elem6 = 0;
                                            while (elem6 != 2) {
                                                System.out.println("Cosa vuoi controllare della biglietteria?");
                                                System.out.println("Inserisci 1 per controllare i titoli di viaggio emessi da un venditore");
                                                System.out.println("Inserisci 2 per tornare indietro");
                                                elem6 = Integer.parseInt(scn.nextLine());
                                                switch (elem6) {
                                                    case 1: {
                                                        System.out.println("Inserisci l'ID del rivenditore");
                                                        String elem7 = scn.nextLine();
                                                        qd.findAllTicketOfficeFromRetailer(LocalDate.now().minusYears(1), LocalDate.now().plusDays(1), elem7);
                                                        break;
                                                    }
                                                    case 2:
                                                        break;
                                                    default:
                                                        System.out.println("Dato inserito non valido");
                                                }
                                            }
                                            break;
                                        }

                                        case 4:
                                            break;

                                        default:
                                            System.out.println("Dato inserito non valido");
                                    }

                                }
                                break;
                            }

                            case 2: {
                                int caso2 = 0;
                                while (caso2 != 4) {
                                    System.out.println("Dimmi quale operazione vuoi effettuare");
                                    System.out.println("Inserisci 1 se vuoi visualizzare tutti i mezzi in servizio o in manutenzione");
                                    System.out.println("Inserisci 2 se vuoi visualizzare lo stato attuale di un particolare mezzo");
                                    System.out.println("Inserisci 3 se vuoi visualizzare lo storico di un particolare mezzo in un periodo di tempo");
                                    System.out.println("Inserisci 4 per tornare indietro");
                                    caso2 = Integer.parseInt(scn.nextLine());
                                    switch (caso2) {
                                        case 1: {
                                            int cs = 0;
                                            while (cs != 3) {
                                                System.out.println("Vuoi visualizzare tutti i mezzi che sono attualmente in manutenzione o tutti i mezzi in servizio?");
                                                System.out.println("Digita 1 per visualizzare tutti i mezzi attualmente in manutenzione");
                                                System.out.println("Digita 2 per visualizzare tutti i mezzi attualmente in servizio");
                                                System.out.println("Inserisci 3 per tornare indietro");
                                                cs = Integer.parseInt(scn.nextLine());
                                                publicTransportFunctionsAllTransportStatusSel(cs);
                                            }
                                            break;
                                        }
                                        case 2: {
                                            System.out.println("Inserisci l'ID del mezzo di cui vuoi conoscere lo stato");
                                            String cs1 = scn.nextLine();
                                            ptd.getAPublicTransportStatus(cs1);
                                            break;
                                        }
                                        case 3: {
                                            System.out.println("Inserisci l'ID del mezzo di cui vuoi conoscere lo storico di servizio e manutenzione");
                                            String cs2 = scn.nextLine();
                                            ptd.getBacklogOfTransportStatus(cs2);
                                            break;
                                        }
                                        case 4: {
                                            break;
                                        }
                                        default:
                                            System.out.println("Selezione non valida");
                                    }

                                }
                                break;
                            }

                            case 3: {
                                int elem8 = 0;
                                while (elem8 != 2) {
                                    System.out.println("Cosa vuoi controllare dei biglietti?");
                                    System.out.println("Inserisci 1 per controllare quante volte un mezzo ha percorso una tratta");
                                    System.out.println("Inserisci 2 per tornare indietro");
                                    elem8 = Integer.parseInt(scn.nextLine());
                                    switch (elem8) {
                                        case 1: {

                                            System.out.println("Inserisci l'ID del mezzo");
                                            String elem9 = scn.nextLine();
                                            System.out.println("Inserisci l'ID della tratta");
                                            String elem10 = scn.nextLine();

                                            trd.findRouteByTransport(elem9, elem10);
                                            break;
                                        }
                                        case 2:
                                            break;
                                        default:
                                            System.out.println("Dato inserito non valido");
                                    }
                                }
                                break;
                            }
                            case 4:
                                break;
                            default:
                                System.out.println("Dato inserito non valido");
                        }
                    }

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
                                while (el2 != 4) {
                                    System.out.println("Da quale punto vendita vuoi acquistare?");
                                    System.out.println("inserisci 1 per selezionare il rivenditore a Tiburtina");
                                    System.out.println("inserisci 2 per selezionare il rivenditore a Termini");
                                    System.out.println("inserisci 3 per selezionare il rivenditore a Colosseo");
                                    System.out.println("inserisci 4 per tornare indietro");
                                    el2 = Integer.parseInt(scn.nextLine());
                                    switch (el2) {
                                        case 1: {
                                            int el3 = 0;
                                            while (el3 != 3) {
                                                System.out.println("Vuoi acquistare dal rivenditore autorizzato o dal distributore automatico?");
                                                System.out.println("Inserisci 1 per selezionare il rivenditore autorizzato.");
                                                System.out.println("Inserisci 2 per selezionare il distributore automatico");
                                                System.out.println("inserisci 3 per tornare indietro");
                                                el3 = Integer.parseInt(scn.nextLine());

                                                switch (el3) {
                                                    case 1: {
                                                        int el4 = 0;
                                                        while (el4 != 4) {
                                                            System.out.println("Che tipo di biglietto vuoi acquistare?");
                                                            System.out.println("Inserisci 1 per selezionare il biglietto ordinario (1,50 €).");
                                                            System.out.println("Inserisci 2 per selezionare il biglietto a breve distanza 15 km (2,00 €)");
                                                            System.out.println("Inserisci 3 per selezionare il biglietto a lunga distanza 30 km (3,00 €)");
                                                            System.out.println("inserisci 4 per tornare indietro");
                                                            el4 = Integer.parseInt(scn.nextLine());

                                                            ticketTypeFunctionSel(el4, "Tiburtina", "2419fa42-0b92-44ac-a949-422752214d48");

                                                        }

                                                        break;
                                                    }

                                                    case 2: {
                                                        int el5 = 0;
                                                        while (el5 != 4) {
                                                            System.out.println("Che tipo di biglietto vuoi acquistare?");
                                                            System.out.println("Inserisci 1 per selezionare il biglietto ordinario (1,50 €).");
                                                            System.out.println("Inserisci 2 per selezionare il biglietto a breve distanza 15 km (2,00 €)");
                                                            System.out.println("Inserisci 3 per selezionare il biglietto a lunga distanza 30 km (3,00 €)");
                                                            System.out.println("inserisci 4 per tornare indietro");
                                                            el5 = Integer.parseInt(scn.nextLine());

                                                            ticketTypeFunctionSel(el5, "Tiburtina", "492269d4-1d3e-428e-a497-71c996f21e89");

                                                        }
                                                        break;
                                                    }

                                                    case 3:
                                                        break;

                                                    default:
                                                        System.out.println("Dato inserito non valido");
                                                }
                                            }
                                            break;
                                        }
                                        case 2: {
                                            int el6 = 0;
                                            while (el6 != 3) {
                                                System.out.println("Vuoi acquistare dal rivenditore autorizzato o dal distributore automatico?");
                                                System.out.println("Inserisci 1 per selezionare il rivenditore autorizzato.");
                                                System.out.println("Inserisci 2 per selezionare il distributore automatico");
                                                System.out.println("inserisci 3 per tornare indietro");
                                                el6 = Integer.parseInt(scn.nextLine());

                                                switch (el6) {
                                                    case 1: {
                                                        int el7 = 0;
                                                        while (el7 != 4) {
                                                            System.out.println("Che tipo di biglietto vuoi acquistare?");
                                                            System.out.println("Inserisci 1 per selezionare il biglietto ordinario (1,50 €).");
                                                            System.out.println("Inserisci 2 per selezionare il biglietto a breve distanza 15 km (2,00 €)");
                                                            System.out.println("Inserisci 3 per selezionare il biglietto a lunga distanza 30 km (3,00 €)");
                                                            System.out.println("inserisci 4 per tornare indietro");
                                                            el7 = Integer.parseInt(scn.nextLine());

                                                            ticketTypeFunctionSel(el7, "Termini", "676cdca1-4bbc-4a82-9640-01499391caa5");

                                                        }

                                                        break;
                                                    }

                                                    case 2: {
                                                        int el8 = 0;
                                                        while (el8 != 4) {
                                                            System.out.println("Che tipo di biglietto vuoi acquistare?");
                                                            System.out.println("Inserisci 1 per selezionare il biglietto ordinario (1,50 €).");
                                                            System.out.println("Inserisci 2 per selezionare il biglietto a breve distanza 15 km (2,00 €)");
                                                            System.out.println("Inserisci 3 per selezionare il biglietto a lunga distanza 30 km (3,00 €)");
                                                            System.out.println("inserisci 4 per tornare indietro");
                                                            el8 = Integer.parseInt(scn.nextLine());

                                                            ticketTypeFunctionSel(el8, "Termini", "c7bb2c28-de41-48e9-bc1c-00d7fe06f01b");

                                                        }
                                                        break;
                                                    }

                                                    case 3:
                                                        break;

                                                    default:
                                                        System.out.println("Dato inserito non valido");
                                                }
                                            }

                                            break;
                                        }
                                        case 3: {
                                            int el9 = 0;
                                            while (el9 != 3) {
                                                System.out.println("Vuoi acquistare dal rivenditore autorizzato o dal distributore automatico?");
                                                System.out.println("Inserisci 1 per selezionare il rivenditore autorizzato.");
                                                System.out.println("Inserisci 2 per selezionare il distributore automatico");
                                                System.out.println("inserisci 3 per tornare indietro");
                                                el9 = Integer.parseInt(scn.nextLine());

                                                switch (el9) {
                                                    case 1: {
                                                        int el10 = 0;
                                                        while (el10 != 4) {

                                                            System.out.println("Che tipo di biglietto vuoi acquistare?");
                                                            System.out.println("Inserisci 1 per selezionare il biglietto ordinario (1,50 €).");
                                                            System.out.println("Inserisci 2 per selezionare il biglietto a breve distanza 15 km (2,00 €)");
                                                            System.out.println("Inserisci 3 per selezionare il biglietto a lunga distanza 30 km (3,00 €)");
                                                            System.out.println("inserisci 4 per tornare indietro");
                                                            el10 = Integer.parseInt(scn.nextLine());

                                                            ticketTypeFunctionSel(el10, "Colosseo", "05a2e1dc-653a-42f5-8e55-0cf50427a38d");

                                                        }

                                                        break;
                                                    }

                                                    case 2: {
                                                        int el11 = 0;
                                                        while (el11 != 4) {

                                                            System.out.println("Che tipo di biglietto vuoi acquistare?");
                                                            System.out.println("Inserisci 1 per selezionare il biglietto ordinario (1,50 €).");
                                                            System.out.println("Inserisci 2 per selezionare il biglietto a breve distanza 15 km (2,00 €)");
                                                            System.out.println("Inserisci 3 per selezionare il biglietto a lunga distanza 30 km (3,00 €)");
                                                            System.out.println("inserisci 4 per tornare indietro");
                                                            el11 = Integer.parseInt(scn.nextLine());

                                                            ticketTypeFunctionSel(el11, "Colosseo", "fe235d37-a3fa-4c6b-966e-47ac76b8c2ea");

                                                        }
                                                        break;
                                                    }

                                                    case 3:
                                                        break;

                                                    default:
                                                        System.out.println("Dato inserito non valido");
                                                }
                                            }
                                            break;
                                        }
                                        case 4:
                                            break;
                                        default:
                                            System.out.println("Dato inserito non valido");
                                    }
                                }

                                break;
                            }
                            case 2: {
                                int sl = 0;
                                System.out.println("Inserisci l'id della tua tessera.");
                                String cardId = scn.nextLine();

                                System.out.println("Da quale punto vendita vuoi acquistare?");
                                System.out.println("inserisci 1 per selezionare il rivenditore a Tiburtina");
                                System.out.println("inserisci 2 per selezionare il rivenditore a Termini");
                                System.out.println("inserisci 3 per selezionare il rivenditore a Colosseo");
                                System.out.println("inserisci 4 per tornare indietro");
                                sl = Integer.parseInt(scn.nextLine());
                                switch (sl) {
                                    case 1: {
                                        int sl1 = 0;
                                        while (sl1 != 3) {
                                            System.out.println("Vuoi acquistare dal rivenditore autorizzato o dal distributore automatico?");
                                            System.out.println("Inserisci 1 per selezionare il rivenditore autorizzato.");
                                            System.out.println("Inserisci 2 per selezionare il distributore automatico");
                                            System.out.println("inserisci 3 per tornare indietro");
                                            sl1 = Integer.parseInt(scn.nextLine());

                                            switch (sl1) {
                                                case 1: {

                                                    int sl2 = 0;
                                                    while (sl2 != 3) {
                                                        System.out.println("Che tipo di abbonamento vuoi acquistare?");
                                                        System.out.println("Inserisci 1 per selezionare l'abbonamento settimanale (15.99 €).");
                                                        System.out.println("Inserisci 2 per selezionare l'abbonamento mensile (30.59 €).");
                                                        System.out.println("inserisci 3 per tornare indietro");
                                                        sl2 = Integer.parseInt(scn.nextLine());
                                                        subTypeFunctionSel(sl2, "Tiburtina", "2419fa42-0b92-44ac-a949-422752214d48", cardId);
                                                    }
                                                    break;
                                                }

                                                case 2: {

                                                    int sl3 = 0;

                                                    while (sl3 != 3) {
                                                        System.out.println("Che tipo di abbonamento vuoi acquistare?");
                                                        System.out.println("Inserisci 1 per selezionare l'abbonamento settimanale (15.99 €).");
                                                        System.out.println("Inserisci 2 per selezionare l'abbonamento mensile (30.59 €).");
                                                        System.out.println("inserisci 3 per tornare indietro");
                                                        sl3 = Integer.parseInt(scn.nextLine());
                                                        subTypeFunctionSel(sl3, "Tiburtina", "492269d4-1d3e-428e-a497-71c996f21e89", cardId);
                                                    }

                                                    break;
                                                }

                                                case 3:
                                                    break;


                                                default:
                                                    System.out.println("Scelta non valida");
                                            }
                                        }

                                        break;
                                    }

                                    case 2: {
                                        int sl4 = 0;
                                        while (sl4 != 3) {
                                            System.out.println("Vuoi acquistare dal rivenditore autorizzato o dal distributore automatico?");
                                            System.out.println("Inserisci 1 per selezionare il rivenditore autorizzato.");
                                            System.out.println("Inserisci 2 per selezionare il distributore automatico");
                                            System.out.println("inserisci 3 per tornare indietro");
                                            sl4 = Integer.parseInt(scn.nextLine());

                                            switch (sl4) {

                                                case 1: {
                                                    int sl5 = 0;
                                                    while (sl5 != 3) {
                                                        System.out.println("Che tipo di abbonamento vuoi acquistare?");
                                                        System.out.println("Inserisci 1 per selezionare l'abbonamento settimanale (15.99 €).");
                                                        System.out.println("Inserisci 2 per selezionare l'abbonamento mensile (30.59 €).");
                                                        System.out.println("inserisci 3 per tornare indietro");
                                                        sl5 = Integer.parseInt(scn.nextLine());
                                                        subTypeFunctionSel(sl5, "Termini", "676cdca1-4bbc-4a82-9640-01499391caa5", cardId);
                                                    }

                                                    break;
                                                }

                                                case 2: {

                                                    int sl6 = 0;
                                                    while (sl6 != 3) {
                                                        System.out.println("Che tipo di abbonamento vuoi acquistare?");
                                                        System.out.println("Inserisci 1 per selezionare l'abbonamento settimanale (15.99 €).");
                                                        System.out.println("Inserisci 2 per selezionare l'abbonamento mensile (30.59 €).");
                                                        System.out.println("inserisci 3 per tornare indietro");
                                                        sl6 = Integer.parseInt(scn.nextLine());
                                                        subTypeFunctionSel(sl6, "Termini", "c7bb2c28-de41-48e9-bc1c-00d7fe06f01b", cardId);
                                                    }

                                                    break;
                                                }

                                                case 3:
                                                    break;

                                                default:
                                                    System.out.println("Scelta non valida");
                                            }
                                        }

                                        break;
                                    }

                                    case 3: {
                                        int sl7 = 0;
                                        while (sl7 != 3) {
                                            System.out.println("Vuoi acquistare dal rivenditore autorizzato o dal distributore automatico?");
                                            System.out.println("Inserisci 1 per selezionare il rivenditore autorizzato.");
                                            System.out.println("Inserisci 2 per selezionare il distributore automatico");
                                            System.out.println("inserisci 3 per tornare indietro");
                                            sl7 = Integer.parseInt(scn.nextLine());

                                            switch (sl7) {
                                                case 1: {
                                                    int sl8 = 0;
                                                    while (sl8 != 3) {
                                                        System.out.println("Che tipo di abbonamento vuoi acquistare?");
                                                        System.out.println("Inserisci 1 per selezionare l'abbonamento settimanale (15.99 €).");
                                                        System.out.println("Inserisci 2 per selezionare l'abbonamento mensile (30.59 €).");
                                                        System.out.println("inserisci 3 per tornare indietro");
                                                        sl8 = Integer.parseInt(scn.nextLine());
                                                        subTypeFunctionSel(sl8, "Colosseo", "05a2e1dc-653a-42f5-8e55-0cf50427a38d", cardId);
                                                    }

                                                    break;
                                                }

                                                case 2: {
                                                    int sl9 = 0;
                                                    while (sl9 != 3) {
                                                        System.out.println("Che tipo di abbonamento vuoi acquistare?");
                                                        System.out.println("Inserisci 1 per selezionare l'abbonamento settimanale (15.99 €).");
                                                        System.out.println("Inserisci 2 per selezionare l'abbonamento mensile (30.59 €).");
                                                        System.out.println("inserisci 3 per tornare indietro");
                                                        sl9 = Integer.parseInt(scn.nextLine());
                                                        subTypeFunctionSel(sl9, "Colosseo", "fe235d37-a3fa-4c6b-966e-47ac76b8c2ea", cardId);
                                                    }

                                                    break;
                                                }

                                                case 3:
                                                    break;

                                                default:
                                                    System.out.println("Scelta non valida");
                                            }
                                        }
                                        break;
                                    }

                                    case 4:
                                        break;

                                    default:
                                        System.out.println("Scelta non valida");
                                }

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
                case 3: {
                    int caso3 = 0;
                    while (caso3 !=7){

                        System.out.println("Dimmi quale tratta tra quelle qui presenti vuoi effettuare");
                        System.out.println("Inserisci 1 se vuoi effettuare la tratta da Colosseo a Tiburtina");
                        System.out.println("Inserisci 2 se vuoi effettuare la tratta da Colosseo a Termini");
                        System.out.println("Inserisci 3 se vuoi effettuare la tratta da Termini a Colosseo");
                        System.out.println("Inserisci 4 se vuoi effettuare la tratta da Termini a Tiburtina");
                        System.out.println("Inserisci 5 se vuoi effettuare la tratta da Tiburtina a Colosseo");
                        System.out.println("Inserisci 6 se vuoi effettuare la tratta da Tiburtina a Termini");
                        System.out.println("Inserisci 7 per tornare indietro");
                        caso3 = Integer.parseInt(scn.nextLine());
                        routeFunctionsSel(caso3, scn);

                    }
                    break;
                }
                default:
                    System.out.println("Scelta non valida");
            }
        }
    }

    private static void subTypeFunctionSel(int el, String location, String idRetailer, String idCard) {
        EntityManager em = emf.createEntityManager();
        TicketOfficeDao tod = new TicketOfficeDao(em);
        RetailerDao rld = new RetailerDao(em);
        CardDao cd = new CardDao(em);

        switch (el) {
            case 1: {
                Subscription subscription = new Subscription(location, LocalDate.now(), rld.findById(idRetailer), SubscriptionType.WEEKLY, cd.findById(idCard));
                tod.ticketOfficeSave(subscription);
                System.out.println("Grazie per l'acquisto!");
                break;
            }

            case 2: {
                Subscription subscription = new Subscription(location, LocalDate.now(), rld.findById(idRetailer), SubscriptionType.MONTLY, cd.findById(idCard));
                tod.ticketOfficeSave(subscription);
                System.out.println("Grazie per l'acquisto!");
                break;
            }

            case 3:
                break;

            default:
                System.out.println("Dato inserito non valido");
        }
    }

    private static void ticketTypeFunctionSel(int el, String location, String id) {

        EntityManager em = emf.createEntityManager();
        TicketOfficeDao tod = new TicketOfficeDao(em);
        RetailerDao rld = new RetailerDao(em);

        switch (el) {
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

            case 4:
                break;

            default:
                System.out.println("Dato inserito non valido");
        }
    }

    public static void publicTransportFunctionsAllTransportStatusSel(int caso2) {

        EntityManager em = emf.createEntityManager();
        PublicTransportDao ptd = new PublicTransportDao(em);
        switch (caso2) {
            case 1: {
                ptd.findAllPublicTransportByStatus(StatePublicTransport.MAINTENANCE);
                break;
            }
            case 2: {
                ptd.findAllPublicTransportByStatus(StatePublicTransport.ON_DUTY);
                break;
            }
            case 3:
                break;
            default:
                System.out.println("Selezione non valida");
                break;
        }


    }

    public static void routeFunctionsSel (int caso3, Scanner scn){
        EntityManager em = emf.createEntityManager();
        TransportRouteDao trd = new TransportRouteDao(em);

        switch (caso3){
            case 1 :{
                System.out.println("Hai selezionato la tratta Colosseo-Tiburtina");
                TransportRoute transportRoute = trd.findById("151465a3-ba59-4942-a74f-899736186912");
                System.out.println("Quale tipo di titolo viaggio possiedi?");
                System.out.println("Seleziona 1 per il biglietto");
                System.out.println("Seleziona 2 per il abbonamento");

                int  titoloViaggio = Integer.parseInt(scn.nextLine());
                switch (titoloViaggio){
                    case 1:{
                        TicketOfficeDao tod = new TicketOfficeDao(em);
                        System.out.println("Indicami il codice id del tuo biglietto");
                        String idBiglietto = scn.nextLine();
                        tod.validateTicket(idBiglietto,transportRoute.getPublicTransport().getId().toString());

                        break;
                    }
                    case 2:{
                        System.out.println("Hai effettuato la tratta scelta");
                        break;
                    }
                    default:{
                        System.out.println("Selezione non valida");
                        break;
                    }

                }
            }
            case 2:{

                System.out.println("Hai selezionato la tratta Colosseo-Termini");
                TransportRoute transportRoute = trd.findById("9947b9f2-fefe-4d46-afeb-8741488bc913");
                System.out.println("Quale tipo di titolo viaggio possiedi?");
                System.out.println("Seleziona 1 per il biglietto");
                System.out.println("Seleziona 2 per il abbonamento");
                int  titoloViaggio = Integer.parseInt(scn.nextLine());
                switch (titoloViaggio){
                    case 1:{
                        TicketOfficeDao tod = new TicketOfficeDao(em);
                        System.out.println("Indicami il codice id del tuo biglietto");
                        String idBiglietto = scn.nextLine();
                        tod.validateTicket(idBiglietto,transportRoute.getPublicTransport().getId().toString());


                        break;
                    }
                    case 2:{
                        System.out.println("Hai effettuato la tratta scelta");
                        break;
                    }
                    default:{
                        System.out.println("Selezione non valida");
                        break;
                    }

                }
            }
            case 3:{
                System.out.println("Hai selezionato la tratta Termini-Colosseo");
                System.out.println("Quale tipo di titolo viaggio possiedi?");
                System.out.println("Seleziona 1 per il biglietto");
                System.out.println("Seleziona 2 per il abbonamento");
                TransportRoute transportRoute =  trd.findById("54ecbc67-c085-4c0e-ae29-977a3a0efe4a");
                int  titoloViaggio = Integer.parseInt(scn.nextLine());
                switch (titoloViaggio){
                    case 1:{
                        TicketOfficeDao tod = new TicketOfficeDao(em);
                        System.out.println("Indicami il codice id del tuo biglietto");
                        String idBiglietto = scn.nextLine();
                        tod.validateTicket(idBiglietto,transportRoute.getPublicTransport().getId().toString());


                        break;
                    }
                    case 2:{
                        System.out.println("Hai effettuato la tratta scelta");
                        break;
                    }
                    default:{
                        System.out.println("Selezione non valida");
                        break;
                    }

                }
            }
            case 4:{
                System.out.println("Hai selezionato la tratta Termini-Tiburtina");
                TransportRoute transportRoute = trd.findById("6e946ea0-6206-4d16-b678-e06bac7a171e");
                System.out.println("Quale tipo di titolo viaggio possiedi?");

                System.out.println("Seleziona 1 per il biglietto");
                System.out.println("Seleziona 2 per il abbonamento");
                int  titoloViaggio = Integer.parseInt(scn.nextLine());
                switch (titoloViaggio){
                    case 1:{
                        TicketOfficeDao tod = new TicketOfficeDao(em);
                        System.out.println("Indicami il codice id del tuo biglietto");
                        String idBiglietto = scn.nextLine();
                        tod.validateTicket(idBiglietto,transportRoute.getPublicTransport().getId().toString());


                        break;
                    }
                    case 2:{
                        System.out.println("Hai effettuato la tratta scelta");
                        break;
                    }
                    default:{
                        System.out.println("Selezione non valida");
                        break;
                    }

                }
            }
            case 5:{

                System.out.println("Hai selezionato la tratta Tiburtina-Colosseo");
                TransportRoute transportRoute = trd.findById("a33162b0-2126-4203-90e8-184a9912773a");
                System.out.println("Quale tipo di titolo viaggio possiedi?");
                System.out.println("Seleziona 1 per il biglietto");
                System.out.println("Seleziona 2 per il abbonamento");
                int  titoloViaggio = Integer.parseInt(scn.nextLine());
                switch (titoloViaggio){
                    case 1:{
                        TicketOfficeDao tod = new TicketOfficeDao(em);
                        System.out.println("Indicami il codice id del tuo biglietto");
                        String idBiglietto = scn.nextLine();

                        tod.validateTicket(idBiglietto,transportRoute.getPublicTransport().getId().toString());


                        break;
                    }
                    case 2:{
                        System.out.println("Hai effettuato la tratta scelta");
                        break;
                    }
                    default:{
                        System.out.println("Selezione non valida");
                        break;
                    }

                }
            }
            case 6:{

                System.out.println("Hai selezionato la tratta Tiburtina-Termini");
                TransportRoute transportRoute = trd.findById("6a0be692-ff33-47a5-ab62-1d59846bcd8c");
                System.out.println("Quale tipo di titolo viaggio possiedi?");
                System.out.println("Seleziona 1 per il biglietto");
                System.out.println("Seleziona 2 per il abbonamento");
                int  titoloViaggio = Integer.parseInt(scn.nextLine());
                switch (titoloViaggio){
                    case 1:{
                        TicketOfficeDao tod = new TicketOfficeDao(em);
                        System.out.println("Indicami il codice id del tuo biglietto");
                        String idBiglietto = scn.nextLine();
                        tod.validateTicket(idBiglietto,transportRoute.getPublicTransport().getId().toString());


                        break;
                    }
                    case 2:{
                        System.out.println("Hai effettuato la tratta scelta");
                        break;
                    }
                    default:{
                        System.out.println("Selezione non valida");
                        break;
                    }

                }
            }

            case 7: break;
            default:   System.out.println("Scelta non valida");
        }
    }

}
