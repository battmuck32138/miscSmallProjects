/*
Mathew Buck
Java II Lab A
 */
package javaiilaba;

public class MonthsException extends Exception {

        //default exception
        public MonthsException() {
            System.out.println("Months exception thrown.");
        }
        
        //customize message from throw
        public MonthsException(String message) {
            System.out.println(message);
        }
    }