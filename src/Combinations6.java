import java.util.Scanner;


public class Combinations6 {


	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		int a[]={1,2,3,4,5,6};
		int count=0;
		int diff=16;
		int a1=0,a2=0,a3=0;
		int min;
		for(int i=0;i<a.length;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				for(int k=j+1;k<a.length;k++)
				{
					count++;
					System.out.println(a[i]+","+a[j]+" "+a[k]);
					min=a[k]-a[i];

					if(min<=diff){ 
						diff=min;
						a1=a[i];
						a2=a[j];
						a3=a[k];
					}

				}
			}
		}
		System.out.println("Min "+a1+","+a2+","+a3);
		System.out.println(count);	
	}
}
