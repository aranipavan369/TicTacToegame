package parkinglot;

import parkinglot.controllers.BillController;
import parkinglot.dto.BillResponseDTO;
import parkinglot.dto.TicketRequestDTO;
import parkinglot.dto.TicketResponseDTO;
import parkinglot.controllers.TicketController;
import parkinglot.exceptions.GateNotFoundException;
import parkinglot.exceptions.ParkingLotNotFoundException;
import parkinglot.exceptions.TicketNotFoundException;
import parkinglot.models.constants.VehicleType;
import parkinglot.repository.*;
import parkinglot.services.InitService;
import parkinglot.services.InitServiceImpl;

public class ParkingLotMain {
    public static void main(String[] args) throws ParkingLotNotFoundException, GateNotFoundException, TicketNotFoundException {
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository();
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();

        InitService initService = new InitServiceImpl(parkingSlotRepository, parkingFloorRepository, parkingLotRepository, gateRepository);
        initService.init();
        TicketController ticketController=new TicketController(parkingLotRepository,gateRepository,ticketRepository);
        TicketRequestDTO ticketRequestDTO=new TicketRequestDTO();
        ticketRequestDTO.setParkingLotId(1);
        ticketRequestDTO.setName("Ola");
        ticketRequestDTO.setColor("grey");
        ticketRequestDTO.setNumber("1234");
        ticketRequestDTO.setVehicleType(VehicleType.CAR);
        ticketRequestDTO.setGateId(31);
        TicketResponseDTO ticketResponseDTO=ticketController.creqteticket(ticketRequestDTO);
        System.out.println(ticketResponseDTO);

        BillController billController=new BillController(ticketRepository);
        BillResponseDTO billResponseDTO=billController.createBill(ticketRequestDTO);
        System.out.println("bill amount is : "+billResponseDTO.getAmouunt());
    }



}
