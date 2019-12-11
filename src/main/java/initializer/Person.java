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
public class Person {
    private String ID;
    private String label;
    private String description;
    public Person(){
    }

    public Person(String ID, String label, String description) {
        this.ID = ID;
        this.label = label;
        this.description = description;
    }
    
    public Person(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
}

