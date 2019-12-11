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
public class Subject {
    private String ID;
    private String label;
    private String description;
    public Subject(){
    }

    public Subject(String ID, String label, String description) {
        this.ID = ID;
        this.label = label;
        this.description = description;
    }
    
    public Subject(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
}

