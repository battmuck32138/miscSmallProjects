/*
Mathew Buck
Java II Lab B
 */
package listprocessordriver;

import java.util.Calendar;

public class DVD extends LibraryItem implements Borrowable {

    public DVD(String title) {
        super.setTitle(title);
        super.setDescription("DVD Decription: " + title);
    }

    @Override
    public String toString() {
        String s = "DvdID:" + getId() + " Title: " + this.getTitle();
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
