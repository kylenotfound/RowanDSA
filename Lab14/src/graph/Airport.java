package graph;

/**
 * An airport has a name and a hub, or just a name
 * @author Kyle Evangelisto
 */
public class Airport implements Comparable {
    private String name;

    //keep these flags package scope
    boolean visited = false;
    boolean hub = false;

    //Constructor for just a name
    public Airport (String name) {
        this.name = name;
    }

    //Constructor for name and hub
    public Airport (String name, boolean hub) {
        this.name = name;
        this.hub = hub;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Airport)) {
            return false;
        }
        Airport other = (Airport) obj;
        return name.equals(other.name);
    }

    //check if is hub or not
    public String toString() {
        if (!hub) {
            return getName();
        }
        return getName() + " (hub)";
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object obj) {
        Airport other = (Airport) obj;
        if (this.hub && !other.hub) {
            return 1;
        }
        if (other.hub && !this.hub) {
            return -1;
        }
        return 0;
    }

    public void removeHub() {
        hub = false;
    }

    public void setHub() {
        hub = true;
    }
}
