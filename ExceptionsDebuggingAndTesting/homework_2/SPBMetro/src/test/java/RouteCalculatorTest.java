import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;
    List<Station> connections = new ArrayList<>();
    List<Station> connectionsTwo = new ArrayList<>();
    StationIndex stationIndex = new StationIndex();
    RouteCalculator routeCalculator;
    @Override
    protected void setUp() throws Exception {

        route = new ArrayList<>();

        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");

        Station station1_1 = new Station("Апельсиновая", line1);
        Station station1_2 = new Station("Авокадная", line1);
        Station station1_3 = new Station("Арбузная", line1);
        Station station2_1 = new Station("Брусничная", line2);
        Station station2_2 = new Station("Барбарисовая", line2);
        Station station2_3 = new Station("Банановая", line2);
        Station station2_4 = new Station("Бергамотовая", line2);
        Station station3_1 = new Station("Вишнёвая", line3);
        Station station3_2 = new Station("Ванильная", line3);
        Station station3_3 = new Station("Виноградная", line3);

        line1.addStation(station1_1);
        line1.addStation(station1_2);
        line1.addStation(station1_3);
        line1.addStation(station2_1);
        line1.addStation(station2_2);
        line1.addStation(station2_3);
        line1.addStation(station2_4);
        line1.addStation(station3_1);
        line1.addStation(station3_2);
        line1.addStation(station3_3);

        connections.add(station1_2);
        connections.add(station2_2);
        connectionsTwo.add(station3_2);
        connectionsTwo.add(station2_3);


        route.add(station1_1);
        route.add(station1_2);
        route.add(station1_3);
        route.add(station2_1);
        route.add(station2_2);
        route.add(station2_3);
        route.add(station2_4);
        route.add(station3_1);
        route.add(station3_2);
        route.add(station3_3);

        stationIndex.addStation(station1_1);
        stationIndex.addStation(station1_2);
        stationIndex.addStation(station1_3);
        stationIndex.addStation(station2_1);
        stationIndex.addStation(station2_2);
        stationIndex.addStation(station2_3);
        stationIndex.addStation(station2_4);
        stationIndex.addStation(station3_1);
        stationIndex.addStation(station3_2);
        stationIndex.addStation(station3_3);
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        stationIndex.addConnection(connections);
        stationIndex.addConnection(connectionsTwo);

        routeCalculator = new RouteCalculator(stationIndex);
    }

    public void testGetShortestRoute() {
        List<Station> actual = routeCalculator.getShortestRoute(route.get(0), route.get(2));
        List<Station> expected = List.of(route.get(0), route.get(1), route.get(2));
        assertEquals(expected, actual);
    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 24.5;
        assertEquals(expected, actual);
    }

    public void testGetRouteOnTheLine() {
        List<Station> actual = routeCalculator.getShortestRoute(route.get(0), route.get(2));
        List<Station> expected = List.of(route.get(0), route.get(1), route.get(2));
        assertEquals(expected, actual);
    }


    public void testGetRouteWithOneConnection() {
        List<Station> actual = routeCalculator.getShortestRoute(route.get(0), route.get(2));
        List<Station> expected = List.of(route.get(0), route.get(1), route.get(2));
        assertEquals(expected, actual);
    }

    public void testGetRouteViaConnectedLine() {
        List<Station> actual = routeCalculator.getShortestRoute(route.get(0), route.get(2));
        List<Station> expected = List.of(route.get(0), route.get(1), route.get(2));
        assertEquals(expected, actual);
    }

    public void testGetRouteWithTwoConnections() {
        List<Station> actual = routeCalculator.getShortestRoute(route.get(7), route.get(0));
        List<Station> expected = List.of(route.get(7), route.get(8), route.get(5), route.get(4),
                route.get(1), route.get(0));
        assertEquals(expected, actual);
    }
    @Override
    protected void tearDown() throws Exception {
    }
}
