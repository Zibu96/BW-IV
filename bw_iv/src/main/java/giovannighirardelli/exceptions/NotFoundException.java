package giovannighirardelli.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String id) {
        System.out.println("L'emento  " + id + " non è stato trovato!... O non è stato invitato...");
    }
}
