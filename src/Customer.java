import java.util.ArrayList;

public class Customer {
    private String name;
    private String email;
    private String phone;
    private ArrayList<Ticket> tickets;

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.tickets = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    public void checkTickets(){
        System.out.print("You have following tickets:\n");
        for(Ticket ticket: tickets){
            System.out.print(">" + ticket.toString() + "\n");
        }
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public ArrayList<Ticket> getTickets() {return tickets;}

    public void setTickets(ArrayList<Ticket> tickets) {this.tickets = tickets;}
}
