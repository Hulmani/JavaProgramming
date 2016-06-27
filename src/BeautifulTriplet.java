import java.util.HashMap;
import java.util.Scanner;


public class BeautifulTriplet {
	public static void main(String[] args) {
		
		HashMap<Integer,Integer> ll=new HashMap<Integer,Integer> ();
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int d = in.nextInt();
//        int c[] = new int[n];
//        for(int c_i=0; c_i < n; c_i++){
//            c[c_i] = in.nextInt();
//        }
	int n=7,d=3;	 
	int []c={1, 2, 4, 5, 7 ,8 ,10};
	for(int i=0;i<n;i++)
	{
		ll.put(c[i], 1);
	}
      int count=0;
        for(int i=0;i<n-2;i++)
        {
        	if(ll.containsKey(c[i]+d) && ll.containsKey(c[i]+2*d) )
        	{
        		//System.out.println(c[i]);
        		count++;
        	}
        	}
        System.out.println(count);
     
    }

}
