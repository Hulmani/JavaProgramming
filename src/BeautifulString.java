import java.util.HashMap;
import java.util.Scanner;





public class BeautifulString {
	static String removeChar(String s,int i)
	{
		if(i==0) 
		{
			//System.out.println(s.substring(1,s.length()));
			return s.substring(1,s.length());
		}
		else if(i==s.length()-1)
		{
			return s.substring(0,s.length()-1);
		}
		else{
			//System.out.println(s.substring(0,i)+s.substring(i+1,s.length()));
			return s.substring(0,i)+s.substring(i+1,s.length());
		}
	}
	public static void main(String[] args) {
		HashMap<String,Integer> list=new HashMap<String,Integer>();
		Scanner scan=new Scanner(System.in);
		String input=scan.next();
		int count=0;
		for(int i=0;i<input.length();i++)
		{
			String s1=  removeChar(input,i);
			if(s1.length()>2)
			{
				for(int j=0;j<s1.length();j++) 
				{

					String s2= removeChar(s1,j);
					System.out.println(count+" "+s1+" "+s2);
					if(!list.containsKey(s2))
					{
						list.put(s2,count++);
					}
				}
			}
			else
				if(!list.containsKey(s1))
				{
					list.put(s1,count++);
				}

		}
		for(String key:list.keySet())
		{
		//	System.out.println(key);
		}
		System.out.println(list.size());
	}
}