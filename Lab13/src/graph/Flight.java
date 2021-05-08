package graph;

/**
 * A direct Flight has an origin airport and a destination Airport
 * @author Kyle Evangelisto
 */
public class Flight {
    Airport origin, destination;

    public Flight (Airport origin, Airport destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public Airport getDestination() {
        return destination;
    }

    public Airport getOrigin() {
        return origin;
    }

    public String toString() {
        return "(" + origin + " -> " + destination + ")";
    }
}
