package models;

import models.constants.ParkingLotStatus;
import models.constants.VehicleType;
import service.strategy.billCalculationStrategy.BillCalculationStrategy;
import service.strategy.slotAllocationStrategy.SlotAllocationStrategy;

import java.util.List;

public class ParkingLot extends BaseModel {
    private String  name;
    private String address;
    private List<ParkingFloor> parkingFloors;
    private ParkingLotStatus parkingLotStatus;
    private List<VehicleType> supportedVehiclesTypes;
    private SlotAllocationStrategy slotAllocationStrategy;
    private BillCalculationStrategy billCalculationStrategy;

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

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public List<VehicleType> getSupportedVehiclesTypes() {
        return supportedVehiclesTypes;
    }

    public void setSupportedVehiclesTypes(List<VehicleType> supportedVehiclesTypes) {
        this.supportedVehiclesTypes = supportedVehiclesTypes;
    }

    public SlotAllocationStrategy getSlotAllocationStrategy() {
        return slotAllocationStrategy;
    }

    public void setSlotAllocationStrategy(SlotAllocationStrategy slotAllocationStrategy) {
        this.slotAllocationStrategy = slotAllocationStrategy;
    }

    public BillCalculationStrategy getBillCalculationStrategy() {
        return billCalculationStrategy;
    }

    public void setBillCalculationStrategy(BillCalculationStrategy billCalculationStrategy) {
        this.billCalculationStrategy = billCalculationStrategy;
    }
}
