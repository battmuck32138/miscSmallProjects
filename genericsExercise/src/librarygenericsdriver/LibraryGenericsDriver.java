/*
Mathew Buck
Java II Lab B
 */
package librarygenericsdriver;

import java.util.Calendar;
import java.util.GregorianCalendar;

//Programs demos the use of Generics.
public class LibraryGenericsDriver {

    //Test code for LibraryCollection.
    public static void main(String[] args) {

        //Calendar constructor takes year, month, day.
        //Jan = 0 in the built in Calendar so subtract 1 to set dates.
        Calendar now = Calendar.getInstance();
        Calendar checkOutCal = new GregorianCalendar(1950, 1, 1);
        Calendar cal1 = new GregorianCalendar(1976, 5, 11);
        Calendar cal2 = new GregorianCalendar(1978, 2, 16);
        Calendar cal3 = new GregorianCalendar(1982, 0, 17);
        Calendar checkToday = new GregorianCalendar(2017, 3, 6);
        Calendar nextDecade = new GregorianCalendar(2027, 3, 12);
        LibraryCollection<LibraryItem> lib1 = new LibraryCollection();
        LibraryCollection<LibraryItem> lib2 = new LibraryCollection();
        LibraryCollection<LibraryItem> lib3 = new LibraryCollection();
        Book b1 = new Book("Java Complete", "Schildt");
        Book b2 = new Book("Secret Teachings of All Ages", "Manly Hall");
        Book b3 = new Book("New Atlantis", "Francis Bacon");
        DVD d1 = new DVD("A New Hope");
        DVD d2 = new DVD("Empire Strikes Back");
        DVD d3 = new DVD("Retrun of the Jedi");
        Magazine m1 = new Magazine("Discovery", "June 2017");
        Magazine m2 = new Magazine("Mad Magazine", "March 1978");
        Magazine m3 = new Magazine("Thrasher", "January 1982");
        Book[] bookArr = new Book[]{b1, b2, b3};
        DVD[] dvdArr = new DVD[]{d1, d2, d3,};

        lib1.add(b1);
        lib1.add(d1);
        lib1.add(m1);
        System.out.println(lib1);
        lib2.add(b2);
        lib2.add(d2);
        lib2.add(m2);
        System.out.println(lib2);
        System.out.println(lib2.size());
        System.out.println(lib2.isEmpty());
        lib2.clear();
        System.out.println(lib2.isEmpty());
        System.out.println(lib2.size());
        System.out.println(lib2);
        lib3.add(b3);
        lib3.add(d3);
        lib3.add(m3);
        System.out.println(lib3);
        System.out.println(lib3.contains(b3));
        lib3.remove(b3);
        System.out.println(lib3.contains(b3));
        System.out.println(lib3);
        lib3.remove(d3);
        System.out.println(lib3.size());
        System.out.println(lib3);
        lib3.remove(m3);
        System.out.println(lib3);
        b1.displayCalendar(b1.getCheckoutDate());
        b1.setCheckoutDate(cal1);
        b1.displayCalendar(b1.getCheckoutDate());
        b1.displayCalendar(b1.getDueDate());
        b1.setDueDate(cal2);
        b1.displayCalendar(b1.getDueDate());
        d1.displayCalendar(d1.getCheckoutDate());
        d1.setCheckoutDate(cal3);
        d1.displayCalendar(d1.getCheckoutDate());
        d1.displayCalendar(d1.getDueDate());
        d1.setDueDate(cal1);
        d1.displayCalendar(d1.getDueDate());
        lib2.add(b2);
        lib2.add(d2);
        lib2.add(m2);
        System.out.println(lib2);
        System.out.println(lib1);
        lib1.addAll(lib2);
        System.out.println(lib1);
        lib1.clear();
        System.out.println(lib1);
        lib3.addAll(lib1);
        lib1.add(b2);
        System.out.println(lib1);
        System.out.println(lib3);
        System.out.println(lib1.containsAll(lib3));
        System.out.println(lib3.containsAll(lib1));
        lib1.clear();
        lib1.add(b1);
        lib1.add(b1);
        lib1.add(b3);
        System.out.println(lib3);
        System.out.println(lib1);
        System.out.println(lib3.containsAll(lib1));
        lib3.add(b2);
        lib3.add(b3);
        System.out.println(lib3);
        System.out.println(lib1);
        lib3.retainAll(lib1);
        System.out.println(lib3);
        System.out.println(lib2);
        lib3.retainAll(lib2);
        System.out.println(lib3);
        lib3.add(b1);
        lib3.add(b2);
        lib3.add(m3);
        System.out.println(lib3);
        System.out.println(lib2);
        lib3.removeAll(lib2);
        System.out.println(lib3);
        System.out.println(lib1);
        lib3.removeAll(lib1);
        System.out.println(lib3);
        lib3.add(b1);
        lib3.add(b2);
        lib3.add(b3);
        System.out.println(lib3);
        Object[] arr = lib3.toArray();
        for (Object arr1 : arr) {
            System.out.println(arr1);
        }
        System.out.println();
        LibraryItem[] arr1;
        arr1 = lib1.toArray(bookArr);
        for (LibraryItem arr11 : arr1) {
            System.out.println(arr11);
        }
        System.out.println();
        arr1 = lib1.toArray(dvdArr);
        for (LibraryItem arr11 : arr1) {
            System.out.print(arr11);
        }
        System.out.println();
        System.out.println();
        System.out.println("Display using new iterator.");
        LibraryCollection.Literator Itr = lib1.iterator();
        while (Itr.hasNext()) {
            Comparable element = Itr.getNext();
            System.out.println(element + ", ");
        }
        System.out.println();
        b1.setCheckoutDate(checkOutCal);
        b2.setCheckoutDate(checkToday);
        b3.setCheckoutDate(checkOutCal);
        d1.setCheckoutDate(checkOutCal);
        d2.setCheckoutDate(checkOutCal);
        d3.setCheckoutDate(checkOutCal);
        b1.setDueDate(cal1);
        b2.setDueDate(nextDecade);
        b3.setDueDate(cal2);
        d1.setDueDate(cal3);
        d2.setDueDate(cal2);
        d3.setDueDate(nextDecade);
        b1.displayCalendar(now);
        System.out.println(b1.isOverDue());
        System.out.println(b2.isOverDue());
        System.out.println(b3.isOverDue());
        System.out.println(b1.getClass());
        lib1.clear();
        lib1.add(b1);
        lib1.add(b2);
        lib1.add(b3);
        lib1.add(d1);
        lib1.add(d2);
        lib1.add(d3);
        System.out.println(b1.isOverDue());
        System.out.println(b3.isOverDue());
        System.out.println(lib1);
        LibraryCollection.CheckOutCart cart = lib1.checkOutCart();
        Object[] obArr = cart.getOverDueBooks(now);
        System.out.println("Overdue books shoule be id#1 & id#3.");
        for (int i = 0; i < obArr.length; i++) {
            System.out.println(obArr[i]);
        }
        lib2.clear();
        lib2.add(m2);
        lib2.add(m3);
        lib2.add(m1);
        lib2.add(d2);
        lib2.add(b1);
        lib2.add(d1);
        lib2.add(b2);
        lib2.add(b1);
        System.out.println(lib2);
        LibraryCollection.DueDateIterator DDItr = lib2.getDueDateIterator();
        DDItr.sortByDueDates();
        for (int i = 0; i < DDItr.arr.length; i++) {
            LibraryItem l = (LibraryItem) DDItr.arr[i];
            l.displayDueDate();
        }
        System.out.println("The LibraryCollection is holding the "
                + "following collection: ");
        System.out.println(lib2);
        System.out.println("The due dates of the library items are: ");
        for (int i = 0; i < lib2.size(); i++) {
            LibraryItem l = (LibraryItem) lib2.getElem(i);
            l.displayDueDate();
        }
        System.out.println("Using getDueDateIterator() to display the list:");
        while (DDItr.hasNext()) {
            Comparable element = DDItr.getNext();
            System.out.print(element + ", ");
            System.out.println();
        }
        System.out.println();
        System.out.println("Displaying the due dates with the itertor:");
        while (DDItr.hasNext()) {
            Comparable element = DDItr.getNext();
            System.out.print(element + ", ");
            System.out.println();
        }
        System.out.println();
        while (DDItr.hasNext()) {
            LibraryItem element = (LibraryItem) DDItr.getNext();
            element.displayDueDate();
        }
        System.out.println("The iterator is iterating by due dates.");
    }
}

