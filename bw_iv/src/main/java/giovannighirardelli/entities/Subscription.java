package giovannighirardelli.entities;

import giovannighirardelli.enums.SubscriptionType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("abbonamento")
@Table (name = "abbonamento")
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


    public Subscription(String location, LocalDate emissionDate, Retailer retailer, SubscriptionType subscriptionType, Card card) {
        super(location, emissionDate, retailer);
        this.subscriptionType = subscriptionType;
        if(subscriptionType == SubscriptionType.MONTLY)

        {

            this.expirationDate = this.emissionDate.plusMonths(1);
            super.price = 30.59;
        }
        else if (subscriptionType == SubscriptionType.WEEKLY)

        {

            this.expirationDate = this.emissionDate.plusWeeks(1);
            super.price = 15.99;
        }


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


