package com.ht.event.model;

import java.util.Date;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "event")

public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String description;
    private Date date;
    private String day;
    private Time time;
    private float latitude;   //google api geo location
    private float longitude;  //google api geo location
    private String category;    // many to many
    private float fees;
    //image url
    //jsp for thiks -->>>

    public void setId(Integer id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public void setDate(Date date){
        this.date=date;
    }
    public void setDay(String day){
        this.day=day;
    }
    public void setTime(Time time){
        this.time=time;
    }
    public void setLatitude(float latitude){
        this.latitude=latitude;
    }
    public void setLongitude(float longitude){
        this.longitude=longitude;
    }
    public void setCategory(String category){
        this.category=category;
    }
    public void setFees(float fees){
        this.fees=fees;
    }


    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Date getDate() {
        return date;
    }
    public String getDay() {
        return day;
    }
    public Time getTime() {
        return time;
    }
    public float getLatitude() {
        return latitude;
    }
    public float getLongitude() {
        return longitude;
    }
    public String getCategory() {
        return category;
    }
    public float getFees() {
        return fees;
    }
}
