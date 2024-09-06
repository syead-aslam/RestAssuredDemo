package StringTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class testStr {
	
	//reverse of string
	private static void revstr(String str)
	{
		String revstr = "";
		int n = str.length();
		for(int i= n-1 ; i >= 0 ; i-- )
		{
			revstr += str.charAt(i);
		}
		System.out.println(revstr);
	}
	
	//Java Program To Count Occurrences Of Each Character In String :
	private static void strCharOccurrences(String str)
	{
		Map<Character , Integer> strCount = new HashMap<Character,Integer>();
		char[] chr = str.toCharArray();
		
		for(char  c: chr)
		{
			if(strCount.containsKey(c))
			{
				strCount.put(c,strCount.get(c)+1);
			}
			else
			{
				strCount.put(c,1);
			}
		}
		System.out.println(str+":"+strCount);
	}
	
	//Write a Java program to find the duplicate words and their number of occurrences in a string?
	private static void strWordOccurence(String str)
	{
		Map<String,Integer> wordCount = new HashMap<String,Integer>();
		String[] strArr = str.split(" ");
		
		for(String st : strArr)
		{
			if (wordCount.containsKey(st))
			{
				wordCount.put(st,wordCount.get(st)+1 );
			}
			else
			{
				wordCount.put(st, 1);
			}
		}
		
		Set<String> wordStrKey = wordCount.keySet();
		
		for(String st : wordStrKey)
		{
			if(wordCount.get(st) > 1)
			{
				System.out.println(st+" : " + wordCount.get(st));
			}
		}
		
	}

	//count the number of words in a string.
	private static void wordCount(String s)
	{
		int count = 1;
		 
        for (int i = 0; i < s.length()-1; i++)
        {
            if((s.charAt(i) == ' ') && (s.charAt(i+1) != ' '))
            {
                count++;
            }
        }
 
        System.out.println("Number of words in a string = "+count);
	}

	//	Java program to count the number of occurrences of each character in a string
	private static void strEachWordOccurence(String str)
	{
		HashMap<String,Integer> wordCount = new HashMap<String,Integer>();
		String[] strArr = str.split(" ");
		
		for(String st : strArr)
		{
			if (wordCount.containsKey(st))
			{
				wordCount.put(st,wordCount.get(st)+1 );
			}
			else
			{
				wordCount.put(st, 1);
			}
		}
		
		System.out.println(str+" : "+wordCount);
		
		Set<String> wordStrKey = wordCount.keySet();
		//without space count
		for(String st : wordStrKey)
		{
			
			System.out.println(st+" : " + wordCount.get(st));
			
		}
			
	}

	//Remove White Spaces From String Without Using Built-In Methods
	private static void RemoveWhiteSpaces(String str)
	{
		char[] charArray = str.toCharArray();
        
        String stringWithoutSpaces = "";
         
        for (int i = 0; i < charArray.length; i++) 
        {
            if ( (charArray[i] != ' ') && (charArray[i] != '\t') )
            {
                stringWithoutSpaces = stringWithoutSpaces + charArray[i];
            }
        }
         
        System.out.println("Input String : "+str);
         
        System.out.println("Input String Without Spaces : "+stringWithoutSpaces);
	}
	
	//Reverse Each Word Of A String In Java
	private static void reverseAllWords(String str)
	{
		String[] words = str.split(" ");
		String ReverseStr= "";
		for(int i = 0 ; i < words.length; i++ )
		{
			String word = words[i];
			String ReverseWord = "";
			for(int j = word.length()-1 ; j >=0 ; j-- )
			{
				ReverseWord = ReverseWord + word.charAt(j);
			}
			ReverseStr = ReverseStr + ReverseWord + " ";
		}
		System.out.println(str);
		System.out.println(ReverseStr);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "This is is not wrong not not wrong";
//		revstr(str);
//		strCharOccurrences(str);
//		strWordOccurence(str);
//		wordCount(str);
//		strEachWordOccurence(str);
//		RemoveWhiteSpaces(str);
		reverseAllWords(str);
	}

}
