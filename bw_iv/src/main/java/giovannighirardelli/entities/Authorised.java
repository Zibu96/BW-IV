package giovannighirardelli.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("rivenditore")
public class Authorised extends Retailer{
    private String denomination;
    private Long license;
public Authorised(){}
    public Authorised(String location, String denomination, Long license) {
        super(location);
        this.denomination = denomination;
        this.license = license;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public Long getLicense() {
        return license;
    }

    public void setLicense(Long license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return "Authorised{" +
                "denomination='" + denomination + '\'' +
                ", license=" + license +
                ", id=" + id +
                '}';
    }
}
