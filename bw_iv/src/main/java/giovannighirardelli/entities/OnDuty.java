package giovannighirardelli.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
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

    @ManyToOne
    @JoinColumn(name = "mezzo")
    private PublicTransport publicTransport;


    public OnDuty() {
    }

    ;


    public OnDuty(LocalDate startDate, LocalDate endDate, double hourlyDailyService, PublicTransport publicTransport) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.hourlyDailyService = hourlyDailyService;
        this.publicTransport = publicTransport;
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

    public PublicTransport getPublicTransport() {
        return publicTransport;
    }

    public void setPublicTransport(PublicTransport publicTransport) {
        this.publicTransport = publicTransport;
    }

    @Override
    public String toString() {
        return "OnDuty{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", hourlyDailyService=" + hourlyDailyService +
                ", publicTransport=" + publicTransport +
                '}';
    }
}
