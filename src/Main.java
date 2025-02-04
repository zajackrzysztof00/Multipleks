import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Multiple cinemas creation

        Cinema cinemakrakow = new Cinema("Cinema Krakow", "ul. Krakowska 1");
        Cinema cinemaWarsaw = new Cinema("Cinema Warsaw", "ul. Warszawska 1");

        // Movies creation

        Movie james = new Movie("James Bond", 60);
        Movie madagaskar = new Movie("Madagaskar", 90);
        Movie indiana = new Movie("Indiana Jones", 120);

        // Adding halls to cinemas

        cinemakrakow.addHall(new Hall("Jungle", 'J', 32));
        cinemakrakow.addHall(new Hall("Beach", 'B', 24));

        cinemaWarsaw.addHall(new Hall("Tawern",'T',16));
        cinemaWarsaw.addHall(new Hall("Haven",'H',24));

        // Setting screenings types for krakow cinema

        ScreeningVIP vip1 = new ScreeningVIP();
        vip1.setPrice(20);

        Screening3D screening3D = new Screening3D();
        screening3D.setPrice(20);

        cinemakrakow.setVipScreening(vip1);
        cinemakrakow.setScreening3D(screening3D);

        // Adding screenings to cinema

        cinemakrakow.addScreening(new Screening(james, cinemakrakow, LocalDate.of(2025, 2, 5), new ScreeningDefault()));
        cinemakrakow.addScreening(new Screening(madagaskar, cinemakrakow, LocalDate.of(2025, 2, 10), new ScreeningVIP()));
        cinemakrakow.addScreening(new Screening(indiana, cinemakrakow, LocalDate.of(2025, 2, 15), new Screening3D()));

        cinemaWarsaw.addScreening((new Screening(madagaskar, cinemaWarsaw, LocalDate.of(2025, 2, 10), new ScreeningDefault())));
        cinemaWarsaw.addScreening((new Screening(indiana, cinemaWarsaw, LocalDate.of(2025, 2, 15), new ScreeningVIP())));

        // Cinema program print

        cinemakrakow.printProgramme();
        cinemaWarsaw.printProgramme();

        // Places reservation

        ArrayList<String> places = new ArrayList<>();
        places.add("J1");
        places.add("J2");
        places.add("J3");
        cinemakrakow.getScreenings().get(1).reservePlaces(places);

        // Buying ticket without reservation

        cinemakrakow.buyTicket(cinemakrakow.getScreenings().get(0), cinemakrakow.getScreenings().get(0).getSits().get(0));
        cinemaWarsaw.buyTicket(cinemaWarsaw.getScreenings().get(0), cinemaWarsaw.getScreenings().get(0).getSits().get(0));

        // Customer creation

        Customer olek = new Customer("Olek","olek@onet.pl","182302193");

        // Buying tickets as customer

        cinemakrakow.customerBuyTicket(cinemakrakow.getScreenings().get(0), cinemakrakow.getScreenings().get(0).getSits().get(1), olek);
        cinemakrakow.customerBuyTicket(cinemakrakow.getScreenings().get(0), cinemakrakow.getScreenings().get(0).getSits().get(2), olek);

        cinemaWarsaw.customerBuyTicket(cinemaWarsaw.getScreenings().get(0), cinemaWarsaw.getScreenings().get(0).getSits().get(1), olek);

        // Customer tickets check

        olek.checkTickets();
    }
}