package parkinglot.services;

import parkinglot.exceptions.GateNotFoundException;
import parkinglot.exceptions.ParkingLotNotFoundException;
import parkinglot.models.*;
import parkinglot.repository.GateRepository;
import parkinglot.repository.ParkingLotRepository;
import parkinglot.repository.TicketRepository;
import parkinglot.services.slotallocationstrategy.SlotAllocationStrategyFactory;
import parkinglot.services.slotallocationstrategy.SlotAllocationStrategyType;

import java.time.LocalDateTime;

public class TicketServiceImpl implements TicketService {

    private ParkingLotRepository parkingLotRepository;
    private GateRepository gateRepository;
    private TicketRepository ticketRepository;

    public TicketServiceImpl(ParkingLotRepository parkingLotRepository, GateRepository gateRepository, TicketRepository ticketRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.gateRepository = gateRepository;
        this.ticketRepository = ticketRepository;
    }
    @Override
    public Ticket createTicket(Vehicle vehicle, int parkingLotId, int gateId, LocalDateTime entryTime) throws ParkingLotNotFoundException, GateNotFoundException {
        ParkingLot parkingLot=parkingLotRepository.get(parkingLotId);
        Gate entryGate=gateRepository.get(gateId);
        ParkingSlot parkingSlot= SlotAllocationStrategyFactory.getSlotAllocationStrategy(SlotAllocationStrategyType.NEAREST)
                .findParkingSlot(vehicle.getVehicleType(),parkingLot,entryGate);
        Ticket ticket=new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(entryTime);
        ticket.setParkingSlot(parkingSlot);
        return ticketRepository.put(ticket);
    }
}
