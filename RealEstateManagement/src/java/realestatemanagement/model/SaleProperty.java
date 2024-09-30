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
@NamedQuery(name = "findAllSaleProperty", query = "SELECT s FROM SaleProperty s")
public class SaleProperty extends Property implements Serializable {


    @Column(name = "SALE_PRICE", nullable = false)
    private Long salePrice;
    
//    @Override
//    public String toString() {
//        return "realestatemanagement.model.SaleProperty[ id=" + thisid + " ]";
//    }

    /**
     * @return the salePrice
     */
    public Long getSalePrice() {
        return salePrice;
    }

    /**
     * @param salePrice the salePrice to set
     */
    public void setSalePrice(Long salePrice) {
        this.salePrice = salePrice;
    }

}
