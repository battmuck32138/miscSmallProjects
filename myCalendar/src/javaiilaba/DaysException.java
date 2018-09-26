/*
Mathew Buck
Java II Lab A
 */
package javaiilaba;

public class DaysException extends Exception {

        //default exception
        public DaysException() {
            System.out.println("Days exception thrown.");
        }
        
        //customize message from throw
        public DaysException(String message) {
            System.out.println(message);
        }
    }