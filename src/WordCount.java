import java.util.HashMap;
import java.util.LinkedHashMap;
//there can n number of spaces between words so split on <space> wont work
//there can be leading and trailing spaces

public class WordCount {

	
	static String removeSpaces(String s)
	{
		char[] c=s.toCharArray();
		String resulString="";
		int i=0,j=c.length-1;
		while(c[i]==' ')
		{
			i++;
		}
		while(c[j]==' ')
		{
			j--;
		}
		System.out.println(s.substring(i,j+1));
		return s.substring(i, j+1)	;
	}
	
	public static void main(String[] args)
	{
		String s="  Learning     never     stops     op  ";
		s=removeSpaces(s);
		char[] c=s.toCharArray();
		String[] a=s.split(" ");
		System.out.println("Split method "+a.length);
		int count=0;

		for(int i=0;i<c.length;i++)
		{
			//System.out.println(c[i] +" " +count);
			if(c[i]==' ')
			{
				count++;
				//i++;
				while(c[i]==' ')
				{
					//System.out.println("continuos spaces "+i);
					//skip all spaces
					i++;
					if(i>=c.length) break;
				}
			}
		}
		System.out.println("Number of Words"+count+1);

	}

}
