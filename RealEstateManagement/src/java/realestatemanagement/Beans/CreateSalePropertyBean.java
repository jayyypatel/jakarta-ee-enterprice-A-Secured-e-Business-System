/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realestatemanagement.Beans;

/**
 *
 * @author harsh patel
 */
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import realestatemanagement.ejb.PropertyEJB;
import realestatemanagement.model.Address;
import realestatemanagement.model.SaleProperty;

@Named
@RequestScoped
public class CreateSalePropertyBean {

    @EJB
    private PropertyEJB propertyManager;

    private SaleProperty property;
    private Address address;

    public CreateSalePropertyBean() {
        property = new SaleProperty();
        address = new Address();
    }

    // Getters and setters for all fields

    public String getName() {
        return property.getName();
    }

    public void setName(String name) {
        property.setName(name);
    }

    public String getPropertyType() {
        return property.getPropertyType();
    }

    public void setPropertyType(String propertyType) {
        property.setPropertyType(propertyType);
    }

    public int getNoOfBedrooms() {
        return property.getNoOfBedrooms();
    }

    public void setNoOfBedrooms(int noOfBedrooms) {
        property.setNoOfBedrooms(noOfBedrooms);
    }

    public int getNoOfBathrooms() {
        return property.getNoOfBathrooms();
    }

    public void setNoOfBathrooms(int noOfBathrooms) {
        property.setNoOfBathrooms(noOfBathrooms);
    }

    public String getPropertyDescription() {
        return property.getPropertyDescription();
    }

    public void setPropertyDescription(String propertyDescription) {
        property.setPropertyDescription(propertyDescription);
    }

    public Long getSalePrice() {
        return property.getSalePrice();
    }

    public void setSalePrice(Long salePrice) {
        property.setSalePrice(salePrice);
    }

    public String getStreet() {
        return address.getStreetName();
    }

    public void setStreet(String street) {
        address.setStreetName(street);
    }

    public String getCity() {
        return address.getCity();
    }

    public void setCity(String city) {
        address.setCity(city);
    }
    
    public String getCountry() {
        return address.getCountry();
    }

    public void setCountry(String country) {
        address.setCountry(country);
    }

//    public String getState() {
//        return address.getState();
//    }
//
//    public void setState(String state) {
//        address.setState(state);
//    }

    public Long getZipCode() {
        return address.getPostcode();
    }

    public void setZipCode(Long zipCode) {
        address.setPostcode(zipCode);
    }

    public String createProperty() {
        try {
            property.setAddress(address);
            propertyManager.createSaleProperty(property);
            System.out.println("Property created: " + property.getName());  // Log after creation
            return "salepropertylist?faces-redirect=true";
        } catch (Exception e) {
            // Handle exception (e.g., add error message to faces context)
            return null;
        }
    }
}