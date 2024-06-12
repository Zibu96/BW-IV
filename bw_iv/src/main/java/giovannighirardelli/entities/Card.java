package giovannighirardelli.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tessere")
public class Card {
    @Id
    @GeneratedValue
    @Column(name = "tessera_id", nullable = false)
    private UUID cardId;
    @Column(name = "data_emissione", nullable = false)
    private LocalDate emissionDate;
    @Column(name = "data_scadenza")
    private LocalDate expirationDate;
    @Column(name = "validità", nullable = false)
    private boolean validation;
    @ManyToOne
    @JoinColumn(name = "utente")
    private User user;
    @OneToMany(mappedBy = "card")
    private List<Subscription> subscriptions;

    public Card() {
    }


    public Card(LocalDate emissionDate, User user) {
        this.emissionDate = emissionDate;
        this.expirationDate = emissionDate.plusYears(1);
        this.validation = false;
        this.user = user;
    }

    public UUID getCardId() {
        return cardId;
    }


    public LocalDate getEmissionDate() {
        return emissionDate;
    }

    public void setEmissionDate(LocalDate emissionDate) {
        this.emissionDate = emissionDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", emissionDate=" + emissionDate +
                ", expirationDate=" + expirationDate +
                ", validation=" + validation +
                ", user=" + user +
                '}';
    }
}
