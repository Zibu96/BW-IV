package giovannighirardelli.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "servizio")
public class OnDuty {
    @Id
    @GeneratedValue
    protected UUID id;
    @Column(name = "data_inizio")
    private LocalDate startDate;
    @Column(name = "data_fine")
    private LocalDate endDate;
    @Column(name = "ore_servizio")
    private double hourlyDailyService;
    @ManyToMany
    @JoinTable(name = "trasportiId_inServizioId", joinColumns = @JoinColumn(name = "mezzo_trasporto", nullable = false), inverseJoinColumns = @JoinColumn(name = "in_servizio", nullable = false))

    private List<PublicTransport> transports;

    public OnDuty() {
    }

    public OnDuty(LocalDate startDate, LocalDate endDate, double hourlyDailyService) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.hourlyDailyService = hourlyDailyService;
    }

    public UUID getId() {
        return id;
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

    public double getHourlyDailyService() {
        return hourlyDailyService;
    }

    public void setHourlyDailyService(double hourlyDailyService) {
        this.hourlyDailyService = hourlyDailyService;
    }

    @Override
    public String toString() {
        return "OnDuty{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", hourlyDailyService=" + hourlyDailyService +
                '}';
    }
}
