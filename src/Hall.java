import java.util.ArrayList;

public class Hall {
    private String name;
    private char prefix;
    private int capacity;

    public Hall(String name, char prefix, int capacity) {
        this.name = name;
        this.prefix = prefix;
        this.capacity = capacity;
    }

    public String toString() {return name;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public char getPrefix() {
        return prefix;
    }

    public void setPrefix(char prefix) {
        this.prefix = prefix;
    }
}
