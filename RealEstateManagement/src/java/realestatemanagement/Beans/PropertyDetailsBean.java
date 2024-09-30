/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realestatemanagement.Beans;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import realestatemanagement.ejb.PropertyEJB;
import realestatemanagement.model.SaleProperty;

@Named
@ViewScoped
public class PropertyDetailsBean implements Serializable{

    @EJB
    private PropertyEJB propertyManager;

    private SaleProperty property;

    @PostConstruct
    public void init() {
        Long propertyId = (Long) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("propertyId");
        System.out.println(propertyId + "hello this is id");
        if (propertyId != null) {
            property = propertyManager.findSalePropertyById(propertyId);
        }
    }

    public SaleProperty getProperty() {
        return property;
    }
}
