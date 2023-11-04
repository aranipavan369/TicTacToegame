package parkinglot.dto;

public class BillResponseDTO {
    private double amouunt;
    private String vehicleNumber;

    public double getAmouunt() {
        return amouunt;
    }

    public void setAmouunt(double amouunt) {
        this.amouunt = amouunt;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}
