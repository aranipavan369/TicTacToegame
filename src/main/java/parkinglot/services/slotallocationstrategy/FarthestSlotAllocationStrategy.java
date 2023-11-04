package parkinglot.services.slotallocationstrategy;

import parkinglot.models.Gate;
import parkinglot.models.ParkingLot;
import parkinglot.models.ParkingSlot;
import parkinglot.models.constants.VehicleType;

public class FarthestSlotAllocationStrategy implements SlotAllocationStrategy{
    @Override
    public ParkingSlot findParkingSlot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate) {
        return null;
    }
}
