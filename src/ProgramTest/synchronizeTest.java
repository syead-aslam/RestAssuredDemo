package ProgramTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class synchronizeTest {

	public static void main(String[] args) {
		// Non Synchronized ArrayList
        List<String> list = new ArrayList<String>();

        list.add("Eat");
        list.add("Coffee");
        list.add("Code");
        list.add("Sleep");
        list.add("Repeat");

        // Synchronizing ArrayList in Java
        list = Collections.synchronizedList(list);

        // we must use synchronize block to avoid
        // non-deterministic behavior
        synchronized (list)
        {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }

	}

}
