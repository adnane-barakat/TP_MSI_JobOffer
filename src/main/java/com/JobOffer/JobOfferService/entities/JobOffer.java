package com.JobOffer.JobOfferService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
public class JobOffer {
    @Id
    @GeneratedValue
    private UUID uid;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startDayTime;
    private LocalTime endDayTime;
    private UUID student ;
    private int expirationDays ;
    private Instant creationTimestamps;
    @ManyToOne
    private Company owner;


    public JobOffer() {}

    public UUID getUid() {
        return uid;
    }

    public Company getOwner() {
        return owner;
    }
    public void setOwner(Company owner) {
        this.owner=owner;
    }

    public String getTitle(){
        return title;
    }
    public JobOffer setTitle(String title){
        this.title=title;
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    public JobOffer setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate(){
        return endDate;
    }
    public JobOffer setEndDate(LocalDate endDate){
        this.endDate=endDate;
        return this;
    }

    public LocalTime getStartDayTime(){
        return startDayTime;
    }
    public JobOffer setStartDaytime(LocalTime startDayTime){
        this.startDayTime=startDayTime;
        return this;
    }

    public LocalTime getEndDayTime(){
        return endDayTime;
    }
    public JobOffer setEndDayTime(LocalTime endDayTime){
        this.endDayTime=endDayTime;
        return this;
    }
    public UUID getStudent(){
        return student;
    }
    public JobOffer setStudent(UUID student){
        this.student=student;
        return this;
    }

    public int getExpirationDays(){
        return expirationDays;
    }
    public JobOffer setExpirationDays(int expirationDays){
        this.expirationDays=expirationDays;
        return this;
    }

    public Instant getCreationTimestamps(){
        return creationTimestamps;
    }
    public JobOffer setCreationTimestamps(Instant creationTimestamps){
        this.creationTimestamps=creationTimestamps;
        return this;
    }


}
