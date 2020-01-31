package com.wintech.adt;

/**
 * Author: Prabu
 * Date: 3/24/12 6:52 PM
 *
 * An immutable data types for dates
 */
public class Date implements Comparable<Date> {
    private static final int[] DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private final int day;
    private final int month;
    private final int year;

    /**
     * Create a date object,  do bounds-checking to ensure object represents a valid date
     * @param day
     * @param month
     * @param year
     */
    public Date(int month, int day, int year) {
        if(!isValid(month, day, year)) throw new RuntimeException("Invalid date.");
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * create new data by parsing from string of the form mm/dd/yy
     * @param date
     */
    public Date(String date) {
        String[] tokens = date.split("/");
        if(tokens.length != 3) {
            throw new RuntimeException("Date parse error.");
        }
        this.day = Integer.parseInt(tokens[1]);
        this.month = Integer.parseInt(tokens[0]);
        this.year = Integer.parseInt(tokens[2]);
        if(!isValid(month, day, year)) throw new RuntimeException("Invalid date.");
    }
    
    public int month() { return month; }
    public int day() { return day; }
    public int year() { return year; }
    
    // Return the next date
    public Date next() {
        if(isValid(month, day+1, year)) return new Date(month, day+1, year);
        if(isValid(month+1, 1, year)) return new Date(month+1, 1, year);
        return new Date(1, 1, year+1);
    }

    // Is this date before b
    public boolean isBefore(Date b) {
        return compareTo(b) < 0;        
    }

    // Is this date after date b
    public boolean isAfter(Date b) {
        return compareTo(b) > 0;
    }
    
    // Compare this date to that one
    @Override
    public int compareTo(Date that) {
        if(this.year() < that.year()) return -1;
        if(this.year() > that.year()) return +1;
        if(this.month() < that.month()) return -1;
        if(this.month() > that.month()) return +1;
        if(this.day() < that.day()) return -1;
        if(this.day() > that.day()) return +1;

        return 0;
    }

    // Return string representation of this date
    @Override
    public String toString() {
        return this.month() + "/" + this.day() + "/" + this.year();
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + month;
        hash = hash * 31 + day;
        hash = hash * 31 + year;
        return hash;
    }

    // Is this object is equal to x
    @Override
    public boolean equals(Object x) {
        if(this == x) return true;
        if(x == null) return false;
        if(this.getClass() != x.getClass()) return false;
        Date that = (Date) x;
        
        return (this.year == that.year) && (this.month == that.month) && (this.day == that.day);
    }

    /* Hold on now
    public int dayOfWeek() {
        final int BASE_DAY_OF_WEEK = 0; // Sunday
        final Date BASE_DATE = new Date(1, 1, 1980);
        
        Date first, second;
        if(BASE_DATE.isBefore(this)) {
            first = BASE_DATE;
            second = this;
        }
        else {
            first = this;
            second = BASE_DATE;
        }

        int totalDayCount = 0;
        int yearDiff = (second.year() - 1) - (first.year() + 1);
        if(yearDiff > 0) { // Year difference then, calculate days for each year
            totalDayCount += yearDiff * 365;
            totalDayCount += ((first.year()%4 + yearDiff) / 4); // leap year count
            totalDayCount -= ((first.year()%100 + yearDiff) / 100);
            totalDayCount += ((first.year()%400 + yearDiff) / 400);
            
            if(isLeapYear(first.year()) && first.month() <= 2)
                totalDayCount++;
        }
        totalDayCount += DAYS[first.month()] - 14;
        for(int i = first.month(); i <= second.month(); i++) {
            if(i == 2 && !isLeapYear(second.year())) { totalDayCount += 28; continue; }
            totalDayCount += DAYS[i];
        }
        if(first.day() < second.day()) {
            totalDayCount -=
        }
    }  */

    /**
     * Is the given date values valid.
     *
     * @param month
     * @param day
     * @param year
     * @return
     */
    public static boolean isValid(int month, int day, int year) {
        if(month <= 0 || month > 12) return false;
        if(day <= 0 || day > DAYS[month]) return false;
        if(month == 2 && day == 29 && !isLeapYear(year)) return false;
        return true;
    }

    /**
     * Is given year a leap year
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) {
        if(year%400 == 0) return true;
        if(year%100 == 0) return false;
        return year%4 == 0;
    }

    // Test client for Date
    public static void main(String[] args) {
        Date today = new Date(3, 25, 2012);

        for(int i = 0; i < 10; i++) {
            System.out.printf("Today + %d: %s\n", i, today);
            today = today.next();
        }

        System.out.println("today.isAfter(today): " + today.isAfter(today));
        System.out.println("today.next().isAfter(today): " + today.next().isAfter(today));
        System.out.println("today.isAfter(today.next()): " + today.isAfter(today.next()));
        System.out.println("today.isBefore(today): " + today.isBefore(today));
        System.out.println("today.next().isBefore(today): " + today.next().isBefore(today));
        System.out.println("today.isBefore(today.next()): " + today.isBefore(today.next()));
        
        System.out.println("isLeapYear(today): " + isLeapYear(today.year()));
        
        Date christmas = new Date(12, 25, 2012);
        for(int i = 0; i < 10; i++) {
            System.out.printf("Today + %d: %s\n", i, christmas);
            christmas = christmas.next();
        }
    }
}
