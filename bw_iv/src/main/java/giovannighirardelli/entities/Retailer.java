package giovannighirardelli.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table (name = "distributore")
@Inheritance (strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_distributore")
public abstract class Retailer {

    @Id
    @GeneratedValue
    @Column (name = "distributore_id", nullable = false)
    protected UUID id;

    @Column(name = "localita")
    protected String location;

    @OneToMany (mappedBy = "retailerId")
    protected List<TicketOffice> ticketOffice;


public Retailer(){}
    public Retailer(String location) {
        this.location = location;
    }

    public List<TicketOffice> getTicketOffice() {
        return ticketOffice;
    }

    public void setTicketOffice(List<TicketOffice> ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public UUID getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Retailer{" +
                "id=" + id +
                ", location='" + location + '\'' +
                '}';
    }
}
