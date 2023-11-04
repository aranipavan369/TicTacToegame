package parkinglot.models;

import parkinglot.models.constants.ParkingSlotStatus;
import parkinglot.models.constants.VehicleType;

public class ParkingSlot extends BaseModel{
    private int id;
    private int slotnumber;
    private VehicleType supportedVehicleType;
    private ParkingSlotStatus parkingSlotStatus;

    public ParkingSlot(int id, int number, VehicleType supportedVehicleType) {
        super(id);
        this.slotnumber = number;
        this.supportedVehicleType = supportedVehicleType;
        this.parkingSlotStatus = ParkingSlotStatus.EMPTY;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getSlotnumber() {
        return slotnumber;
    }

    public void setSlotnumber(int slotnumber) {
        this.slotnumber = slotnumber;
    }

    public VehicleType getVehicleType() {
        return supportedVehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.supportedVehicleType = vehicleType;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }
}
