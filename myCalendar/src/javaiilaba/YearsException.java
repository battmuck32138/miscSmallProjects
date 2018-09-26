/*
Mathew Buck
Java II Lab A
 */
package javaiilaba;

public class YearsException extends Exception {

        //default exception
        public YearsException() {
            System.out.println("Years exception thrown.");
        }
        
        //customize message from throw
        public YearsException(String message) {
            System.out.println(message);
        }
    }