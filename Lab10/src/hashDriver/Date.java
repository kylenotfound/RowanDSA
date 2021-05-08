package hashDriver;

import java.util.Objects;

/**
 *
 * @author Kyle Evangelisto
 */
public class Date {

    private int day, month, year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean equals(Object obj) {
        if(!(obj instanceof Date)) {
            return false;
        }
        Date other = (Date) obj;
        return getDay() == other.getDay() &&
                getMonth() == other.getMonth() &&
                getYear() == other.getYear();
    }

    public String toString() {
        return getDay() + "/" + getMonth() + "/" + getYear();
    }

}
