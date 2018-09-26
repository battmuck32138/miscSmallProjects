/*
Mathew Buck
Java II Lab B
 */
package listprocessordriver;

public class Magazine extends LibraryItem {

    private final String issue;

    public Magazine(String title, String issue) {
        super.setTitle(title);
        this.issue = issue;
        super.setDescription("Magazine Decription: " + title 
                + ", issue: " + issue);
    }

    @Override
    public String toString() {
        String s = "MagazineID:" + getId() + " Title:"
                + getTitle() + " Issue: " + issue;
        return s;
    }

    public boolean equals(Magazine otherObject) {
        //1st check null
        if (otherObject == null) {
            return false;
        } //2nd check class
        else if (getClass() != otherObject.getClass()) {
            return false;
        } else {
            //3rd check cast of original object
            Magazine otherMagazine = (Magazine) otherObject;
        }
        //4th check that variables match
        return (getId() == otherObject.getId());
    }
}
