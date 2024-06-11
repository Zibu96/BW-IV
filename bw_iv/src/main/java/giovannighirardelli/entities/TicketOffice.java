package giovannighirardelli.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "titolo_viaggio")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_titolo")
public abstract class TicketOffice {
    @Id
    @GeneratedValue
    @Column(name = "id_titolo", nullable = false)
    protected UUID titleId;
    @Column(name = "luogo_acquisto")
    protected String location;
    @Column(name = "data_emissione", nullable = false)
    protected LocalDate emissionDate;
    @Column(name = "prezzo", nullable = false)
    protected double price;
    @OneToMany (mappedBy = "ticketOffice")
    private List<Retailer> retailerId;


    public TicketOffice() {
    }


    public TicketOffice(String location, LocalDate emissionDate, double price) {
        this.location = location;
        this.emissionDate = emissionDate;
        this.price = price;
    }


    public UUID getTitleId() {
        return titleId;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getEmissionDate() {
        return emissionDate;
    }

    public void setEmissionDate(LocalDate emissionDate) {
        this.emissionDate = emissionDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "TicketOffice{" +
                "titleId=" + titleId +
                ", location='" + location + '\'' +
                ", emissionDate=" + emissionDate +
                ", price=" + price +
                '}';
    }
}
