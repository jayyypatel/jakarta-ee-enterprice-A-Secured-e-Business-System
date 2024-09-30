package realestatemanagement.model;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 *
 * @author akshay benny
 * 
 */
@Entity
@NamedQuery(name = "findAllAllocations", query = "SELECT a FROM Allocation a")
@NamedQuery(name = "findAllocationByPropertyManager", query = "SELECT a FROM Allocation a WHERE a.propertyManager = :propertyManager")
public class Allocation   {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "property_manager_id", nullable = false)
    private PropertyManager propertyManager;
    
    @OneToOne
    @JoinColumn(name = "sale_property_id", nullable = false)
    private SaleProperty saleProperty;
    
    @OneToOne
    @JoinColumn(name = "rent_property_id", nullable = false)
    private RentProperty rentProperty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }

//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Allocation)) {
//            return false;
//        }
//        Allocation other = (Allocation) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "realestatemanagement.model.Allocation[ id=" + id + " ]";
    }

    /**
     * @return the saleProperty
     */
    public SaleProperty getSaleProperty() {
        return saleProperty;
    }

    /**
     * @param saleProperty the saleProperty to set
     */
    public void setSaleProperty(SaleProperty saleProperty) {
        this.saleProperty = saleProperty;
    }

    /**
     * @return the rentProperty
     */
    public RentProperty getRentProperty() {
        return rentProperty;
    }

    /**
     * @param rentProperty the rentProperty to set
     */
    public void setRentProperty(RentProperty rentProperty) {
        this.rentProperty = rentProperty;
    }

    /**
     * @return the propertyManager
     */
    public PropertyManager getPropertyManager() {
        return propertyManager;
    }

    /**
     * @param propertyManager the propertyManager to set
     */
    public void setPropertyManager(PropertyManager propertyManager) {
        this.propertyManager = propertyManager;
    }
    
}
