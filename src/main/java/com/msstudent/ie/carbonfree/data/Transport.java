package com.msstudent.ie.carbonfree.data;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transport")
public class Transport {
    @Id
    @SequenceGenerator(
            name = "transport_sequence",
            sequenceName = "transport_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transport_sequence"
    )
    private long transportId;
    private String transportBrand;
    private String transportModel;
    private String transportSize;

    private double transportEmission;

    @OneToMany(mappedBy = "transport")
    private List<Calculation> orders = new ArrayList<>();

    public Transport(){

    }

    public Transport(long transportId, String transportBrand, String transportModel, String transportSize, double transportEmission, List<Calculation> orders) {
        this.transportId = transportId;
        this.transportBrand = transportBrand;
        this.transportModel = transportModel;
        this.transportSize = transportSize;
        this.transportEmission = transportEmission;
        this.orders = orders;
    }

    public long getTransportId() {
        return transportId;
    }

    public void setTransportId(long transportId) {
        this.transportId = transportId;
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

    public List<Calculation> getOrders() {
        return orders;
    }

    public void setOrders(List<Calculation> orders) {
        this.orders = orders;
    }
}
