package giovannighirardelli.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tratta")
public class Route {
    @Id
    @GeneratedValue
    protected UUID id;

    @Column(name = "punto_partenza")
    private String departureOfTheRoute;

    @Column(name = "capolinea")
    private String terminal;

    @Column(name = "tempo_medio_percorrenza")
    private double averageTravelTime;

    @OneToMany(mappedBy = "route")
    private List<TransportRoute> transportRoutes;


    public Route() {
    }

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

    public List<TransportRoute> getTransportRoutes() {
        return transportRoutes;
    }

    public void setTransportRoutes(List<TransportRoute> transportRoutes) {
        this.transportRoutes = transportRoutes;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", departureOfTheRoute='" + departureOfTheRoute + '\'' +
                ", terminal='" + terminal + '\'' +
                ", averageTravelTime=" + averageTravelTime +

                '}';
    }
}
