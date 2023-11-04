package parkinglot.repository;

import parkinglot.exceptions.GateNotFoundException;
import parkinglot.exceptions.ParkingFloorNotFoundException;
import parkinglot.models.Gate;
import parkinglot.models.ParkingFloor;

import java.util.HashMap;

public class ParkingFloorRepository {
    private HashMap<Integer, ParkingFloor> parkingFloorMap;
    public ParkingFloorRepository()
    {
        this.parkingFloorMap=new HashMap<>();
    }
    public ParkingFloor get(int parkingfloorId) throws ParkingFloorNotFoundException {
        ParkingFloor parkingFloor = parkingFloorMap.get(parkingfloorId);
        if(parkingFloor== null){
            throw new ParkingFloorNotFoundException("ParkingFloor not found for Id : " + parkingfloorId);
        }
        return parkingFloor;
    }

    public ParkingFloor put(ParkingFloor parkingFloor)
    {
        parkingFloorMap.put(parkingFloor.getId(),parkingFloor);
        return parkingFloor;
    }
}
