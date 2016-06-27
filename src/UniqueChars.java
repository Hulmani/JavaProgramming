import java.util.Scanner;

//For first repeated character - O(n) 
//create a boolean array and add elements to it.
//if the element is already present then thats the first repeated character

public class UniqueChars {

	static void hasUnique(String s)
	{
		int checker=0;
//		
		char[] c=s.toCharArray();
		for(int i=0;i<c.length;i++)
		{
			int val=c[i]-'a';
			//checker=(checker |j);
			//System.out.println(c[i]+" "+j+" "+checker);// | 1;
			System.out.print(c[i]+" "+val+" "+"checker="+checker +" v="+(checker & (1<<val))+"\t");
			if((checker & (1<<val)) >0) 
			{
				System.out.println(false); 
				break;
			}
			checker|=(1<<val);
			System.out.println("new checker "+checker +" val="+(1<<val));
		}
	}
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
//		String in=scan.next();
//		
//		boolean[] chars=new boolean[256];
//		for(int i=0;i<in.length();i++)
//		{
//			int val=in.charAt(i);
//			System.out.println(val);
//			if(chars[val])
//			{
				System.out.println(3& 3);
//				return;
//			}
//			chars[val]=true;
//		}
		hasUnique("bb");
	}
}
