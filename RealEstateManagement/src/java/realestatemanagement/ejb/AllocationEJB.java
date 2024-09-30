package realestatemanagement.ejb;

import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import realestatemanagement.model.Allocation;
@Stateless
@LocalBean
public class AllocationEJB {

    @PersistenceContext(unitName = "RealEstateManagementPU")
    private EntityManager em;
    public List<Allocation> findAllocations() {
        Query query = em.createNamedQuery("findAllAllocations");
        return query.getResultList();
    }
}
