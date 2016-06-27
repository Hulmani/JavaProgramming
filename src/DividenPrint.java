
public class DividenPrint {

	public static void call(int n){

		if(n>1)
		{
			System.out.println("hi");
			call(n/2);
			call(n/2);
		}
	}
	public static void main(String [] args)
	{


		call(10);


		int count=0;

		for(int i =1;i<5;i++)
		{
			for(int p = 1 ;p<i+10;p++)
			{
				for(int k = 1;k< i ;k++)

					count++;
			}
		}
		System.out.println(count);

	}
}