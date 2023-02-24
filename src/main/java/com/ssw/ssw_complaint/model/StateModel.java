package com.ssw.ssw_complaint.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;;

@Entity
@Table(name = "state")
public class StateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /*
     * รับเรื่อง NEW
     * พิจารณาสอบสวน DOING
     * ตอบลูกค้า DONE
     */

    private Integer id;
    private String description; 
    private Integer active;
   
    public Integer get_id() {
        return id;
    }

    public void set_id(Integer id) {
        this.id = id;
    }

    public String get_description() {
        return description;
    }

    public void set_description(String description) {
        this.description = description;
    }  

    public Integer get_active() {
        return active;
    }

    public void set_active(Integer active) {
        this.active = active;
    }
    
    
}
