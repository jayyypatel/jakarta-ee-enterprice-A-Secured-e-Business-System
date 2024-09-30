/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsf;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.PersistenceContext;
import realestatemanagement.ejb.*;
import realestatemanagement.model.*;

/**
 *
 * @author 12233612
 */

@Named ("managerController")
@RequestScoped
public class PropertyManagerController {
        @EJB
    private PropertyManagerEJB propertyManagerEJB;

     private PropertyManager manager = new PropertyManager();
    private PropertyManager aManager ;
 private List<PropertyManager> managerList = new ArrayList<PropertyManager>();

    public String doCreateManager() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (manager.getFirstName()==null ||"".equals(manager.getFirstName())){
            context.addMessage("managerForm:", new FacesMessage("First Name is required"));
            return null;
        }
        if (manager.getLastName()==null ||"".equals(manager.getLastName())){
            context.addMessage("managerForm:", new FacesMessage("Last Name is required"));
            return null;
        }
        if (manager.getEmail()==null ||"".equals(manager.getEmail())){
            context.addMessage("managerForm:", new FacesMessage("Email is required"));
            return null;
        }
        if (manager.getPhone()==null ||"".equals(manager.getPhone())){
            context.addMessage("managerForm:", new FacesMessage("Phone Number is required"));
            return null;
        }
        if (manager.getMobile()==null ||"".equals(manager.getMobile())){
            context.addMessage("managerForm:", new FacesMessage("Mobile is required"));
            return null;
        }

        if (context.getMessageList().size() != 0)
            return null;

        try {
            manager = propertyManagerEJB.createManager(manager);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Property Manager has been created", "Property manager" + manager.getFirstName()+manager.getLastName() + " has been created successfully"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Manager hasn't been created", e.getMessage()));
        }

        managerList = propertyManagerEJB.findManagers();
        return "listManagers.xhtml";
    }

    public  String doDeleteManager(PropertyManager manager){
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            propertyManagerEJB.deleteManager(manager);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Property Manager has been deleted", "Property manager" + manager.getFirstName()+manager.getLastName() + " has been deleted successfully"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Manager hasn't been deleted", e.getMessage()));
        }
        managerList = propertyManagerEJB.findManagers();
        return "listManagers.xhtml";
    }
    public String  view(PropertyManager manager){
        aManager = manager;
        return "viewManager.xhtml";
    }









}
