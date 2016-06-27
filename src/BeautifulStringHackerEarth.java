import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;


public class BeautifulStringHackerEarth {
	public static void main(String[] args) {
		//Scanner scan=new Scanner (System.in);
		//int #yb;
		int $ty;
		//Arrays.equals(a, a2)
		float x=12;
		float y=4.8f;
		float z=x/y;
		
	System.out.println(z);
		switch(2)
		{
		case 1: System.out.println(1); break;
		case 2: System.out.println(2);
		case 3: System.out.println(3);
		break;
			
		}
		Double e=327.567;
		NumberFormat currency=NumberFormat.getCurrencyInstance();
		String es=currency.format(e);
		System.out.println(es);
		
		String str="ll";
		System.out.println(str.equals("LL"));
		int l=str.length();
		char[] c=str.toCharArray();
		int count=0;
		for(int i=0;i<l;i++)
		{
			int ca=0,cb=0,cc=0;
			if(c[i]=='a') ca++;
			else if (c[i]=='b') cb++;
			else if (c[i]=='c') cc++;
			else count++;
			for(int j=i+1;j<l;j++)
			{
				if(c[j]=='a') ca++;
				else if (c[j]=='b') cb++;
				else if (c[j]=='c') cc++;
				//else count++;
				
				if(ca==cb && cb==cc)
				{
				//	System.out.println(ca);
				count++;	
				}
			}
		}
		System.out.println(count);
	}
}
