package parkinglot.services.slotallocationstrategy;

import parkinglot.models.Gate;
import parkinglot.models.ParkingLot;
import parkinglot.models.ParkingSlot;
import parkinglot.models.constants.VehicleType;

public interface SlotAllocationStrategy {
    ParkingSlot findParkingSlot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate);
}
