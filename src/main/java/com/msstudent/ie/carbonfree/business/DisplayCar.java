package com.msstudent.ie.carbonfree.business;

public class DisplayCar {

    private long transportId;
    private String transportBrand;
    private String transportModel;
    private String transportSize;
    private double transportEmission;

    public DisplayCar(String transportBrand, String transportModel, String transportSize, double transportEmission) {
        this.transportBrand = transportBrand;
        this.transportModel = transportModel;
        this.transportSize = transportSize;
        this.transportEmission = transportEmission;
    }

    public DisplayCar() {
    }

    public void setTransportId(long transportId) {
        this.transportId = transportId;
    }

    public long getTransportId() {
        return transportId;
    }
    public String getTransportBrand() {
        return transportBrand;
    }

    public void setTransportBrand(String transportBrand) {
        this.transportBrand = transportBrand;
    }

    public String getTransportModel() {
        return transportModel;
    }

    public void setTransportModel(String transportModel) {
        this.transportModel = transportModel;
    }

    public String getTransportSize() {
        return transportSize;
    }

    public void setTransportSize(String transportSize) {
        this.transportSize = transportSize;
    }

    public double getTransportEmission() {
        return transportEmission;
    }

    public void setTransportEmission(double transportEmission) {
        this.transportEmission = transportEmission;
    }
}
