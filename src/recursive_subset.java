import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class recursive_subset {

	public static HashMap<Integer,ArrayList> hash=new HashMap<Integer,ArrayList>();
	public static int count=0;
	
	public static ArrayList print (ArrayList a,int skip)
	{
		int j=0;
		ArrayList b=new ArrayList();
		for(int i=0;i<a.size();i++)
		{
			if(i!=skip){
				b.add(a.get(i));
		//	System.out.print(a.get(i)+",");
			}
		}
		if(!hash.containsValue(b))
		{
			hash.put(count++,b);
		}
		//System.out.println();
		return b;
	}
	
	
	public static void subset(ArrayList a,int l,int r){
	
		//if first and last index same terminate 
		if(l==r) 
		{
			
			//System.out.println("----------------------------");
			return;
		}
		
		//i th element is skipped in the array  
		for(int i=l;i<r;i++)
		{
			//form an arrray with 
			
			ArrayList b=new ArrayList();
			
			//with i skipped
			b=print(a,i);	
			//repeat it for the sub array
			subset(b,0,b.size());
		
		
		}
		
	//	subset(a,l+1,r);
	
	}

		
	public static void main(String[] args) {

		
		
//		for(int i=1;i<6;i++)
//		{
//			a.add(i);
//		}
		
		
		Scanner scan=new Scanner(System.in);
		int test_cases=Integer.parseInt(scan.next());
		for(int i=0;i<test_cases;i++)
		{
			hash.clear();
			count=0;
			ArrayList a=new ArrayList();
			int n=Integer.parseInt(scan.next());
			int k=Integer.parseInt(scan.next());
			System.out.println("k is "+k);
		// first and last index
			for(int j=0;j<n;j++)
			{
				a.add(Integer.parseInt(scan.next()));
				
			}
			hash.put(count++,a);
		subset(a,0,a.size());
		
		
		System.out.println("Total subsets "+hash.size());
		for(int p=0;p<hash.size();p++)
		{
			System.out.println(hash.get(p));
		}
		
		ArrayList<Integer> l;
		int ct=0;
		for(int p=0;p<hash.size();p++)
		{
			l =hash.get(p);
			
			for(Integer val:l)
			{
				//System.out.print(val+"\t");
				if(val>k)
				{
					ct++;
				//	System.out.print(ct+" "+val+"," );
				}
			}
			System.out.println("-----------------");
			
		}
		System.out.println("Count "+ct);	
		}//testcase
		
	}
}