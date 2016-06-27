import java.util.Scanner;


public class ReverseString {
	public static void main(String[] args)
	{
	//	Scanner scan=new Scanner(System.in);
		String in="Manojhulmaniisanasshole";
		StringBuilder inp=new StringBuilder(in);
		//System.out.println(in.substring(4)+in.substring(1,4)+in.substring(0,1));
		System.out.println(reverse(inp,0));
		System.out.println(removeDuplicates(in));
		
	}
	
	public static String reverse(StringBuilder s,int i)
	{
		int j=s.length()-i-1;
		if(i==j)
			return s.toString();
		
		else{
		char temp1=s.charAt(j);
		char temp2=s.charAt(i);
		s.setCharAt(i, temp1);
		s.setCharAt(j,temp2);
		
		//String p=s.substring(j)+s.substring(i+1,j)+s.substring(i,i+1);
		//System.out.println(s);
		reverse(s,i+1);

		return s.toString();
		}
	}
	
	
	public static String removeDuplicates(String s)
	{
		StringBuilder ret=new StringBuilder();
		int j=0;
		boolean[] chars=new boolean[256];
		
		for(int i=0;i<s.length();i++){
		int val=s.charAt(i);
		if(!chars[val])
		{
			ret.append(s.charAt(i));
		//ret.setCharAt(j, s.charAt(i));
		j++;
		}
		chars[val]=true;
		}
		return ret.toString();
	}
	
}
