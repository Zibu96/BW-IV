package giovannighirardelli.entities;

import giovannighirardelli.enums.TicketType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("biglietto")

public class Ticket extends TicketOffice {
    @Column(name = "validazione")
    private boolean validation;
    @Column(name = "data_validazione")
    private LocalDate validationDate;
    @Column(name = "tipologia_biglietto")
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;

    public Ticket() {
    }

    public Ticket(String location, LocalDate emissionDate, double price, TicketType ticketType) {
        super(location, emissionDate, price);
        this.validation = false;
        this.validationDate = null;
        this.ticketType = ticketType;
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
                "validation=" + validation +
                ", validationDate=" + validationDate +
                ", ticketType=" + ticketType +
                '}';
    }
}
