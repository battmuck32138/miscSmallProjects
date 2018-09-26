/*
Mathew Buck
Java II Lab B
 */
package listprocessordriver;

import java.util.ArrayList;
import java.util.List;

//Program that demonstrates the uses of Lambda Expressions.
public class ListProcessor {
    
    //filter method takes a list<T> of items and returns a List<T> of items
    //that satisfy Predicate<T>.
    public static<T> List<T> filter(List<T> list, Predicate<T> p){
        ArrayList<T> l = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(p.test(list.get(i))){
                l.add(list.get(i));
            }
        }
        return l;
    }
    
    //forEach method takes a List<T> of items and executes the Consumer<T>
    //method for every item in the List.
    public static<T> void forEach(List<T> list, Consumer<T> c){
        for(int i = 0; i < list.size(); i++){
            c.accept(list.get(i));
        }
    }
    
    //map method takes a List<T> of items and the Function<T, R>, 
    //runs the Function for every item in the List<T>, and 
    //returns a List<R> that contains the return Function<T, R>
    public static<T, R> List<R> map(List<T> list, Function<T, R> f){
      ArrayList<R> returnList = new ArrayList<>();
      R value;
        for(int i = 0; i < list.size(); i++){
            value = f.apply(list.get(i));
            returnList.add(value);
        }
        return returnList;
    }

//end class
}
