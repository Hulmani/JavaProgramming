import java.util.HashMap;


public class UnorderedAnagrams {

	static int unorderedAnagrams(String s)
	{
		HashMap<Character,Integer> hash=new HashMap<Character,Integer>();
		int n=0;

		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			if(!hash.containsKey(ch))
			{
				hash.put(ch,1);
			}
			else
			{
				int count=hash.get(ch);
				hash.put(ch,count+1);
			}
		}
		return n;
	}
	public static void main(String[] args)
	{
		System.out.println(unorderedAnagrams("abba"));
	}
}
