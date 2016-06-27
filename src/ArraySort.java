import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ArraySort {
	public static void main(String[] args)
	{
		int a[]={98,434,65,3,2};
	List b=	Arrays.asList(a);
		Collections.sort(b);
		for(Object i:b)
		{
			System.out.println((int)i);
		}
	//Collections.sor
	}
}
