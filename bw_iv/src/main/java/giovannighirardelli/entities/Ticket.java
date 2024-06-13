package giovannighirardelli.entities;

import giovannighirardelli.enums.TicketType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("biglietto")
@Table (name = "biglietto")
public class Ticket extends TicketOffice {
    @Column(name = "validazione")
    private boolean validation;
    @Column(name = "data_validazione")
    private LocalDate validationDate;
    @Column(name = "tipologia_biglietto")
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;
    @ManyToOne
    @JoinColumn (name = "mezzo_di_trasporto")
    private PublicTransport publicTransport;

    public Ticket() {
    }

    public Ticket(String location, LocalDate emissionDate, Retailer retailer, TicketType ticketType) {
        super(location, emissionDate, retailer);

        this.validation = false;
        this.validationDate = null;
        this.ticketType = ticketType;
        if(ticketType == TicketType.ORDINARY) super.price = 1.5;
        else if (ticketType == TicketType.LONG_DISTANCE) super.price = 3.00;
        else if (ticketType == TicketType.SHORT_DISTANCE) super.price = 2.00;
    }


    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }

    public LocalDate getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(LocalDate validationDate) {
        this.validationDate = validationDate;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id"+ titleId +
                "validation=" + validation +
                ", validationDate=" + validationDate +
                ", ticketType=" + ticketType +
                '}';
    }
}
