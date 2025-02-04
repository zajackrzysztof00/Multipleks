public class Ticket {
    private Sit sit;
    private Screening screening;
    private Customer customer;
    private Cinema cinema;

    public Ticket(Sit sit, Screening screening, Customer customer, Cinema cinema) {
        this.sit = sit;
        this.screening = screening;
        this.customer = customer;
        this.cinema = cinema;
    }

    public String toString() {
        return "Ticket{" +
                "cinema=" + cinema.getName() +
                ", sit=" + sit.getName() +
                ", screening=" + screening.ToString() +
                '}';
    }

    public Sit getSit() {
        return sit;
    }

    public void setSit(Sit sit) {
        this.sit = sit;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Cinema getCinema() {return cinema;}

    public void setCinema(Cinema cinema) {this.cinema = cinema;}
}
