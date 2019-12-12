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
public class Person extends SimpleObject{
    private int id;
    private String label;
    private String description;
    private Date date_of_birth;

    public Person(int id, String label, String description, Date date_of_birth) {
		super(id, label, description);
		this.date_of_birth = date_of_birth;	
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

    
}

