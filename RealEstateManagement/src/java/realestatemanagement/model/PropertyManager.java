package realestatemanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = "findAllPropertyManagers", query = "SELECT pm FROM PropertyManager pm")
//search proerty manager by first name and last name
@NamedQuery(name = "findPropertyManagerByName", query = "SELECT pm FROM PropertyManager pm WHERE pm.firstName = :firstName AND pm.lastName = :lastName")
public class PropertyManager {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    private String phone;
    private String mobile;
    private String email;

    public PropertyManager() {
    }

    public PropertyManager(String firstName, String LastName, String phone, String mobile, String email) {
        this.firstName = firstName;
        this.lastName = LastName;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
    }
    
    
    
    
    

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }



    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
}