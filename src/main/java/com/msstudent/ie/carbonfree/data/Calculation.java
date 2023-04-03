package com.msstudent.ie.carbonfree.data;

import jakarta.persistence.*;

@Entity
@Table(name = "calculation")
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "calculation_id")
    private long calculationId;

    @Column(name = "calculation_result")
    private double calculationResult;

    private double calculationDistance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transport_id")
    private Transport transport;

    public Calculation() {
    }

    public Calculation(long calculationId, double calculationResult, double calculationDistance, Transport transport) {
        this.calculationId = calculationId;
        this.calculationResult = calculationResult;
        this.calculationDistance = calculationDistance;
        this.transport = transport;
    }

    public long getCalculationId() {
        return calculationId;
    }

    public void setCalculationId(long calculationId) {
        this.calculationId = calculationId;
    }

    public double getCalculationResult() {
        return calculationResult;
    }

    public void setCalculationResult(double calculationResult) {
        this.calculationResult = calculationResult;
    }

    public double getCalculationDistance() {
        return calculationDistance;
    }

    public void setCalculationDistance(double calculationDistance) {
        this.calculationDistance = calculationDistance;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }
}
