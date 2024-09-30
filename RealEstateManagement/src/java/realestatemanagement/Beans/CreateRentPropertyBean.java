/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realestatemanagement.Beans;


import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import realestatemanagement.ejb.PropertyEJB;
import realestatemanagement.model.Address;
import realestatemanagement.model.RentProperty;
import realestatemanagement.model.SaleProperty;

/**
 *
 * @author harsh
 */
@Named
@RequestScoped
public class CreateRentPropertyBean {
    
    @EJB
    private PropertyEJB propertyManager;

    private RentProperty property;
    private Address address;
    
    public CreateRentPropertyBean() {
        property = new RentProperty();
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

    public Long getWeeklyRent() {
        return property.getWeeklyRent();
    }

    public void setWeeklyRent(Long salePrice) {
        property.setWeeklyRent(salePrice);
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

    public Long getZipCode() {
        return address.getPostcode();
    }

    public void setZipCode(Long zipCode) {
        address.setPostcode(zipCode);
    }
    
    public Boolean getIsFurnished() {
        return property.getIsFurnished();
    }

    public void setIsFurnished(Boolean isfrunished) {
        property.setIsFurnished(isfrunished);
    }

    public String createProperty() {
        property.setAddress(address);
        propertyManager.createRentProperty(property);
        return "rentpropertylist?faces-redirect=true";

    }

    public RentProperty getRentProperty() {
        return property;
    }

    public void setRentProperty(RentProperty rentProperty) {
        this.property = rentProperty;
    }
}