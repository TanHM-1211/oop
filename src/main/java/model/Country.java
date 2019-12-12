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
public class Country extends Object{
    private int id;
    private String label;
    private String description;
    
    public Country(){
    }
    
    public Country(int id, String label, String description) {
        this.id = id;
        this.label = label;
        this.description = description;
    }
    
}

