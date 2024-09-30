/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realestatemanagement.ejb;

/**
 *
 * @author harsh patel
 */
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import realestatemanagement.model.RentProperty;
import realestatemanagement.model.SaleProperty;

@Stateless
public class PropertyEJB {

    @PersistenceContext
    private EntityManager em;

    public void createSaleProperty(SaleProperty property) {
//        System.out.println("Persisting SaleProperty: " + property.getName());  // Log property details
        em.persist(property);   
    }
    
    // Fetch all sale properties
    public List<SaleProperty> findAllSaleProperties() {
        return em.createNamedQuery("findAllSaleProperty", SaleProperty.class).getResultList();
    }

    // Other methods for property management...

    public SaleProperty findSalePropertyById(Long id) {
        return em.find(SaleProperty.class, id);
    }
    
    // RentProperty related methods
    public void createRentProperty(RentProperty property) {
        em.persist(property);   
    }

    public List<RentProperty> findAllRentProperties() {
        return em.createNamedQuery("findAllRentProperty", RentProperty.class).getResultList();
    }

    public RentProperty findRentPropertyById(Long id) {
        return em.find(RentProperty.class, id);
    }
}
