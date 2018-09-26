/*
Mathew Buck
Java II Lab B
 */
package librarygenericsdriver;

import java.util.Calendar;

public class Book extends LibraryItem implements Borrowable {

    private Calendar checkOutDate = null;
    private String author;
            

    public Book(String title, String author) {
        super.setTitle(title);
        this.author = author;
    }
    
    public Calendar getDueDate(){
        return super.getDueDate();
    }
    
    

    @Override
    public Calendar getCheckoutDate() {
        return checkOutDate;
    }

    @Override
    public void setCheckoutDate(Calendar c) {
        checkOutDate = c;
    }

    @Override
    public String toString() {
        String s = "BookID:" + getId() + " Title:" + getTitle();
        return s;
    }
    
    public boolean equals(Book otherObject) {
        //1st check null
        if (otherObject == null) {
            return false;
        } //2nd check class
        else if (getClass() != otherObject.getClass()) {
            return false;
        } else {
            //3rd check cast of original object
            Book otherBook = (Book) otherObject;
        }
        //4th check that variables match
        return (getId() == otherObject.getId());
    }


//end class
}
