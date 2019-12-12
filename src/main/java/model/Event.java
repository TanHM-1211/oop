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
public class Event extends SimpleObject{
    private int id;
    private String label;
    private String description;
    private Date date;
    private Location loccation;
   

	public Event(int id, String label, String description, Date date, Location loccation) {
		super(id, label, description);
		this.date = date;
		this.loccation = loccation;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Location getLocation() {
		return loccation;
	}

	public void setLocation(Location loccation) {
		this.loccation = loccation;
	}
	

}

