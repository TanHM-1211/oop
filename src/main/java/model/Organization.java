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
public class Organization extends Object{
    private int id;
    private String label;
    private String description;
    private Location location;
    public Organization(){
    }

    public Organization(int id, String label, String description, Location location) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.location = location;
    }

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
    
}

