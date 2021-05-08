package graph;

import map.*;
import queue.*;
import java.io.*;
import java.util.Scanner;
import list.*;

/**
 * @author Kyle Evanglisto
 */
public class Airline {

    List<Flight> flights;
    static Map<String, Airport> map;

    public static void main(String args[]) {
        Airline airline = new Airline();
        airline.getFlights();
        System.out.println("Flights: " + airline.flights);
        System.out.println("Path from CVG to Paris");
        System.out.println(airline.path("CVG", "Paris"));
        System.out.println("Path from CVG to Paris with PHL hub");
        map.put("PHL", new Airport("PHL", true));
        System.out.println(airline.path("CVG", "Paris"));
    }

    private void getFlights() {
        try {
            map = new HashMap<String, Airport>();
            flights = new ArrayList<Flight>();
            File file = new File("flightsORL1.txt");
            Scanner scanner = new Scanner(file);
            String flight, origin, dest;
            Airport o, d;

            while(scanner.hasNextLine()) {
                flight = scanner.nextLine();
                origin = flight.split(" ")[0];
                dest = flight.split(" ")[1];
                if(map.containsKey(origin))
                    o = map.get(origin);
                else {
                    o = new Airport(origin);
                    map.put(origin, o);
                }
                if(map.containsKey(dest)) {
                    d = map.get(dest);
                }
                else {
                    d = new Airport(dest);
                    map.put(dest, d);
                }
                flights.add(new Flight(o, d));
            }
            scanner.close();
        }
        catch(FileNotFoundException fnfe) {
            System.err.println(fnfe);
        }
    }


    /**
     * @return a list of Airports from given origin to destination, or empty list if no path
     */
    private List<Airport> path(String origin, String dest){
        Airport o = map.get(origin);
        Airport d = map.get(dest);
        List<Airport> result = path(o,d);
        clearAirports();
        return result;
    }

    /**
     * @return a list of Airports from given origin to destination, or empty list if no path
     */
    private List<Airport> path(Airport origin, Airport dest){
        List<Airport> result = new ArrayList<>();
        origin.visited = true;
        if(origin.equals(dest)) {
            result.add(origin);
            return result;
        }
        Airport port;
        //airports that are hubs should have higher priority, hence usage of priority queue
        PriorityQueue<Airport> queue = getDirect(origin);
        for(int i = 0; i < queue.size(); i++) {
            if(queue.peek().hub) {
                port = queue.remove();
                result = path(port, dest);
                if(result.size() > 0) {
                    result.add(0, origin);
                    return result;
                }
            }
        }
        for(int i = 0; i < queue.size(); i++) {
            port = queue.remove();
            result = path(port, dest);
            if(result.size() > 0) {
                result.add(0, origin);
                return result;
            }
        }
        return result;
    }

    /**
     * @return a list of Airports which can be directly hit from given Airport,
     * from, and which have not been visited.
     */
    private PriorityQueue<Airport> getDirect(Airport from){
        PriorityQueue<Airport> result = new PriorityQueue<>();
        Iterator<Flight> iterator = flights.iterator();
        Flight flight;
        while(iterator.hasNext()) {
            flight = iterator.next();
            if(flight.origin.equals(from) && (!flight.destination.visited)) {
                result.add(flight.destination);
            }
        }
        return result;
    }

    /**
     * clear visited flags in all airports
     */
    private void clearAirports() {
        Flight flight;
        Iterator<Flight> iterator = flights.iterator();
        while(iterator.hasNext()) {
            flight = iterator.next();
            flight.origin.visited = false;
            flight.destination.visited = false;
        }
    }
}