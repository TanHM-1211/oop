/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * object Time
 * @author BQ
 */
public class Time {
    private String ID;
    private String label;
    private String description;
    public Time(){
    }

    public Time(String ID, String label, String description) {
        this.ID = ID;
        this.label = label;
        this.description = description;
    }
    
    public Time(String label) {
        this.ID = ID;
        this.label = label;
        this.description = description;
    }
    
    public String getLabel() {
        return label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
}