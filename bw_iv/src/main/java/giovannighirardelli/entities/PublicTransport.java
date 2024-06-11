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
}
