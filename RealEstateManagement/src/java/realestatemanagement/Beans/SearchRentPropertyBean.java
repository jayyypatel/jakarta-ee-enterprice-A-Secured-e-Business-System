/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realestatemanagement.Beans;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import realestatemanagement.ejb.PropertyEJB;
import realestatemanagement.model.RentProperty;

@Named
@RequestScoped
public class SearchRentPropertyBean {

    @EJB
    private PropertyEJB propertyManager;

    private Long id;
    private RentProperty rentProperty;

    public String search() {
        rentProperty = propertyManager.findRentPropertyById(id);
        if (rentProperty != null) {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("propertyId", id);
//            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("propertyId", property.getId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Rent property found."));
            return "rentpropertydetails?faces-redirect=true"; // Redirects to the details page
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Rent property not found.", ""));
            return null; // Stay on the same page
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RentProperty getRentProperty() {
        return rentProperty;
    }

    public void setRentProperty(RentProperty rentProperty) {
        this.rentProperty = rentProperty;
    }
}