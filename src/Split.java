import java.util.LinkedList;
import java.util.Scanner;


public class Split {

	public static void main(String [] args)
	{
		System.out.println("Enter the string");
		Scanner in=new Scanner(System.in);
		String str=in.nextLine();
		LinkedList<String> l=new LinkedList<String>(); 
		//String str="/l/./././a/..";
		StringBuffer output=new StringBuffer();
		l.add("/");
		int i=0;
		for(String p:str.split("/"))
		{
			if(p.equals(".."))
			{
				if(l.size()==1)
				{
					
					System.out.println("-1");
					break;
				}
				System.out.println(	"Removing "+l.removeLast());
				
				
			}
			else if(!(p.equals("")||p.equals(".")))
			{
				l.add(p);
			}
				i++;
		}
		int j=0;
		//System.out.println("Path ");
		for(String o : l){
			if(j==0 || j==l.size()-1)
				System.out.print(o);
			else
		    System.out.print(o+"/");
			j++;
		}
	}
}
