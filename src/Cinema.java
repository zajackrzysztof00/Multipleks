import java.time.LocalDate;
import java.util.ArrayList;

public class Cinema {
    private String name;
    private String address;
    private ArrayList<Hall> halls;
    private ArrayList<Screening> screenings;

    private ScreeningDefault defaultScreening;
    private ScreeningVIP vipScreening;
    private Screening3D screening3D;

    public Cinema(String name, String address) {
        this.name = name;
        this.address = address;
        this.halls = new ArrayList<>();
        this.screenings = new ArrayList<>();
        this.defaultScreening = new ScreeningDefault();
        this.vipScreening = new ScreeningVIP();
        this.screening3D = new Screening3D();
    }

    public void printProgramme(){
        System.out.print(this.name+" with address "+this.address+" cinema programme:\n");
        for(Screening screening:this.screenings){
            if (screening.getDate().isAfter(LocalDate.now()) && screening.getDate().isBefore(LocalDate.now().plusDays(7))) {
                System.out.print("In Hall\t"+screening.getHall().toString()+"\t"+screening.ToString()+"\n");
            }
        }
        System.out.print("End of programme\n");
    }

    public Movie findMovie(String name){
        for (Screening screening: screenings){
            Movie movie = screening.getMovie();
            if (movie.getName().equals(name)){
                return movie;
            }
        }
        return null;
    }

    public void buyTicket(Screening screening, Sit sit){
        boolean isAvailable = screening.reservePlaceBySit(sit);
        if (!isAvailable){
            return;
        }
        Customer guest = new Customer("Guest", "none", "none");
        Ticket ticket = new Ticket(sit,screening,guest,this);
        guest.addTicket(ticket);
    }

    public void customerBuyTicket(Screening screening, Sit sit, Customer customer){
        boolean isAvailable = screening.reservePlaceBySit(sit);
        if (!isAvailable){
            return;
        }
        Ticket ticket = new Ticket(sit,screening,customer,this);
        customer.addTicket(ticket);
    }

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

    public ArrayList<Hall> getHalls() {
        return halls;
    }

    public void setHalls(ArrayList<Hall> halls) {
        this.halls = halls;
    }

    public ArrayList<Screening> getScreenings() {
        return screenings;
    }

    public void setScreenings(ArrayList<Screening> screenings) {
        this.screenings = screenings;
    }

    public ScreeningDefault getDefaultScreening() {
        return defaultScreening;
    }

    public void setDefaultScreening(ScreeningDefault defaultScreening) {
        this.defaultScreening = defaultScreening;
    }

    public ScreeningVIP getVipScreening() {
        return vipScreening;
    }

    public void setVipScreening(ScreeningVIP vipScreening) {
        this.vipScreening = vipScreening;
    }

    public Screening3D getScreening3D() {
        return screening3D;
    }

    public void setScreening3D(Screening3D screening3D) {
        this.screening3D = screening3D;
    }

    public void addScreening(Screening screening) {
        this.screenings.add(screening);
    }

    public void addHall(Hall hall) {
        this.halls.add(hall);
    }
}
