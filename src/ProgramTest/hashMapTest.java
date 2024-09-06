package ProgramTest;

import java.util.HashMap;

public class hashMapTest {

	public static void main(String[] args) {
		// Creating an empty HashMap
        HashMap<Integer, String> hash_map
            = new HashMap<Integer, String>();

        // Mapping string values to int keys
        hash_map.put(0, "Welcome");
        hash_map.put(1, "to");
        hash_map.put(2, "Geeks");
        hash_map.put(3, "4");
        hash_map.put(4, "Geeks");

        // Displaying the HashMap
        System.out.println("Initial Mappings are: "
                           + hash_map);

        // Using values() to get the set view of values
        System.out.println("The collection is: "
                           + hash_map.values());

	}

}
