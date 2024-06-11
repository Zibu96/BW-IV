package giovannighirardelli.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table (name = "servizio")
public class OnDuty {
    @Id
    @GeneratedValue
    protected UUID id;
    @Column (name = "data_inizio")
    private LocalDate startDate;
    @Column (name = "data_fine")
    private LocalDate endDate;
    @Column (name = "ore_servizio")
    private double hourlyDailyService;
}
