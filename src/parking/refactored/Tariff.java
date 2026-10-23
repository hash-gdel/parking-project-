package parking.refactored;
public interface Tariff {
    String type();
    double fee(int hours);
}
