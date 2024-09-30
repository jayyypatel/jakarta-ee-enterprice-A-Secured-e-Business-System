/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package realestatemanagement.ejb;

import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import realestatemanagement.model.PropertyManager;
import realestatemanagement.model.SaleProperty;

/**
 *
 * @author 12233612
 */
@Stateless
@LocalBean
public class PropertyManagerEJB {

 //attributes
 @PersistenceContext(unitName = "RealEstateManagementPU")
    private EntityManager em;
       public List<PropertyManager> findManagers() {
        Query query = em.createNamedQuery("findAllPropertyManagers");
        return query.getResultList();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
               
        public PropertyManager searchManager(String firstName, String lastName) {
            
        Query qry = em.createNamedQuery("findPropertyManagerByName");
        qry.setParameter("firstName",firstName);
        qry.setParameter("lastName",lastName);
        return (PropertyManager) qry.getSingleResult();
        
    }

     public PropertyManager createManager(PropertyManager manager){
           em.persist(manager);
           return manager;
       }
     public void deleteManager(PropertyManager manager){
            PropertyManager pm = em.find(PropertyManager.class, manager.getId());
              em.remove(pm);
         }

    

}
