package queueDriver;

/**
 * @author Kyle Evangelisto
 */
public class Airplane implements Comparable {

    //keep these package scope
    int flight, arrivalTime, fuelLevel;  // gallons of jet fuel remaining

    //given constructor
    public Airplane (int arrival, int fuel, int flight)   {
        arrivalTime = arrival;
        fuelLevel = fuel;
        this.flight = flight;
        System.out.println (this + " has arrived at time " + arrival);
    }

    @Override
    public int compareTo(Object obj) {
        return 0;   //stub
    }

    @Override
    public String toString() {
        return "Flight: " + getFlight() + " has " + getFuelLevel() + " gallons left and ";
    }

    public int getFlight() {
        return flight;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }
}
