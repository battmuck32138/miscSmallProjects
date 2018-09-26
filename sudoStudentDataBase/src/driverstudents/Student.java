/*
Mathew Buck
Java II Lab A
 */
package driverstudents;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

//class maintains info about a student
public class Student {

    private ArrayList<Course> courseList = new ArrayList();
    private String firstName = "Matt";
    private String lastName = "Buck";
    private int ID = 10000;
    private String email = genEmail(ID);
    public static int currentID = 10000;

    public Student() {
        generateCourses(5);
    }

    public Student(String firstName, String lastName, int ID, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.email = email;
        generateCourses(5);
    }

    public Student(String fn, String ln, int numCourses) {
        ID = currentID + 1;
        currentID++;
        firstName = fn;
        lastName = ln;
        email = genEmail(ID);
        generateCourses(numCourses);
    }
    
    //copy constructor
    public Student(Student orig){
        this.ID = orig.ID;
        this.firstName = orig.firstName;
        this.lastName = orig.lastName;
        this.courseList = orig.courseList;
        this.email = orig.email;
    }

    //uses an iterator to print the students courses
    public void printCourses(Student s) {
        Student.sIterator itr = s.iterator();
        while (itr.hasNext()) {
            Course element = itr.next();
            System.out.println(element);
        }
    }

    public void printCourses() {
        for (int i = 0; i < courseList.size(); i++) {
            System.out.println(courseList.get(i));
        }
    }

    //randomly chooses the students classes and grades from a list
    //of classes and grades in the Course class
    private void generateCourses(int num) {
        for (int i = 0; i < num; i++) {
            Course c = new Course();
            courseList.add(c);
        }
    }

    //generates the students email address from the students ID number
    public String genEmail(int ID) {
        String email = "";
        email = email.concat(Integer.toString(ID));
        email = email.concat("@hotmail.com");
        return email;
    }

    //returns deep copy
    public ArrayList<Course> getCourseList(Student s) {
        Student newStud = new Student(s);
        return newStud.courseList;
    }

    //returns deep copy
    public String getEmail(Student s) {
        Student newStud = new Student(s);
        return newStud.email;
    }

    //deep copy
    public int getID(Student s) {
        Student newStud = new Student(s);
        return newStud.ID;
    }

    //deep copy
    public String getFirstName(Student s) {
        Student newStud = new Student(s);
        return newStud.firstName;
    }

    //deep copy
    public String getLastName(Student s) {
        Student newStud = new Student(s);
        return newStud.lastName;
    }

    public String toString() {
        return firstName + " " + lastName + "  ID:" + ID;
    }

    public int getRandom(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1)) + min;
    }

    //creates courses I can access from other classes
    public Course Course(String name, char grade) {
        return new Course(name, grade);
    }

    //creates an iterator that I can get to from othrer classes
    public sIterator iterator() {
        return new sIterator();
    }

    //helper class for Student/////////////////////////////////////////////
    public class sIterator implements Iterator {

        int i = 0;
        Course c = null;

        public boolean hasNext() {
            if (i != courseList.size()) {
                return true;
            } //reset index for next time
            else {
                i = 0;
                return false;
            }
        }

        public Course next() {
            if (hasNext()) {
                c = courseList.get(i);
                i++;
            }
            return c;
        }

        //end helper iterator 
    }

    //helper class for Student/////////////////////////////////////////////
    public class Course {
        private char[] grades = new char[]{'A', 'B', 'C', 'D', 'E'};
        private String[] titles = new String[]{"CALC II", "CALC III", "CALC I",
        "JAVA I", "JAVA II", "LIN ALG", "DISCRETE MATH", "DATA STRUCT",
        "GEOG I", "ANTH 1", "ART HIST"};
        Random rand = new Random();
        String title = "Algebra 1";
        char grade = 'A';

        //picks a random course and grade
        public Course() {
            title = titles[rand.nextInt(11)];
            grade = grades[rand.nextInt(5)];
        }

        public Course(String title, char grade) {
            this.title = title;
            this.grade = grade;
        }

        public String toString() {
            return title + " Grade: " + grade;
        }

     //end helper Course
    }

//end Student
}
