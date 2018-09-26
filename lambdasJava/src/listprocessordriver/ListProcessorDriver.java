/*
Mathew Buck
Java II Lab B
 */
package listprocessordriver;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

//Test code for ListProcessor 
//Lambda Expression Demo. 
public class ListProcessorDriver {

    public static void main(String[] args) {

        ArrayList<LibraryItem> collection = new ArrayList<>();
        Book b1 = new Book("Java Complete", "Schildt");
        Book b2 = new Book("Secret Teachings of All Ages", "Manly Hall");
        Book b3 = new Book("New Atlantis", "Francis Bacon");
        DVD d1 = new DVD("A New Hope");
        DVD d2 = new DVD("Empire Strikes Back");
        DVD d3 = new DVD("Return of the Jedi");
        Magazine m1 = new Magazine("Discovery", "June 2017");
        Magazine m2 = new Magazine("Mad Magazine", "March 1978");
        Magazine m3 = new Magazine("Thrasher", "January 1982");
        Calendar overDue = new GregorianCalendar(2017, 2, 1);
        Calendar notOverDue = new GregorianCalendar(2020, 1, 1);

        b1.setDueDate(notOverDue);
        b2.setDueDate(overDue);
        b3.setDueDate(overDue);
        d1.setDueDate(notOverDue);
        d2.setDueDate(notOverDue);
        d3.setDueDate(overDue);
        collection.add(b1);
        collection.add(b2);
        collection.add(b3);
        collection.add(d1);
        collection.add(d2);
        collection.add(d3);
        collection.add(m1);
        collection.add(m2);
        collection.add(m3);

        //Lambda expression that prints a list. 
        Consumer con1 = (t) -> {
            if (t != null) {
                System.out.println(t);
            }
        };
        System.out.println("Print the list with lambda expression:");
        ListProcessor.forEach(collection, con1);
        System.out.println();

        System.out.println("Print only books with lambda expressions.");
        //Lambda expression to test if a Library item is a Book.
        Predicate pred1 = (t) -> {
            if (t.getClass().equals(b1.getClass())) {
                return true;
            } else {
                return false;
            }
        };
        List resultList = ListProcessor.filter(collection, pred1);
        ListProcessor.forEach(resultList, con1);
        System.out.println();

        System.out.println("Print LibraryItem descriprions with "
                + "lambda exprssions. ");
        //Lambda expression to print LibraryItem description.
        Consumer con2 = (t) -> {
            LibraryItem item = (LibraryItem) t;
            System.out.println(item.getDescription());
        };
        ListProcessor.forEach(collection, con2);
        System.out.println();

        System.out.println("Print the list of overdue Library items "
                + "(should be id#s 2, 3, & 6");
        //Lambda expression that returns a LibraryItem if it's overdue;
        Function f1 = (t) -> {
            LibraryItem item = (LibraryItem) t;
            if (item.isOverDue()) {
                return item;
            } else {
                return null;
            }
        };
        resultList = ListProcessor.map(collection, f1);
        ListProcessor.forEach(resultList, con1);
        System.out.println();

        System.out.println("Print the list of overdue Books using "
                + "lambda expressions (should be ids 2 & 3.");
        //Lambda expression that returns a Library Book if it's overdue;
        Function f2 = (t) -> {
            if (t.getClass().equals(b1.getClass())) {
                Book b = (Book) t;
                if (b.isOverDue()) {
                    return t;
                }
            }
            return null;
        };
        resultList = ListProcessor.map(collection, f2);
        ListProcessor.forEach(resultList, con1);
        System.out.println();

    }

}

/*
OUTPUT

run:
Print the list with lambda expression:
BookID:1 Title: Java Complete
BookID:2 Title: Secret Teachings of All Ages
BookID:3 Title: New Atlantis
DvdID:4 Title: A New Hope
DvdID:5 Title: Empire Strikes Back
DvdID:6 Title: Return of the Jedi
MagazineID:7 Title:Discovery Issue: June 2017
MagazineID:8 Title:Mad Magazine Issue: March 1978
MagazineID:9 Title:Thrasher Issue: January 1982

Print only books with lambda expressions.
BookID:1 Title: Java Complete
BookID:2 Title: Secret Teachings of All Ages
BookID:3 Title: New Atlantis

Print LibraryItem descriprions with lambda exprssions. 
Book Decription: Java Complete by Schildt
Book Decription: Secret Teachings of All Ages by Manly Hall
Book Decription: New Atlantis by Francis Bacon
DVD Decription: A New Hope
DVD Decription: Empire Strikes Back
DVD Decription: Return of the Jedi
Magazine Decription: Discovery, issue: June 2017
Magazine Decription: Mad Magazine, issue: March 1978
Magazine Decription: Thrasher, issue: January 1982

Print the list of overdue Library items (should be id#s 2, 3, & 6
BookID:2 Title: Secret Teachings of All Ages
BookID:3 Title: New Atlantis
DvdID:6 Title: Return of the Jedi

Print the list of overdue Books using lambda expressions (should be ids 2 & 3.
BookID:2 Title: Secret Teachings of All Ages
BookID:3 Title: New Atlantis

BUILD SUCCESSFUL (total time: 0 seconds)

*/
