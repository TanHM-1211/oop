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
public class Organization extends SimpleObject{
    private int id;
    private String label;
    private String description;
    private Location location;

    public Organization(int id, String label, String description, Location location) {
    	super(id, label, description);
        this.location = location;
    }

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
    
}

