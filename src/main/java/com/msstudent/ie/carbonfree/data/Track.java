package com.msstudent.ie.carbonfree.data;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "track")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long track_id;
    private String referenceCode;
    private LocalDate saveDate;

    private int mondayDistance;
    private int mondayCarbonFootprint;

    private int tuesdayDistance;
    private int tuesdayCarbonFootprint;

    private int wednesdayDistance;
    private int wednesdayCarbonFootprint;

    private int thursdayDistance;
    private int thursdayCarbonFootprint;

    private int fridayDistance;
    private int fridayCarbonFootprint;

    public Track() {

    }

    public Track(long track_id, String referenceCode, LocalDate saveDate, int mondayDistance, int mondayCarbonFootprint, int tuesdayDistance, int tuesdayCarbonFootprint, int wednesdayDistance, int wednesdayCarbonFootprint, int thursdayDistance, int thursdayCarbonFootprint, int fridayDistance, int fridayCarbonFootprint) {
        this.track_id = track_id;
        this.referenceCode = referenceCode;
        this.saveDate = saveDate;
        this.mondayDistance = mondayDistance;
        this.mondayCarbonFootprint = mondayCarbonFootprint;
        this.tuesdayDistance = tuesdayDistance;
        this.tuesdayCarbonFootprint = tuesdayCarbonFootprint;
        this.wednesdayDistance = wednesdayDistance;
        this.wednesdayCarbonFootprint = wednesdayCarbonFootprint;
        this.thursdayDistance = thursdayDistance;
        this.thursdayCarbonFootprint = thursdayCarbonFootprint;
        this.fridayDistance = fridayDistance;
        this.fridayCarbonFootprint = fridayCarbonFootprint;
    }

    public long getTrack_id() {
        return track_id;
    }

    public void setTrack_id(long track_id) {
        this.track_id = track_id;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public LocalDate getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(LocalDate saveDate) {
        this.saveDate = saveDate;
    }

    public int getMondayDistance() {
        return mondayDistance;
    }

    public void setMondayDistance(int mondayDistance) {
        this.mondayDistance = mondayDistance;
    }

    public int getMondayCarbonFootprint() {
        return mondayCarbonFootprint;
    }

    public void setMondayCarbonFootprint(int mondayCarbonFootprint) {
        this.mondayCarbonFootprint = mondayCarbonFootprint;
    }

    public int getTuesdayDistance() {
        return tuesdayDistance;
    }

    public void setTuesdayDistance(int tuesdayDistance) {
        this.tuesdayDistance = tuesdayDistance;
    }

    public int getTuesdayCarbonFootprint() {
        return tuesdayCarbonFootprint;
    }

    public void setTuesdayCarbonFootprint(int tuesdayCarbonFootprint) {
        this.tuesdayCarbonFootprint = tuesdayCarbonFootprint;
    }

    public int getWednesdayDistance() {
        return wednesdayDistance;
    }

    public void setWednesdayDistance(int wednesdayDistance) {
        this.wednesdayDistance = wednesdayDistance;
    }

    public int getWednesdayCarbonFootprint() {
        return wednesdayCarbonFootprint;
    }

    public void setWednesdayCarbonFootprint(int wednesdayCarbonFootprint) {
        this.wednesdayCarbonFootprint = wednesdayCarbonFootprint;
    }

    public int getThursdayDistance() {
        return thursdayDistance;
    }

    public void setThursdayDistance(int thursdayDistance) {
        this.thursdayDistance = thursdayDistance;
    }

    public int getThursdayCarbonFootprint() {
        return thursdayCarbonFootprint;
    }

    public void setThursdayCarbonFootprint(int thursdayCarbonFootprint) {
        this.thursdayCarbonFootprint = thursdayCarbonFootprint;
    }

    public int getFridayDistance() {
        return fridayDistance;
    }

    public void setFridayDistance(int fridayDistance) {
        this.fridayDistance = fridayDistance;
    }

    public int getFridayCarbonFootprint() {
        return fridayCarbonFootprint;
    }

    public void setFridayCarbonFootprint(int fridayCarbonFootprint) {
        this.fridayCarbonFootprint = fridayCarbonFootprint;
    }
}
