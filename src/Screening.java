import java.time.LocalDate;
import java.util.ArrayList;

public class Screening {
    private Movie movie;
    private Hall hall;
    private LocalDate date;
    private ArrayList<Sit> sits;
    private ScreeningType type;

    public Screening(Movie movie, Cinema cinema, LocalDate date, ScreeningType type) {
        this.movie = movie;
        this.date = date;
        this.hall = cinema.getHalls().get(0);
        this.sits = new ArrayList<>();
        for (int i = 1; i <= hall.getCapacity(); i++){
            Sit sit = new Sit(hall.getPrefix()+String.valueOf(i),i);
            sits.add(sit);
        }
        if (cinema.getScreening3D().getClass().equals(type.getClass())){
            this.type = cinema.getScreening3D();
        }
        if (cinema.getVipScreening().getClass().equals(type.getClass())){
            this.type = cinema.getVipScreening();
        }
        if (cinema.getDefaultScreening().getClass().equals(type.getClass())){
            this.type = cinema.getDefaultScreening();
        }
    }

    public void reservePlaces (ArrayList<String> sitNames) {
        for (String name:sitNames){
            Boolean isAvailable = false;
            for (Sit sit:sits){
                String sitName = sit.getName();
                if (sit.isOccupied()==false && name.equals(sitName)) {
                    sit.setOccupied(true);
                    isAvailable = true;
                    System.out.print("Sit name "+name+" reserved\n");
                    break;
                }
            }
            if (isAvailable==false){
                System.out.print("Sit name "+name+" not available\n");
            }
        }
    }

    public boolean reservePlaceBySit (Sit sit) {
        String name = sit.getName();
        Boolean isAvailable = false;
        for (Sit s:sits){
            if (s.isOccupied()==false && s.equals(sit)){
                s.setOccupied(true);
                isAvailable = true;
                System.out.print("Sit name "+name+" reserved\n");
                return isAvailable;
            }
        }
        if (isAvailable==false){
            System.out.print("Sit name "+name+" not available\n");
        }
        return isAvailable;
    }

    public void reservePlacesBySits (ArrayList<Sit> sitsToReserve) {
        for (Sit sitToR: sitsToReserve){
            String name = sitToR.getName();
            for (Sit sit:sits){
                if (sit.isOccupied()==false && name.equals(sit.getName())){
                    sit.setOccupied(true);
                }
            }
        }
    }

    public String ToString() {
        return "Screening{" +
                "movie=" + movie.toString() +
                ", hall=" + hall.toString() +
                ", price=" + type.getPrice() +
                ", date='" + date + '\'' +
                '}';
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public ArrayList<Sit> getSits() {
        return sits;
    }

    public void setSits(ArrayList<Sit> sits) {
        this.sits = sits;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ScreeningType getType() {
        return type;
    }

    public void setType(ScreeningType type) {
        this.type = type;
    }
}
