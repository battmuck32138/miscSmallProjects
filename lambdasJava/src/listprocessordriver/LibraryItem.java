/*
Mathew Buck
Java II Lab B
 */
package listprocessordriver;

import java.util.Calendar;
import java.util.GregorianCalendar;

//Patent class for Book, DVD and Magazine.
public class LibraryItem implements Comparable<LibraryItem> {

    public static int itemId = 1;
    private final int id;
    private String title;
    private String description; 
    private Calendar dueDate = new GregorianCalendar(9999, 8, 9);
    private Calendar checkOutDate = new GregorianCalendar(2016, 1, 1);
    public boolean overDue = false;

    public LibraryItem() {
        id = itemId;
        itemId++;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public Calendar getCheckoutDate() {
        return checkOutDate;
    }
    
    public void setCheckoutDate(Calendar c) {
        checkOutDate = c;
    }


    @Override
    public int compareTo(LibraryItem o) {
        if (dueDate.before(o.dueDate)) {
            return -1;
        }
        if (dueDate.after(o.dueDate)) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean isOverDue() {
        return overDue;
    }

    public void setDueDate(Calendar c) {
        dueDate = c;
        Calendar now = Calendar.getInstance();
        if (now.after(dueDate)) {
            overDue = true;
        }
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public void displayCalendar(Calendar cal) {
        if (cal == null) {
            System.out.println("Date is null.");
            return;
        }
        //January = 0 per the built in Calendar.
        //Add 1 to month for a standard output 
        //6/11/1976 is displayed 5/11/1976 in the Calendar.
        System.out.print((cal.get(cal.MONTH) + 1) + "/");
        System.out.print(cal.get(cal.DATE) + "/");
        System.out.println(cal.get(cal.YEAR));
    }

    public void displayDueDate() {
        System.out.print("id:" + id + " Due: ");
        displayCalendar(dueDate);
    }

//end class
}
