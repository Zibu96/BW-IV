package giovannighirardelli.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "trasporti_rotte")
public class TransportRoute {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_transport")
    private PublicTransport publicTransport;

    @ManyToOne
    @JoinColumn(name = "id_rotta")
    private Route route;

    @Column(name = "tempo_effettivo_percorrenza")
    private double actualTravelTime;


    public TransportRoute() {
    }

    public TransportRoute(PublicTransport publicTransport, Route route, double actualTravelTime) {
        this.publicTransport = publicTransport;
        this.route = route;
        this.actualTravelTime = actualTravelTime;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PublicTransport getPublicTransport() {
        return publicTransport;
    }

    public void setPublicTransport(PublicTransport publicTransport) {
        this.publicTransport = publicTransport;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public double getActualTravelTime() {
        return actualTravelTime;
    }

    public void setActualTravelTime(double actualTravelTime) {
        this.actualTravelTime = actualTravelTime;
    }


    @Override
    public String toString() {
        return "TransportRoute{" +
                "id=" + id +
                ", publicTransport=" + publicTransport +
                ", route=" + route +
                ", actualTravelTime=" + actualTravelTime +
                '}';
    }
}
