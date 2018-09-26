/*
Mathew Buck
Java II Lab A
 */
package javaiilaba;

import java.util.Random;

public class CalendarDay implements Comparable<CalendarDay> {
    private int month = 1;
    private int day = 1;
    private int year = 1000;

    
    //default constructor
    public CalendarDay() {
        month = 1;
        day = 1;
        year = 1000;
    }

    //constructor takes a string in the form month/date/year 
    //as an argument
    public CalendarDay(String date) throws MonthsException,
            DaysException, YearsException {
        //splits string at / and loads the idividual pieces into an array
        String[] dateArr = date.split("/");
        month = Integer.parseInt(dateArr[0]);
        day = Integer.parseInt(dateArr[1]);
        year = Integer.parseInt(dateArr[2]);

        if (month < 1 || month > 12) {
            throw new MonthsException("Months exception was thrown.");
        }
        if (!validDay(month, day, year)) {
            throw new DaysException("Days exception was thrown.");
        }
        if (year < 1000 || year > 3000) {
            throw new YearsException("Year exception was thrown.");
        }
    }

    public CalendarDay(int month, int day, int year) throws MonthsException,
            DaysException, YearsException {
        this.month = month;
        this.day = day;
        this.year = year;

        if (month < 1 || month > 12) {
            throw new MonthsException("Months exception was thrown.");
        }
        if (!validDay(month, day, year)) {
            throw new DaysException("Days exception was thrown.");
        }
        if (year < 1000 || year > 3000) {
            throw new YearsException("Year exception was thrown"
                    + " from constructor.");
        }
    }

    //creates a shallow copy of the original object
    public CalendarDay(CalendarDay origObj) {
        month = origObj.month;
        day = origObj.day;
        year = origObj.year;
    }

    public int compareTo(CalendarDay otherCal) {
        if (equals(otherCal)) {
            return 0;
        } 
        else if (otherCal.year < year) {
            return -1;
        } 
        else if (otherCal.year == year && otherCal.month < month) {
            return -1;
        } 
        else if (otherCal.year == year && otherCal.month == month
                && otherCal.day < day) {
            return -1;
        } 
        else {
            return 1;
        }
    }

    public boolean equals(CalendarDay otherObject) {
        //1st check null
        if (otherObject == null) {
            return false;
        } //2nd check class
        else if (getClass() != otherObject.getClass()) {
            return false;
        } else {
            //3rd check cast of original object
            CalendarDay otherCal = (CalendarDay) otherObject;
        }
        //4th check that variables match
        return (month == otherObject.month && day == otherObject.day
                && year == otherObject.year);
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int month, int day, int year) throws MonthsException,
            DaysException {
        if (month < 1 || month > 12) {
            throw new MonthsException("Months exception was thrown.");
        }
        if (!validDay(month, day, year)) {
            throw new DaysException("Days exception was thrown.");
        }
        this.month = month;
    }

    public void setDay(int month, int day, int year) throws DaysException {
        if (!validDay(month, day, year)) {
            throw new DaysException("Days exception was thrown.");
        }
        this.day = day;
    }

    public void setYear(int month, int day, int year) throws YearsException, DaysException {
        if (year < 1000 || year > 3000) {
            throw new YearsException("Year exception was thrown.");
        }
        if (!validDay(month, day, year)) {
            throw new DaysException("Days exception was thrown.");
        }
        this.year = year;
    }

    public String toString() {
        String date = "";
        if (isContains(month, 1, 2, 3, 4, 5, 6, 7, 8, 9)) {
            date = date.concat("0");
        }
        date = date.concat(Integer.toString(month));
        date = date.concat("/");
        if (isContains(day, 1, 2, 3, 4, 5, 6, 7, 8, 9)) {
            date = date.concat("0");
        }
        date = date.concat(Integer.toString(day));
        date = date.concat("/");
        date = date.concat(Integer.toString(year));
        return date;
    }

    //helper method for cleaneing up a long list of "or" statements
    //checks for a match with the first argument
    private boolean isContains(int i, int... numbers) {
        // code to check if i is one of the numbers
        for (int n : numbers) {
            if (i == n) {
                return true;
            }
        }
        return false;
    }

    //checks to see if the day is valid
    private boolean validDay(int month, int day, int year) {

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day < 1 || day > 31) {
                    return false;
                }
                break;

            case 2:
                //leap year
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    if (day < 1 || day > 29) {
                        return false;
                    }
                } else if (day < 1 || day > 28) {
                    return false;
                }
                break;

            case 4:
            case 6:
            case 9:
                if (day < 1 || day > 30) {
                    return false;
                }
                break;
        }
        return true;
    }

    //returns a random numnber between a range
    public int randInt(int min, int max) {
        Random rand = new Random();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;
        
        return randomNum;
    }

//creates an array of random calendar days
    public CalendarDay[] ArrOfRandomCalDays(int size) throws MonthsException,
            DaysException, YearsException {
        CalendarDay[] calArr = new CalendarDay[size];
        int m = 1;
        int d = 1;
        int y = 1000;

        for (int i = 0; i < size; i++) {
            d = 33; // 
            while (!validDay(m, d, y)) {
                m = randInt(1, 12);
                d = randInt(1, 31);
                y = randInt(1000, 3000);
            }
            calArr[i] = new CalendarDay(m, d, y);
        }
        return calArr;
    }

//end of class
}
