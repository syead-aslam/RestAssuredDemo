package ProgramTest;

import java.util.HashMap;
import java.util.Map;

public class ArrayProg {
	
	public static void dupArray(int[] arr)
	{
		Map<Integer,Integer> ArrCount = new HashMap <Integer,Integer> ();
		
		for(int a : arr)
		{
			if (ArrCount.containsKey(a))
			{
				ArrCount.put(a, ArrCount.get(a)+1);
			}
			else
			{
				ArrCount.put(a, 1);
			}
		}
		System.out.println(ArrCount);
		
	}

	public static void main(String[] args) {
		int[] arr = {12,10,12,14,10,16,18,16};
		dupArray(arr);

	}

}
