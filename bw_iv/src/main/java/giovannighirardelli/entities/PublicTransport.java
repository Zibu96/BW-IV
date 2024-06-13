package giovannighirardelli.entities;

import giovannighirardelli.enums.StatePublicTransport;
import giovannighirardelli.enums.TypePublicTrasport;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "mezzi_trasporto")
public class PublicTransport {
    @Id
    @GeneratedValue
    protected UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_trasporto_pubblico")
    private TypePublicTrasport typePublicTrasport;
    private int max_capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "stato_mezzo")
    private StatePublicTransport statePublicTransport;

    @OneToMany(mappedBy = "publicTransport")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "publicTransport")
    private List<TransportRoute> transportRoutes;

    @OneToMany(mappedBy = "publicTransport")
    private List<OnDuty> onDuties;

    @OneToMany(mappedBy = "publicTransport")
    private List<Maintenance> maintenances;

    public PublicTransport() {
    }

    public PublicTransport(TypePublicTrasport typePublicTrasport, int max_capacity, StatePublicTransport statePublicTransport) {
        this.typePublicTrasport = typePublicTrasport;
        this.max_capacity = max_capacity;
        this.statePublicTransport = statePublicTransport;

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

    public StatePublicTransport getStatePublicTrasport() {
        return statePublicTransport;
    }

    public void setStatePublicTrasport(StatePublicTransport statePublicTransport) {
        this.statePublicTransport = statePublicTransport;
    }

    public List<TransportRoute> getRoutes() {
        return transportRoutes;
    }

    public void setRoutes(List<TransportRoute> transportRoutes) {
        this.transportRoutes = transportRoutes;
    }

    public List<OnDuty> getOnDuties() {
        return onDuties;
    }

    public void setOnDuties(List<OnDuty> onDuties) {
        this.onDuties = onDuties;
    }

    public List<Maintenance> getMaintenances() {
        return maintenances;
    }

    public void setMaintenances(List<Maintenance> maintenances) {
        this.maintenances = maintenances;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }


    @Override
    public String toString() {
        return "PublicTransport{" +
                "statePublicTrasport=" + statePublicTransport +
                ", max_capacity=" + max_capacity +
                ", typePublicTrasport=" + typePublicTrasport +
                ", id=" + id +
                '}';
    }
}
