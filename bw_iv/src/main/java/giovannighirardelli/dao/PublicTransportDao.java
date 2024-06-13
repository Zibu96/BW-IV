package giovannighirardelli.dao;

import giovannighirardelli.entities.Maintenance;
import giovannighirardelli.entities.OnDuty;
import giovannighirardelli.entities.PublicTransport;
import giovannighirardelli.enums.StatePublicTrasport;
import giovannighirardelli.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.UUID;

public class PublicTransportDao {

    private final EntityManager em;

    public PublicTransportDao(EntityManager em) {
        this.em = em;
    }

    public void publicTransportSave(PublicTransport publicTransport) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(publicTransport);
        transaction.commit();
        System.out.println("Mezzo: " + publicTransport.getTypePublicTrasport() + " inserito correttamente nel db!");
    }

    public PublicTransport findById(String id) {
        PublicTransport publicTransport = em.find(PublicTransport.class, UUID.fromString(id));
        if (publicTransport == null) throw new NotFoundException(id);
        return publicTransport;
    }

    public void findAndDeleteById(String id) {
        PublicTransport publicTransport = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(publicTransport);
        transaction.commit();
        System.out.println("Mezzo: " + publicTransport.getTypePublicTrasport() + " è stato correttamente eliminato");
    }

    public void findAllPublicTransportByStatus(StatePublicTrasport statePublicTrasport) {
        TypedQuery<PublicTransport> query = em.createQuery("SELECT a FROM PublicTransport a WHERE a.statePublicTrasport = :state", PublicTransport.class);
        query.setParameter("state", statePublicTrasport);

        if (query.getResultList().isEmpty())
            System.out.println("Nessun mezzo è attualmente in questo stato: " + statePublicTrasport);
        else query.getResultList().forEach(System.out::println);
    }

    public void getAPublicTransportStatus(String id) {
        TypedQuery<StatePublicTrasport> query = em.createQuery("SELECT a.statePublicTrasport FROM PublicTransport a WHERE a.id = :id", StatePublicTrasport.class);
        query.setParameter("id", UUID.fromString(id));

        if (query.getResultList().isEmpty()) System.out.println("Nessun mezzo trovato con id: " + id);
        else
            query.getResultList().forEach(statePublicTrasport -> System.out.println("Il mezzo con id: " + id + " è " + statePublicTrasport));
    }

    public void getBacklogOfTransportStatus(String id) {
        TypedQuery<Maintenance> query = em.createQuery("SELECT a FROM Maintenance a Where a.publicTransport.id = :id ORDER BY a.startDate", Maintenance.class);
        TypedQuery<OnDuty> query1 = em.createQuery("SELECT a FROM OnDuty a Where a.publicTransport.id = :id ORDER BY a.startDate", OnDuty.class);
        query.setParameter("id", UUID.fromString(id));
        query1.setParameter("id", UUID.fromString(id));
        System.out.println("Manutenzioni:");
        if (query.getResultList().isEmpty()) System.out.println("Nessuna manutenzione per il mezzo con id: " + id);
        else query.getResultList().forEach(System.out::println);
        System.out.println("\nIn Servizio:");
        if (query1.getResultList().isEmpty()) System.out.println("Nessun servizio per il mezzo con id: " + id);
        else query1.getResultList().forEach(System.out::println);
    }

}
