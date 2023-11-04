package parkinglot.models;

import parkinglot.models.constants.VehicleType;

import java.lang.ref.SoftReference;

public class Vehicle extends BaseModel{
    private String number;
    private String model;
    private VehicleType vehicleType;
    private String color;
    public Vehicle(String number, String name, String color, VehicleType vehicleType) {
        this.number = number;
        this.model = name;
        this.color = color;
        this.vehicleType = vehicleType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
