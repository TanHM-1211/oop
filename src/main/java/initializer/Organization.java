/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package initializer;

/**
 *
 * @author BQ
 */
public class Organization {
    private String ID;
    private String label;
    private String description;
    private Location location;
    public Organization(){
    }

    public Organization(String ID, String label, String description, Location location) {
        this.ID = ID;
        this.label = label;
        this.description = description;
        this.location = location;
    }
    
    public Organization(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
}

