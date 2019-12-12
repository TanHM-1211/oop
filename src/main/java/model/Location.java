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
public class Location extends SimpleObject{
    private int id;
    private String label;
    private String description;

    public Location(int id, String label, String description) {
    	super(id, label, description);
    }
    
    
}
