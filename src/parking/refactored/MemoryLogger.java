package parking.refactored;
import java.util.ArrayList;
import java.util.List;
public class MemoryLogger implements ParkingLogger {
    private final List<String> lines=new ArrayList<>();
    public void log(String line){lines.add(line);}
    public List<String> getLines(){return lines;}
}
