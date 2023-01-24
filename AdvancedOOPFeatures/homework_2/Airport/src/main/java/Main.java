import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Calendar.HOUR;

public class Main {
    public static void main(String[] args) {

        Airport airport = Airport.getInstance();
        List<Flight> flightList = findPlanesLeavingInTheNextTwoHours(airport);
        flightList.forEach(System.out::println);
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        return airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                .filter(flight -> flight.getDate().getTime() >= System.currentTimeMillis()
                && flight.getDate().getTime() <= System.currentTimeMillis() + 7_200_000)
                .collect(Collectors.toList());
    }

}