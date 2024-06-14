package giovannighirardelli.utilities;

import java.util.Scanner;

public class MyScanner {

    public static void main(String[] args) {
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
                                        case 1:{
                                            
                                            break;
                                        }
                                        case 2:{
                                            break;
                                        }
                                        case 3:{
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


}
