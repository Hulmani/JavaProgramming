import java.util.Scanner;


public class Permutations {

	public static int factorial(int n) {
		int fact = 1; // this  will be the result
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}
	public static String swap(String a,int i,int j)
	{
		
		char[] charArray = a.toCharArray();
		char t=charArray[i];
		charArray[i]=charArray[j];
		charArray[j]=t;
		
		return new String(charArray);
	}

	public static void permute(String a)
	{
		int l=a.length();

		

		int j=0,k=0;
		int f=factorial(l);
		for(int i=0;i<f;i++)
		{
			j=i%l;
			k=(j+1)%l;
//			System.out.println("Constant"+i%l);
//			System.out.println("Swaping "+j+" "+k);
			
			
			
			a=swap(a,j,k);
			System.out.println(i+1+" "+a);

		}
		//		String constant=a.substring(0,1);
		//		String swap=a.substring(1,l);
		//		System.out.print(constant);
		//		swap(constant,swap);

	}







	public static void main(String[] args) throws InterruptedException
	{



		//Scanner scanner = new Scanner( System.in );

		System.out.println("Enter the name");
		String input = "manoj";//scanner.nextLine();
		int l=input.length();
		System.out.println(input);
		//rec(input);
		permute(input);
		//System.out.println(input.charAt(0));



	}







}
