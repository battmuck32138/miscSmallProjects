/*
Mathew Buck
Java II Lab B
 */
package listprocessordriver;

import java.util.Calendar;

//Book and DVD implemnet this interface.
public interface Borrowable {
    
    public Calendar getCheckoutDate();
    public Calendar getDueDate();
    public void setCheckoutDate(Calendar cal);
}
