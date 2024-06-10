package giovannighirardelli.entities;

import giovannighirardelli.enums.SubscriptionType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("abbonamento")
public class Subscription extends TicketOffice {
    @Column(name = "data_scadenza")
    private LocalDate expirationDate;
    @Column(name = "tipologia_abbonamento")
    @Enumerated(EnumType.STRING)
    private SubscriptionType subscriptionType;
    @ManyToOne
    @JoinColumn(name = "id_tessera")
    private Card card;

    public Subscription() {
    }


    public Subscription(String location, LocalDate emissionDate, double price, LocalDate expirationDate, SubscriptionType subscriptionType, Card card) {
        super(location, emissionDate, price);
        this.expirationDate = expirationDate;
        this.subscriptionType = subscriptionType;
        this.card = card;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "expirationDate=" + expirationDate +
                ", subscriptionType=" + subscriptionType +
                ", card=" + card +
                '}';
    }
}


