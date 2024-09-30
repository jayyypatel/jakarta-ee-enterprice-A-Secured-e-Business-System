package jsf;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import realestatemanagement.ejb.AllocationEJB;

@Named("allocationController")
@RequestScoped
public class AllocationController {
    @EJB
    private AllocationEJB allocationEJB;


    public String doCreateAllocation() {
        return null;
    }

    public int allocationCount() {
        return allocationEJB.findAllocations().size();

    }


}
