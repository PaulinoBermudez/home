/**
 * @(#)CloneMethodHashSetExample.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2015/8/24
 */

import java.util.HashSet;

public class CloneMethodHashSetExample {
	
    public static void main(String args[]){
    	
        // create an empty HashSet
        HashSet hashset1= new HashSet();
        
        // use add() method to add elements to the HashSet
        hashset1.add("Element1");
        hashset1.add("Element2");
        hashset1.add("Element3");

        //Printing the elements of the HashSet hashset1
        System.out.println("**Elements of the hashset1**");
        for(String temp:hashset1){
            System.out.println(temp);
        }
        
        // create another empty HashSet
        HashSet hashset2 = new HashSet();
        //Shallow copying of hashset1 to hashset2
        hashset2 =(HashSet)hashset1.clone();
        
        //Printing the elements of the HashSet hashset2
        System.out.println("**Elements of the hashset2**");
        
        for(String temp:hashset2){
            System.out.println(temp);
        }
    }
}