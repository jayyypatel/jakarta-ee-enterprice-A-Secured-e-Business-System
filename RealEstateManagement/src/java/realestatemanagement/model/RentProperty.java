package realestatemanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import java.io.Serializable;

/**
 *
 * @author akshay benny
 * 
 */
@Entity
@NamedQuery(name = "findAllRentProperty", query = "SELECT r FROM RentProperty r")
public class RentProperty extends Property implements Serializable  {

    @Column(name = "WEEKLY_RENT", nullable = false)
    private Long weeklyRent;

    @Column(name = "IS_FURNISHED")
    private Boolean isFurnished;

    /**
     * @return the weeklyRent
     */
    public Long getWeeklyRent() {
        return weeklyRent;
    }

    /**
     * @param weeklyRent the weeklyRent to set
     */
    public void setWeeklyRent(Long weeklyRent) {
        this.weeklyRent = weeklyRent;
    }

    /**
     * @return the isFurnished
     */
    public Boolean getIsFurnished() {
        return isFurnished;
    }

    /**
     * @param isFurnished the isFurnished to set
     */
    public void setIsFurnished(Boolean isFurnished) {
        this.isFurnished = isFurnished;
    }

}
