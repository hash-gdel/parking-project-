package parking.refactored;
public class TruckTariff implements Tariff {
    public String type(){return "TRUCK";}
    public double fee(int hours){return 20+hours*10.0;}
}
