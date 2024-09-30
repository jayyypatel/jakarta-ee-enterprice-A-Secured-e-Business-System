/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realestatemanagement.Beans;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import realestatemanagement.ejb.PropertyEJB;
import realestatemanagement.model.SaleProperty;

@Named
@RequestScoped
public class SearchSalePropertyBean {

    private Long propertyId;

    @Inject
    private PropertyEJB propertyManager; // Assume this is your EJB or service class for DB operations

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String search() {
        SaleProperty property = propertyManager.findSalePropertyById(propertyId);
//        System.out.println("hwllo" + property);
//        System.out.println("-------" + property.getId());
        if (property != null) {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("propertyId", propertyId);
//            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("propertyId", property.getId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sale property found."));
            return "salepropertydetails?faces-redirect=true"; // Redirects to the details page
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sale property not found.", ""));
            return null; // Stay on the same page
        }
    }
}
