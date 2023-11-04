package parkinglot.models;

import parkinglot.models.constants.ParkingLotStatus;
import parkinglot.models.constants.VehicleType;
import parkinglot.services.feecalculationstrategy.BillCalculationStrategy;
import parkinglot.services.slotallocationstrategy.SlotAllocationStrategy;

import java.util.List;

public class ParkingLot extends BaseModel{
    private int id;
    private String name;
    private String address;
    private List<ParkingFloor> parkingFloors;
    private List<VehicleType> supportedVehicleTypes;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(List<VehicleType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public BillCalculationStrategy getFeeCalculationStrategy() {
        return feeCalculationStrategy;
    }

    public void setFeeCalculationStrategy(BillCalculationStrategy feeCalculationStrategy) {
        this.feeCalculationStrategy = feeCalculationStrategy;
    }

    public SlotAllocationStrategy getSlotAllocationStrategy() {
        return slotAllocationStrategy;
    }

    public void setSlotAllocationStrategy(SlotAllocationStrategy slotAllocationStrategy) {
        this.slotAllocationStrategy = slotAllocationStrategy;
    }

    public VehicleType getAllowedvehicletype() {
        return allowedvehicletype;
    }

    public void setAllowedvehicletype(VehicleType allowedvehicletype) {
        this.allowedvehicletype = allowedvehicletype;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    private BillCalculationStrategy feeCalculationStrategy;
    private SlotAllocationStrategy slotAllocationStrategy;
    private VehicleType allowedvehicletype;
    private ParkingLotStatus parkingLotStatus;
}
