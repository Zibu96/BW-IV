package giovannighirardelli.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table (name = "tratta")
public class Route {
    @Id
    @GeneratedValue
    protected UUID id;
    @Column (name = "punto_partenza")
    private String departureOfTheRoute;
    @Column (name = "capolinea")
    private String terminal;
    @Column (name = "tempo_medio_percorrenza")
    private double averageTravelTime;
    @Column (name = "tempo_effetivo_percorrenza")
    private double actualTravelTime;
    @ManyToMany
    @JoinTable (name = "tratta_trasporto_pubblico", joinColumns = @JoinColumn(name = "tratta_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "mezzo_trasporto_id", nullable = false))
    private List<PublicTransport> publicTransports;
public Route (){}
    public Route(String departureOfTheRoute, String terminal, double averageTravelTime) {
        this.departureOfTheRoute = departureOfTheRoute;
        this.terminal = terminal;
        this.averageTravelTime = averageTravelTime;
    }

    public UUID getId() {
        return id;
    }



    public String getDepartureOfTheRoute() {
        return departureOfTheRoute;
    }

    public void setDepartureOfTheRoute(String departureOfTheRoute) {
        this.departureOfTheRoute = departureOfTheRoute;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public double getAverageTravelTime() {
        return averageTravelTime;
    }

    public void setAverageTravelTime(double averageTravelTime) {
        this.averageTravelTime = averageTravelTime;
    }

    public double getActualTravelTime() {
        return actualTravelTime;
    }

    public void setActualTravelTime(double actualTravelTime) {
        this.actualTravelTime = actualTravelTime;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", departureOfTheRoute='" + departureOfTheRoute + '\'' +
                ", terminal='" + terminal + '\'' +
                ", averageTravelTime=" + averageTravelTime +
                ", actualTravelTime=" + actualTravelTime +
                '}';
    }
}
