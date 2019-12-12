/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author BQ
 */
public class Event {
    private String ID;
    private String label;
    private String description;
    public Event(){
    }

    public Event(String ID, String label, String description) {
        this.ID = ID;
        this.label = label;
        this.description = description;
    }
    
    public Event(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
}
