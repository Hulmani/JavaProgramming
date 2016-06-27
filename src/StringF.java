import java.util.Scanner;
import java.util.ArrayList;

public class StringF {


	
	static void pangram(){
		Scanner scan=new Scanner(System.in);
		String in=scan.nextLine();
		in=in.toLowerCase().replaceAll(" ", "");
		//System.out.println(in);
		boolean[] chars=new boolean [26];
		char [] inp=in.toCharArray();
		int c=0;
		//System.out.println((int)'0');
		for(int i=0;i<in.length();i++)
		{
			//We promptly judged antique ivory buckles for the next prize
			//System.out.println(inp[i]+" "+(inp[i]-'0'-49));
			if(!chars[inp[i]-'0'-49]) 
				{
					chars[inp[i]-'0'-49]=true;
					c++;
				}
			
		}
		if(c<26)
			System.out.println("not pangram");
		
		else if(c==26)
			System.out.println("pangram");
		else
			
			System.out.println(" error");
		}
	
	static void anagram(){
		String one="philibuster";
		String two="retusbphili";
		int l1=one.length();
		int l2=two.length();
		int count1[]=new int[26];
		int count2[]=new int[26];
		boolean an=true;
		if(l1!=l2)
		{
			System.out.println("not anagram");
			
		}
		else
		{
			char[] c1=one.toCharArray();
			char[] c2=two.toCharArray();
			
			for(int  i=0;i<l1;i++)
			{
				int j=c1[i]-'0'-48;
				System.out.println(j);
				count1[j]++;
			}
			
			for(int  i=0;i<l2;i++)
			{
				int j=c2[i]-'0'-48;
				System.out.println(j);
				count2[j]++;
				if(count2[j]>count1[j])
				{

					System.out.println("an=false");
					an=false;
					break;
				}
				
			}
			if(!an)
			{
				System.out.println("not anagram");
			}
			else
			{
			int i=0;
			for(i=0;count1[i]==count2[i] && i<l1;i++);
			if(i==l1)
				System.out.println("anagram");
			else 
				System.out.println("not anagram");
				
			}
		}
	}
	
		public static void main(String[] args) {	
			anagram();
		}
}
	
