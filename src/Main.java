import controller.TicketController;
import controller.dto.TicketRequestDTO;
import controller.dto.TicketResponseDTO;
import exception.GateNotFoundException;
import exception.NoParkingSlotAvailableException;
import exception.ParkingLotNotFoundException;
import models.ParkingLot;
import models.constants.VehicleType;
import repository.*;
import service.InitService;
import service.InitServiceImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParkingLotNotFoundException, NoParkingSlotAvailableException, GateNotFoundException {
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository();
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository=new TicketRepository();

        InitService initService=new InitServiceImpl(parkingSlotRepository,parkingFloorRepository,parkingLotRepository,gateRepository);
        initService.init();

        TicketController ticketController=new TicketController(parkingLotRepository,gateRepository,ticketRepository);

        ParkingLot parkingLot=parkingLotRepository.get(1);

        TicketRequestDTO ticketRequestDTO=new TicketRequestDTO();
        ticketRequestDTO.setParkingLotId(1);
        ticketRequestDTO.setGateId(31);
        ticketRequestDTO.setName("Mercedez");
        ticketRequestDTO.setColor("Blue");
        ticketRequestDTO.setVehicleType(VehicleType.CAR);
        ticketRequestDTO.setNumber("1234");

        TicketResponseDTO ticketResponseDTO=ticketController.createTicket(ticketRequestDTO);
        System.out.println(ticketResponseDTO);


    }
}