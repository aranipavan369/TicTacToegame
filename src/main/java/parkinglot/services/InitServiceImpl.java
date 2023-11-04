package parkinglot.services;

import parkinglot.models.Gate;
import parkinglot.models.ParkingFloor;
import parkinglot.models.ParkingLot;
import parkinglot.models.ParkingSlot;
import parkinglot.models.constants.*;
import parkinglot.repository.GateRepository;
import parkinglot.repository.ParkingFloorRepository;
import parkinglot.repository.ParkingLotRepository;
import parkinglot.repository.ParkingSlotRepository;
import parkinglot.services.feecalculationstrategy.BillCalculationStrategyFactory;
import parkinglot.services.feecalculationstrategy.BillCalculationStrategyType;
import parkinglot.services.slotallocationstrategy.SlotAllocationStrategyFactory;
import parkinglot.services.slotallocationstrategy.SlotAllocationStrategyType;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitServiceImpl implements InitService{

    private ParkingSlotRepository parkingSlotRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingLotRepository parkingLotRepository;
    private GateRepository gateRepository;

    public InitServiceImpl(ParkingSlotRepository parkingSlotRepository, ParkingFloorRepository parkingFloorRepository, ParkingLotRepository parkingLotRepository, GateRepository gateRepository) {
        this.parkingSlotRepository = parkingSlotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.gateRepository = gateRepository;
    }
    @Override
    public void init() {
        ParkingLot parkingLot=new ParkingLot();
        parkingLot.setId(1);
        parkingLot.setName("Parking Lot 1");
        parkingLot.setAddress("Kurnool,Andhra Pradesh");
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setSupportedVehicleTypes(new ArrayList<>(Arrays.asList(VehicleType.CAR,VehicleType.BIKE)));
        parkingLot.setFeeCalculationStrategy(BillCalculationStrategyFactory.
                getCalculationStrategy(BillCalculationStrategyType.LOWBILL));
        parkingLot.setSlotAllocationStrategy(SlotAllocationStrategyFactory.
                getSlotAllocationStrategy(SlotAllocationStrategyType.NEAREST));
        List<ParkingFloor> parkingFloors=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            ParkingFloor floor = new ParkingFloor();
            floor.setId(i);
            floor.setFloorNumber(i);
            List<ParkingSlot> parkingSlots = new ArrayList<>();
            for (int j = 1; j <= 10; j++) {
                VehicleType supportedVehicleType = j % 2 != 0 ?
                        VehicleType.BIKE : VehicleType.CAR;
                ParkingSlot parkingSlot = new ParkingSlot(i * 100 + j, i * 100 + j, supportedVehicleType);
                parkingSlots.add(parkingSlot);
                parkingSlotRepository.put(parkingSlot);
            }
            floor.setParkingSlots(parkingSlots);
            floor.setParkingFloorStatus(ParkingFloorStatus.AVAILABLE);

            Gate entryGate = new Gate();
            entryGate.setId(i * 10 + 1);
            entryGate.setGateNumber(i * 10 + 1);
            entryGate.setGateStatus(GateStatus.OPENED);
            entryGate.setGateType(GateType.ENTRY);
            entryGate.setOperator("Mohan");
            entryGate.setParkingLotId(1);
            entryGate.setFloorNumber(i);
            gateRepository.put(entryGate);

            Gate exitGate = new Gate();
            exitGate.setId(i * 10 + 2);
            exitGate.setGateNumber(i * 10 + 2);
            exitGate.setGateStatus(GateStatus.OPENED);
            exitGate.setGateType(GateType.EXIT);
            exitGate.setOperator("Ram");
            exitGate.setParkingLotId(1);
            entryGate.setFloorNumber(i);
            gateRepository.put(exitGate);

            List<Gate> gates = new ArrayList<>(Arrays.asList(entryGate,exitGate));
            floor.setGates(gates);
            parkingFloorRepository.put(floor);
            parkingFloors.add(floor);

        }
        parkingLot.setParkingFloors(parkingFloors);
        parkingLotRepository.put(parkingLot);
    }
}
