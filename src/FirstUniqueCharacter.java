import java.util.HashMap;
import java.util.LinkedHashMap;
//For first repeated character - O(n) 
//create a boolean array and add elements to it.
// if the element is already present then thats the first repeated character
//UniqueChars
//for first unique chracter can we use something similar
public class FirstUniqueCharacter {

	public static void main(String[] args)
	{
		String s="manoajm";
		
		LinkedHashMap<String,Boolean> hash=new LinkedHashMap<String,Boolean>();
		for(int i=0;i<s.length();i++)
		{
			if(hash.containsKey(s.charAt(i)+""))
			{
				hash.put(s.charAt(i)+"",false);
				//System.out.println(hash);
			}
			else 
				{
				
					hash.put(s.charAt(i)+"",true);
				}
		}
	
		System.out.println(hash);
	
	}
	
}
