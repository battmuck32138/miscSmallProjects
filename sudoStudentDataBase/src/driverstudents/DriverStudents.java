/*
Mathew Buck
Java II Lab A
 */
package driverstudents;

public class DriverStudents {

    //test code for Students List Porject
    public static void main(String[] args) {
    
   StudentRecordManager srm = new StudentRecordManager();
   System.out.println("Add 6 students to the list.");
   srm.addStud("Linda", "firec", 5);
   srm.addStud("Glen", "Danzig", 3);
   srm.addStud("Dan", "Mountain", 7);
   srm.addStud("Brenda", "Walsh", 5);
   srm.addStud("Clair", "Forlani", 6);
   srm.addStud("Laura", "Blonde", 5);
   System.out.println(srm);
   System.out.println("Search by student ID: " + srm.searchID(10004));
   System.out.println("Student isn't in the system. " + srm.searchID(9));
   srm.remStud(10001);
   System.out.println("Remove a few Students.");
   srm.remStud(1);
   srm.remStud(10006);
   System.out.println(srm);
   StudentRecordManager.srIterator srItr = srm.iterator();
   System.out.println("Search for a student by ID number "
           + "and print transcript.");
   System.out.println();
   srm.TranscriptPrinter().printTranscript(srItr, 10003);
   System.out.println();
   srm.TranscriptPrinter().printTranscript(srItr, 1);
   Student s = new Student();
   s.printCourses(s);
   System.out.println();
   Student.sIterator sItr = s.iterator();
   System.out.println("Display using new iterator.");
   while (sItr.hasNext()){
        Student.Course element = sItr.next();
        System.out.print(element + ", ");
    }
    System.out.println();
    int[] IDs = srm.loadIDs();
    System.out.println();
    System.out.println("Display a list of transcripts from an "
            + "array of student IDs.");
    System.out.println();
    srm.TranscriptPrinter().printTranscript(srItr, IDs);
    System.out.println("Search the list of students for the"
            + " key String \"Dan\".");
    System.out.println(srm.searchFirstName("Dan"));
    System.out.println(srm.searchLastName("Dan"));
    System.out.println(srm.searchName("Dan").toString());
    System.out.println(srm.searchName("This String wont be found").toString());
        
    
        
    //end main
    }
    
//end class   
}

/*
OUTPUT

run:
Add 6 students to the list.
[Linda firec  ID:10001, Glen Danzig  ID:10002, Dan Mountain  ID:10003,
Brenda Walsh  ID:10004, Clair Forlani  ID:10005, Laura Blonde  ID:10006]
Search by student ID: Brenda Walsh  ID:10004
Student isn't in the system. No Such Student   ID:0
Remove a few Students.
No Such Student.
[Glen Danzig  ID:10002, Dan Mountain  ID:10003, Brenda Walsh  ID:10004,
Clair Forlani  ID:10005]
Search for a student by ID number and print transcript.

STUDENT TRANSCRIPT
Dan Mountain  ID:10003 Email: 10003@hotmail.com
LIN ALG Grade: A
ANTH 1 Grade: D
DATA STRUCT Grade: C
JAVA I Grade: B
CALC II Grade: C
ANTH 1 Grade: C
DATA STRUCT Grade: A

Student is not in the system.
CALC I Grade: B
CALC II Grade: D
JAVA II Grade: B
CALC II Grade: B
CALC II Grade: D

Display using new iterator.
CALC I Grade: B, CALC II Grade: D, JAVA II Grade: B, CALC II Grade: B,
CALC II Grade: D, 

Display a list of transcripts from an array of student IDs.

STUDENT TRANSCRIPT
Glen Danzig  ID:10002 Email: 10002@hotmail.com
JAVA I Grade: E
ANTH 1 Grade: B
GEOG I Grade: C

STUDENT TRANSCRIPT
Dan Mountain  ID:10003 Email: 10003@hotmail.com
LIN ALG Grade: A
ANTH 1 Grade: D
DATA STRUCT Grade: C
JAVA I Grade: B
CALC II Grade: C
ANTH 1 Grade: C
DATA STRUCT Grade: A

STUDENT TRANSCRIPT
Brenda Walsh  ID:10004 Email: 10004@hotmail.com
JAVA I Grade: D
ANTH 1 Grade: D
DATA STRUCT Grade: E
CALC III Grade: A
JAVA I Grade: B

STUDENT TRANSCRIPT
Clair Forlani  ID:10005 Email: 10005@hotmail.com
ANTH 1 Grade: C
CALC III Grade: C
DISCRETE MATH Grade: C
GEOG I Grade: C
LIN ALG Grade: A
CALC II Grade: D

Search the list of students for the key String "Dan".
Dan Mountain  ID:10003
Glen Danzig  ID:10002
[Dan Mountain  ID:10003, Glen Danzig  ID:10002]
[No Such Student   ID:0, No Such Student   ID:0]
BUILD SUCCESSFUL (total time: 0 seconds)

*/