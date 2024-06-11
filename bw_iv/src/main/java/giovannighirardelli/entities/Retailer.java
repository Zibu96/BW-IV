package giovannighirardelli.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table (name = "distributore")
@Inheritance (strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_distributore")
public abstract class Retailer {
    @Id
    @GeneratedValue
    @Column (name = "distributore_id", nullable = false)
    protected UUID id;
private String location;
public Retailer(){}
    public Retailer(String location) {
        this.location = location;
    }

    public UUID getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Retailer{" +
                "id=" + id +
                ", location='" + location + '\'' +
                '}';
    }
}
