/*
Mathew Buck
Java II Lab A
 */
package javaiilaba;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;

public class JavaIILabA {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String date = "1/29/2016";//leap year
        int month = 1;
        int day = 1;
        int year = 1000;
        boolean valid = true;
        boolean valid2 = true;
        CalendarDay c1 = null;
        CalendarDay c2 = null;
        CalendarDay[] calArr = null;

        //test code////////////////////////////////////////////////
        //promts user to enter dates until 
        //a valid Calendar day object is created
        do {
            System.out.println("Enter a date in the"
                    + " form month/day/year (String). ");
            date = keyboard.nextLine();

            try {
                c1 = new CalendarDay(date);
                valid = true;//flag should be the last thing in the try block
            } 
            catch (MonthsException e) {
                System.out.println("MonthsException was cought in main.");
                valid = false;
            } 
            catch (DaysException e) {
                System.out.println("DaysException was cought in main.");
                valid = false;
            } 
            catch (YearsException e) {
                System.out.println("YearsException was cought in main.");
                valid = false;
            }
            catch (Exception e) {
                System.out.println("Input mis-match occured.");
                keyboard.nextLine();
                valid = false;
            } 
        } while (!valid);
        System.out.println("First Object: " + c1);

        //promps user for dates until a second valid object is created
        do {
            System.out.println("Enter a second date in the "
                    + "form of 3 numbers (int): ");
             month = keyboard.nextInt();
            day = keyboard.nextInt();
            year = keyboard.nextInt();
            keyboard.nextLine();

            try {
                c2 = new CalendarDay(month, day, year);
                valid2 = true;//flag should be the last thing in the try block
            } 
            catch (MonthsException e) {
                System.out.println("MonthsException was cought in main.");
                valid2 = false;
            } 
            catch (DaysException e) {
                System.out.println("DaysException was cought in main.");
                valid2 = false;
            } 
            catch (YearsException e) {
                System.out.println("YearsException was cought in main.");
                valid2 = false;
            }
            catch (InputMismatchException e) {
                System.out.println("Input mis-match occured.");
                keyboard.nextLine();
                valid2 = false;
            }
        } while (!valid2);
        System.out.println("Second Object: " + c2);

        //test set month
        try {
            c1.setMonth(13, day, year);
        } 
        catch (MonthsException e) {
            System.out.println("MonthsException was cought in main.");
        } 
        catch (DaysException e) {
            System.out.println("DaysException was cought in main.");
        }
        System.out.println("Month was not changed: " + c1);

        //test set month
        try {
            c1.setMonth(2, day, year);
        } 
        catch (MonthsException e) {
            System.out.println("MonthsException was cought in main.");
        } 
        catch (DaysException e) {
            System.out.println("DaysException was cought in main.");
        }
        System.out.println("Month was changed: " + c1);

        //test set day
        try {
            c1.setDay(c1.getMonth(), 28, c1.getYear());
        } 
        catch (DaysException e) {
            System.out.println("DaysException was cought in main.");
            valid2 = false;
        }
        System.out.println("Day was changed: " + c1);

        //test set year
        try {
            c1.setYear(c1.getMonth(), c1.getDay(), 3001);
        }
        catch (YearsException e) {
            System.out.println("yearsException was cought in main.");
            valid2 = false;
        } 
        catch (DaysException e) {
            System.out.println("DaysException was cought in main.");
            valid2 = false;
        }
        System.out.println("Year was not changed: " + c1);
        //test set year
        try {
            c1.setYear(c1.getMonth(), c1.getDay(), 3000);
        } 
        catch (YearsException e) {
            System.out.println("YearsException was cought in main.");
        } 
        catch (DaysException e) {
            System.out.println("DaysException was cought in main.");
        }
        System.out.println("Year was changed: " + c1);

        CalendarDay copy = new CalendarDay(c1);
        System.out.println(copy);
        System.out.println(c1.compareTo(c2));
        System.out.println(c2.compareTo(c1));
        System.out.println(c1.compareTo(copy));
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(copy));
        System.out.println(c1.getMonth());
        System.out.println(c1.getDay());
        System.out.println(c1.getYear());
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(copy));

        //test array of CalendarDays
        try {
            calArr = c1.ArrOfRandomCalDays(8);
        } 
        catch (MonthsException e) {
            System.out.println("MonthsException was cought in main.");
        } 
        catch (DaysException e) {
            System.out.println("DaysException was cought in main.");
        } 
        catch (YearsException e) {
            System.out.println("YearsException was cought in main.");
        }
        System.out.println(Arrays.toString(calArr));
        Arrays.sort(calArr);
        System.out.println(Arrays.toString(calArr));
    }
    
//end of main
}

//OUTPUT
/*

run:
Enter a date in the form month/day/year (String). 
13/1/1
Months exception was thrown.
MonthsException was cought in main.
Enter a date in the form month/day/year (String). 
1/29/2016
First Object: 01/29/2016
Enter a second date in the form of 3 numbers (int): 
1
1
1000
Second Object: 01/01/1000
Months exception was thrown.
MonthsException was cought in main.
Month was not changed: 01/29/2016
Month was changed: 02/29/2016
Day was changed: 02/28/2016
Year exception was thrown.
yearsException was cought in main.
Year was not changed: 02/28/2016
Year was changed: 02/28/3000
02/28/3000
-1
1
0
false
true
2
28
3000
false
true
[03/22/1892, 02/09/1315, 06/03/2269, 01/22/2042, 01/11/2073, 05/16/1011, 08/09/1944, 04/09/1037]
[06/03/2269, 01/11/2073, 01/22/2042, 08/09/1944, 03/22/1892, 02/09/1315, 04/09/1037, 05/16/1011]
BUILD SUCCESSFUL (total time: 50 seconds)


*/