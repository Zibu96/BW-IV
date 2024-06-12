package giovannighirardelli.dao;

import giovannighirardelli.entities.Card;
import giovannighirardelli.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class CardDao {

    private final EntityManager em;

    public CardDao(EntityManager em) {
        this.em = em;
    }

    public void cardSave(Card card ) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(card);
        transaction.commit();
        System.out.println("Carta con id:" + card.getCardId() + "inserita correttamente nel db!");
    }

    public Card findById(String id) {
        Card card = em.find(Card.class, UUID.fromString(id));
        if (card == null) throw new NotFoundException(id);
        return card;
    }

    public void findAndDeleteById(String id) {
        Card found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Carta con id:" + found.getCardId() + "è stata correttamente eliminato");
    }
}
