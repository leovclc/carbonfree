package com.msstudent.ie.carbonfree.business;

import java.time.LocalDate;
import java.util.Map;

public class TrackData {
    private LocalDate date;
    private String referenceCode;
    private Map<String, Map<String, Integer>> data;

    public TrackData() {

    }

    public TrackData(LocalDate date, String referenceCode, Map<String, Map<String, Integer>> data) {
        this.date = date;
        this.referenceCode = referenceCode;
        this.data = data;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public Map<String, Map<String, Integer>> getData() {
        return data;
    }

    public void setData(Map<String, Map<String, Integer>> data) {
        this.data = data;
    }
}
