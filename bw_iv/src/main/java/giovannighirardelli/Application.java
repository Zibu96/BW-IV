package giovannighirardelli;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

import static giovannighirardelli.utilities.MyScanner.myScanner;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti");

    public static void main(String[] args) {

       myScanner();
    }

}


