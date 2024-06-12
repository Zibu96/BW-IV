package giovannighirardelli.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "manutenzione")
public class Maintenance {

    @Id
    @GeneratedValue
    protected UUID id;

    @Column(name = "descrizione")
    private String description;

    @Column(name = "data_inizio")
    private LocalDate startDate;

    @Column(name = "data_fine")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "mezzo")
    private PublicTransport publicTransport;


    public Maintenance() {
    }

    public Maintenance(String description, LocalDate startDate, LocalDate endDate, PublicTransport publicTransport) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.publicTransport = publicTransport;
    }

    public UUID getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public PublicTransport getPublicTransport() {
        return publicTransport;
    }

    public void setPublicTransport(PublicTransport publicTransport) {
        this.publicTransport = publicTransport;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", publicTransport=" + publicTransport +
                '}';
    }
}
