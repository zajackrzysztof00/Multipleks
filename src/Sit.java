import java.util.ArrayList;
import java.util.Date;

public class Sit {
    private String name;
    private int number;
    private boolean occupied;

    public Sit(String name, int number) {
        this.name = name;
        this.number = number;
        this.occupied = false;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getNumber() {return number;}

    public void setNumber(int number) {this.number = number;}

    public boolean isOccupied() {return occupied;}

    public void setOccupied(boolean occupied) {this.occupied = occupied;}
}
