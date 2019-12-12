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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Agreement {
    private String ID;
    private String label;
    private String description;
    private Time time;
    private Location location;
    
    public Agreement(){
    }
    
    public Agreement( String ID, String label, String desc,Time time,Location local){
        this.ID = ID;
        this.label=label;
        this.description=desc;
        this.time = time;
        this.location = local;
    }
    
    public Agreement(String label){
        this.label=label;
    }
    
    public String getLabel() {
        return label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
}

