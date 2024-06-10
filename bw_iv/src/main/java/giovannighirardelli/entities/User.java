package giovannighirardelli.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "utenti")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id_utente", nullable = false)
    private UUID userId;
    @Column(name = "nome", nullable = false)
    private String firstName;
    @Column(name = "cognome", nullable = false)
    private String lastName;
    @Column(name = "data_nascita")
    private LocalDate birthDate;
    @OneToMany(mappedBy = "user")
    private List<Card> cardsID;

    public User() {
    }


    public User(String firstName, String lastName, LocalDate birthDate) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public UUID getUserId() {
        return userId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Card> getCardsID() {
        return cardsID;
    }

    public void setCardsID(List<Card> cardsID) {
        this.cardsID = cardsID;
    }

    @Override
    public String toString() {
        return "User{" +
                "birthDate=" + birthDate +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
