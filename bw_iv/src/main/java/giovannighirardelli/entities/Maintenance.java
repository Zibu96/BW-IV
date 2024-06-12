package giovannighirardelli.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "manutenzione")
public class Maintenance {

    @Id
    @GeneratedValue
    protected UUID id;

    @Column (name = "descrizione")
    private String description;

    @Column (name = "data_inizio")
    private LocalDate startDate;

    @Column (name = "data_fine")
    private LocalDate endDate;

    @ManyToMany
    @JoinTable (name = "mezziId_manutenzioneId", joinColumns = @JoinColumn(name = "mezzi_trasporto", nullable = false), inverseJoinColumns = @JoinColumn(name = "manutenzione", nullable = false))
    private List<PublicTransport> publicTransports;

    public Maintenance (){}

    public Maintenance(String description, LocalDate startDate, LocalDate endDate) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.publicTransports = new ArrayList<>();
    }

    public void addPublicTransportToMaintenance(PublicTransport publicTransport) {
        this.getPublicTransports().forEach(System.out::println);
        this.getPublicTransports().add(publicTransport);
        System.out.println("Mezzo di trasporto aggiunto con successo alla rotta!");
    }

    public UUID getId() {
        return id;
    }

    public List<PublicTransport> getPublicTransports() {
        return publicTransports;
    }

    public void setPublicTransports(List<PublicTransport> publicTransports) {
        this.publicTransports = publicTransports;
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
                '}';
    }
}
