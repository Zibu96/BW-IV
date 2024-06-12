package giovannighirardelli.dao;

import giovannighirardelli.entities.TicketOffice;
import giovannighirardelli.entities.User;
import giovannighirardelli.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class UserDao {

    private final EntityManager em;

    public UserDao(EntityManager em) {
        this.em = em;
    }

    public void userSave(User user) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
        System.out.println("Utente: " +  user.getLastName() + " inserito correttamente nel db!");
    }

    public User findById(String id) {
        User user = em.find(User.class, UUID.fromString(id));
        if (user == null) throw new NotFoundException(id);
        return user;
    }

    public void findAndDeleteById(String id) {
        User found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Utente " + found.getLastName() + "è stato correttamente eliminato");
    }
}
