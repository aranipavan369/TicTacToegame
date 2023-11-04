package parkinglot.services.slotallocationstrategy;

import parkinglot.exceptions.NoParkingSlotException;
import parkinglot.models.Gate;
import parkinglot.models.ParkingLot;
import parkinglot.models.ParkingSlot;
import parkinglot.models.constants.ParkingSlotStatus;
import parkinglot.models.constants.VehicleType;

public class NearestSlotAllocationStrategy implements SlotAllocationStrategy{

    @Override
    public ParkingSlot findParkingSlot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate) {
        int floor=entryGate.getFloorNumber();
        ParkingSlot slot=getSlot(floor,parkingLot,vehicleType);
        if(slot!=null) return slot;
        int i=floor-1;
        int j=floor+1;
        while(i>=0 || j<parkingLot.getParkingFloors().size())
        {
            if(i>=0)
            {
                ParkingSlot slot1=getSlot(i,parkingLot,vehicleType);
                if(slot1!=null) return slot1;
            }

            if(j<parkingLot.getParkingFloors().size()) {
                ParkingSlot slot2 = getSlot(j, parkingLot, vehicleType);
                if (slot2 != null) return slot2;
            }
        }
        throw new NoParkingSlotException("No parking slot avialable in this lot ");

    }
    private ParkingSlot getSlot(int floor,ParkingLot parkingLot,VehicleType vehicleType)
    {
        for(ParkingSlot slot:parkingLot.getParkingFloors().get(floor).getParkingSlots())
        {
            if(slot.getVehicleType().equals(vehicleType) && slot.getParkingSlotStatus().equals(ParkingSlotStatus.EMPTY))
                return slot;
        }
        return null;
    }
}
