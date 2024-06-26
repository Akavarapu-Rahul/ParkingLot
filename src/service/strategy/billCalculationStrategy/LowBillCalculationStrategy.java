package service.strategy.billCalculationStrategy;

import models.Ticket;
import models.constants.VehicleType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LowBillCalculationStrategy implements BillCalculationStrategy{

    private static final int PER_HOUR_CHARGE_2_WHEELER=50;
    private static final int PER_HOUR_CHARGE_4_WHEELER=100;

    private static final double INCREMENT_FACTOR=0.1;

    @Override
    public double calculateBillAmount(Ticket ticket, LocalDateTime exitTime) {
        LocalDateTime entryTime =ticket.getEntryTime();
        long totalHours= ChronoUnit.HOURS.between(exitTime,entryTime);
        int costPerHour=(ticket.getVehicle().getVehicleType().equals(VehicleType.CAR))?
                            PER_HOUR_CHARGE_4_WHEELER:
                            PER_HOUR_CHARGE_2_WHEELER;

        double baseCost=costPerHour*totalHours;
        return baseCost+(baseCost*(INCREMENT_FACTOR*(totalHours-1)));
    }

    /*
        1st hour -> 50
        2nd hour -> 50*2=> 100 + 100*(0.1*2-1) =>10=> 110
        3rd hour -> 50*3=> 150 + 150*(0.1*3-1) =>30=> 180

        formula=base cost => fixedCost * N
                totalCost => baseCost + baseCost * [increamentfactor *[N-1]]
     */
}
