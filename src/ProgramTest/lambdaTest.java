package ProgramTest;

import java.util.ArrayList;
import java.util.List;

public class lambdaTest {

	public static void main(String[] args) {
		 // Creating an ArrayList
        List<String> l = new ArrayList<String>();

        // Adding elements to the List
        // Custom inputs
        l.add("Geeks");
        l.add("for");
        l.add("Geeks");

        // Lambda expression printing all elements in a List
        l.forEach((temp) -> { System.out.println(temp); });

	}

}
