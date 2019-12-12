/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author BQ
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Agreement extends SimpleObject{
    private int id;
    private String label;
    private String description;
    private Date date;
    private Location location;
    
    
    public Agreement(int id, String label, String description, Date time, Location location) {
    	super(id, label, description);
		this.date = time;
		this.location = location;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date time) {
		this.date = time;
	}


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}

    

}

