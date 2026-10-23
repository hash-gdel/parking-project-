package parking.refactored;
import java.io.IOException;
public class ParkingServiceTest {
    public static void main(String[] args) throws IOException {
        MemoryLogger logger=new MemoryLogger();
        ParkingService service=new ParkingService(logger,new ReceiptFormatter());
        Vehicle car=new Vehicle("12345-A-6",new CarTariff());
        Vehicle bike=new Vehicle("67890-B-1",new MotorbikeTariff());
        Vehicle truck=new Vehicle("24680-D-8",new TruckTariff());
        if(service.fee(car,3)!=15.0)throw new AssertionError("car");
        if(service.fee(bike,2)!=4.0)throw new AssertionError("bike");
        if(service.fee(truck,4)!=60.0)throw new AssertionError("truck");
        RefundablePayment card=new CardPayment("4242");
        PaymentMethod cash=new CashPayment();
        service.checkout(car,3,card);
        service.checkout(bike,2,cash);
        service.checkout(truck,4,card);
        service.cancelAtDesk(bike,2);
        service.cancel(truck,4,card);
        if(service.getTotal()!=15.0)throw new AssertionError("total");
        if(!service.dailyReport().contains("Total: 15.0 MAD"))throw new AssertionError("report");
        if(logger.getLines().size()!=3)throw new AssertionError("receipts");
        System.out.println("All tests passed");
    }
}
