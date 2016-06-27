
public class Permute {



	public static void permute(String prefix,String s)
	{
		int l=s.length();
		if(l==1)
		{	
			System.out.println(prefix+s.charAt(l-1));

		}

		else
		{
		for(int i=0;i<s.length();i++)
		{
			System.out.print(s.substring(i));

			String p= s.substring(i+1,l);
			prefix="";
			permute(prefix,p);
		}
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException
	{

		//Scanner scanner = new Scanner( System.in );

		System.out.println("Enter the name");
		String input = "manoj";//scanner.nextLine();
		int l=input.length();

		System.out.println(input.substring(1,l));
		System.out.println(input.charAt(l-1));
		if(input.substring(l,l)=="\0")
			System.out.println("true");
		else
			System.out.println("false");
		//rec(input);
		permute("mano","j");
		//System.out.println(input.charAt(0));
	}
}
