package giovannighirardelli.entities;

import giovannighirardelli.enums.StatePublicTrasport;
import giovannighirardelli.enums.TypePublicTrasport;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table (name = "mezzi_trasporto")
public class PublicTransport {
    @Id
    @GeneratedValue
    protected UUID id;
    @Enumerated (EnumType.STRING)
    @Column(name = "tipo_trasporto_pubblico")
    private TypePublicTrasport typePublicTrasport;
    private int max_capacity;
@Enumerated(EnumType.STRING)
    @Column(name = "stato_mezzo")
    private StatePublicTrasport statePublicTrasport;
@OneToMany (mappedBy = "publicTransport")
    private List<Ticket> tickets;
@ManyToMany (mappedBy = "publicTransports")
    private List<Route> routes;
@ManyToMany (mappedBy = "publicTransports")
private List<Maintenance> maintenances;
@ManyToMany (mappedBy = "transports")
private List<OnDuty> onDutyList;
public PublicTransport(){}
    public PublicTransport(TypePublicTrasport typePublicTrasport, int max_capacity, StatePublicTrasport statePublicTrasport) {
        this.typePublicTrasport = typePublicTrasport;
        this.max_capacity = max_capacity;
        this.statePublicTrasport = statePublicTrasport;
    }

    public UUID getId() {
        return id;
    }



    public TypePublicTrasport getTypePublicTrasport() {
        return typePublicTrasport;
    }

    public void setTypePublicTrasport(TypePublicTrasport typePublicTrasport) {
        this.typePublicTrasport = typePublicTrasport;
    }

    public int getMax_capacity() {
        return max_capacity;
    }

    public void setMax_capacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }

    public StatePublicTrasport getStatePublicTrasport() {
        return statePublicTrasport;
    }

    public void setStatePublicTrasport(StatePublicTrasport statePublicTrasport) {
        this.statePublicTrasport = statePublicTrasport;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    @Override
    public String toString() {
        return "PublicTransport{" +
                "statePublicTrasport=" + statePublicTrasport +
                ", max_capacity=" + max_capacity +
                ", typePublicTrasport=" + typePublicTrasport +
                ", id=" + id +
                '}';
    }
}
