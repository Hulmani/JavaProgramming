import java.util.HashMap;
import java.util.LinkedHashMap;
//in java we can use character as indexes, internally they are converted to int
//O(n) using a boolean values for remove characters
public class RemoveCharacters {

	public static void main(String[] args)
	{
		String s="Learning never stops";
		//s=s.toLowerCase();
		String remove="estp";
		StringBuilder r=new StringBuilder("");
		//String result=s;
		boolean [] characterArray=new boolean[256];
		//System.out.println(r.length());
		for(int i=0;i<remove.length();i++)
		{
			
			char p=remove.charAt(i);
			//System.out.println(p+""+(p));
			//result=result.replaceAll(p,r);
			characterArray[p]=true;
			
		}System.out.println("--------");
		
		for(int i=0;i<s.length();i++)
		{
			
			char p=s.charAt(i);
			//System.out.println(p+""+(p));
			if(p>=0)
			{
			if(!characterArray[p])
			{
				r.append(p);
			}
			}
			
		}
		System.out.println(r);
		//System.out.println(s.replace("a","b"));
//		for(int i=0;i<256;i++)
//		System.out.println(characterArray[i]);
		
		System.out.println();
		s="aabb";
		int i;
		for( i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			if(c==c)
				break;
		}
		System.out.println(i);
		
	}

}
