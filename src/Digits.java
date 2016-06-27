import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Digits {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();

			//extract the digit
			int num=n,c=0;
			while(num>0)
			{
				int unit=num%10;
				//System.out.println("unit:"+unit+" num"+num);
				if(unit>0)
				{
					if(n%unit==0)
					{
						c++;
					}
					

				}
				num=num/10;
			}
			System.out.println(c);

		}
	}
}