/*
OUTPUT

run:
Collection#1 Sz:3 [BookID:1 Title:Java Complete, 
DvdID:4 Title:A New Hope, 
MagazineID:7 Title:Discovery Issue: June 2017]
Collection#2 Sz:3 [BookID:2 Title:Secret Teachings of All Ages, 
DvdID:5 Title:Empire Strikes Back, 
MagazineID:8 Title:Mad Magazine Issue: March 1978]
3
false
true
0
Collection#2 Sz:0 []
Collection#3 Sz:3 [BookID:3 Title:New Atlantis, 
DvdID:6 Title:Retrun of the Jedi, 
MagazineID:9 Title:Thrasher Issue: January 1982]
true
false
Collection#3 Sz:2 [DvdID:6 Title:Retrun of the Jedi, 
MagazineID:9 Title:Thrasher Issue: January 1982]
1
Collection#3 Sz:1 [MagazineID:9 Title:Thrasher Issue: January 1982]
Collection#3 Sz:0 []
Date is null.
6/11/1976
9/9/9999
3/16/1978
Date is null.
1/17/1982
9/9/9999
6/11/1976
Collection#2 Sz:3 [BookID:2 Title:Secret Teachings of All Ages, 
DvdID:5 Title:Empire Strikes Back, 
MagazineID:8 Title:Mad Magazine Issue: March 1978]
Collection#1 Sz:3 [BookID:1 Title:Java Complete, 
DvdID:4 Title:A New Hope, 
MagazineID:7 Title:Discovery Issue: June 2017]
Collection#1 Sz:6 [BookID:1 Title:Java Complete, 
DvdID:4 Title:A New Hope, 
MagazineID:7 Title:Discovery Issue: June 2017, 
BookID:2 Title:Secret Teachings of All Ages, 
DvdID:5 Title:Empire Strikes Back, 
MagazineID:8 Title:Mad Magazine Issue: March 1978]
Collection#1 Sz:0 []
Collection#1 Sz:1 [BookID:2 Title:Secret Teachings of All Ages]
Collection#3 Sz:0 []
true
false
Collection#3 Sz:0 []
Collection#1 Sz:3 [BookID:1 Title:Java Complete, 
BookID:1 Title:Java Complete, 
BookID:3 Title:New Atlantis]
false
Collection#3 Sz:2 [BookID:2 Title:Secret Teachings of All Ages, 
BookID:3 Title:New Atlantis]
Collection#1 Sz:3 [BookID:1 Title:Java Complete, 
BookID:1 Title:Java Complete, 
BookID:3 Title:New Atlantis]
Collection#3 Sz:1 [BookID:3 Title:New Atlantis]
Collection#2 Sz:3 [BookID:2 Title:Secret Teachings of All Ages, 
DvdID:5 Title:Empire Strikes Back, 
MagazineID:8 Title:Mad Magazine Issue: March 1978]
Collection#3 Sz:0 []
Collection#3 Sz:3 [BookID:1 Title:Java Complete, 
BookID:2 Title:Secret Teachings of All Ages, 
MagazineID:9 Title:Thrasher Issue: January 1982]
Collection#2 Sz:3 [BookID:2 Title:Secret Teachings of All Ages, 
DvdID:5 Title:Empire Strikes Back, 
MagazineID:8 Title:Mad Magazine Issue: March 1978]
Collection#3 Sz:1 [BookID:1 Title:Java Complete]
Collection#1 Sz:3 [BookID:1 Title:Java Complete, 
BookID:1 Title:Java Complete, 
BookID:3 Title:New Atlantis]
Collection#3 Sz:0 []
Collection#3 Sz:3 [BookID:1 Title:Java Complete, 
BookID:2 Title:Secret Teachings of All Ages, 
BookID:3 Title:New Atlantis]
BookID:1 Title:Java Complete
BookID:2 Title:Secret Teachings of All Ages
BookID:3 Title:New Atlantis

BookID:1 Title:Java Complete
BookID:2 Title:Secret Teachings of All Ages
BookID:3 Title:New Atlantis

DvdID:4 Title:A New HopeDvdID:
5 Title:Empire Strikes BackDvdID:6 Title:Retrun of the Jedi

Display using new iterator.
BookID:1 Title:Java Complete, 
BookID:1 Title:Java Complete, 
BookID:3 Title:New Atlantis, 

4/6/2017
true
false
true
class librarygenericsdriver.Book
true
true
Collection#1 Sz:6 [BookID:1 Title:Java Complete, 
BookID:2 Title:Secret Teachings of All Ages, 
BookID:3 Title:New Atlantis, 
DvdID:4 Title:A New Hope, 
DvdID:5 Title:Empire Strikes Back, 
DvdID:6 Title:Retrun of the Jedi]
Overdue books shoule be id#1 & id#3.
BookID:1 Title:Java Complete
BookID:3 Title:New Atlantis
Collection#2 Sz:8 [MagazineID:8 Title:Mad Magazine Issue: March 1978, 
MagazineID:9 Title:Thrasher Issue: January 1982, 
MagazineID:7 Title:Discovery Issue: June 2017, 
DvdID:5 Title:Empire Strikes Back, 
BookID:1 Title:Java Complete, 
DvdID:4 Title:A New Hope, 
BookID:2 Title:Secret Teachings of All Ages, 
BookID:1 Title:Java Complete]
id:1 Due: 6/11/1976
id:1 Due: 6/11/1976
id:5 Due: 3/16/1978
id:4 Due: 1/17/1982
id:2 Due: 4/12/2027
id:8 Due: 9/9/9999
id:9 Due: 9/9/9999
id:7 Due: 9/9/9999
The LibraryCollection is holding the following collection: 
Collection#2 Sz:8 [MagazineID:8 Title:Mad Magazine Issue: March 1978, 
MagazineID:9 Title:Thrasher Issue: January 1982, 
MagazineID:7 Title:Discovery Issue: June 2017, 
DvdID:5 Title:Empire Strikes Back, 
BookID:1 Title:Java Complete, 
DvdID:4 Title:A New Hope, 
BookID:2 Title:Secret Teachings of All Ages, 
BookID:1 Title:Java Complete]
The due dates of the library items are: 
id:8 Due: 9/9/9999
id:9 Due: 9/9/9999
id:7 Due: 9/9/9999
id:5 Due: 3/16/1978
id:1 Due: 6/11/1976
id:4 Due: 1/17/1982
id:2 Due: 4/12/2027
id:1 Due: 6/11/1976
Using getDueDateIterator() to display the list:
BookID:1 Title:Java Complete, 
BookID:1 Title:Java Complete, 
DvdID:5 Title:Empire Strikes Back, 
DvdID:4 Title:A New Hope, 
BookID:2 Title:Secret Teachings of All Ages, 
MagazineID:8 Title:Mad Magazine Issue: March 1978, 
MagazineID:9 Title:Thrasher Issue: January 1982, 
MagazineID:7 Title:Discovery Issue: June 2017, 

Displaying the due dates with the itertor:
BookID:1 Title:Java Complete, 
BookID:1 Title:Java Complete, 
DvdID:5 Title:Empire Strikes Back, 
DvdID:4 Title:A New Hope, 
BookID:2 Title:Secret Teachings of All Ages, 
MagazineID:8 Title:Mad Magazine Issue: March 1978, 
MagazineID:9 Title:Thrasher Issue: January 1982, 
MagazineID:7 Title:Discovery Issue: June 2017, 

id:1 Due: 6/11/1976
id:1 Due: 6/11/1976
id:5 Due: 3/16/1978
id:4 Due: 1/17/1982
id:2 Due: 4/12/2027
id:8 Due: 9/9/9999
id:9 Due: 9/9/9999
id:7 Due: 9/9/9999
The iterator is iterating by due dates.
BUILD SUCCESSFUL (total time: 0 seconds)


*/