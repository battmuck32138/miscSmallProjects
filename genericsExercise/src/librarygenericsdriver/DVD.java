/*
Mathew Buck
Java II Lab B
 */
package librarygenericsdriver;

import java.util.Calendar;

public class DVD extends LibraryItem implements Borrowable {

    private Calendar checkOutDate;

    public DVD(String title) {
        super.setTitle(title);
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
        String s = "DvdID:" + getId() + " Title:" + this.getTitle();
        return s;
    }

    public Calendar getDueDate() {
        return super.getDueDate();
    }

    public boolean equals(DVD otherObject) {
        //1st check null
        if (otherObject == null) {
            return false;
        } //2nd check class
        else if (getClass() != otherObject.getClass()) {
            return false;
        } else {
            //3rd check cast of original object
            DVD otherDVD = (DVD) otherObject;
        }
        //4th check that variables match
        return (getId() == otherObject.getId());
    }

//end class   
}
