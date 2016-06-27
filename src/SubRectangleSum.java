import java.util.ArrayList;


public class SubRectangleSum {


	static ArrayList<Integer> subRectangleSum(int[][] rectangle,int val,int start,int end,int right,int down)
	{
		System.out.println("-----------------------");
        System.out.println("val="+val);
		ArrayList<Integer> a=new ArrayList<Integer>();
		ArrayList<Integer> b=new ArrayList<Integer>();
		ArrayList<Integer> c=new ArrayList<Integer>();
		//base case - 1 element 
		if(right==end && down==end)   
		{
			a.add(val);
			return a; 
		}

		//  down  reached 
		else if(down==end )
		{

			//val=rectangle[start][right];
			a=subRectangleSum(rectangle,rectangle[start][right],right,end,right+1,down);
		//	b.add(val);
			for(int i=0;i<a.size();i++)
			{
				int temp=a.get(i);
				//b.add(temp);
				b.add(val+temp);
				System.out.println("Sum="+(val+temp));
				//System.out.println((val+temp)+" "+temp);
			}
			return b;
		}
		else if(right==end)
		{

			// val=rectangle[start][right];

			a=subRectangleSum(rectangle,rectangle[start][down],down,end,right,down+1);
			//b.add(val);
			for(int i=0;i<a.size();i++)
			{
				int temp=a.get(i);
			//	b.add(temp);
				b.add(val+temp);
				System.out.println("Sum="+(val+temp));
			}
			return b;

		}
		else
		{
//			//go right
			a=subRectangleSum(rectangle,rectangle[start][right],right,end,right+1,down);
			b.add(val);
			for(int i=0;i<a.size();i++)
			{
				int temp=a.get(i);
			//	b.add(temp);
				b.add(val+temp);
				System.out.println("Sum="+(val+temp));
			}

			//go down
			c=subRectangleSum(rectangle,rectangle[down][start],down,end,right,down+1);
			for(int i=0;i<c.size();i++)
			{
				int temp=c.get(i);
				//b.add(temp);
				System.out.println("Sum="+(val+temp));
				
				b.add(val+temp);
				
			}


			return b;
		}


	}





	public static void main(String[] args)
	{
		int[][] rectangle={{9,2,-6},{-4,-1,-4},{-1,8,0}};
//				int[][] rectangle={{0,-2,-7,0},
//									{9,2,-6,2},
//									{-4,1,-4,1},
//									{-1,8,0,-2}
//									};

		System.out.println(rectangle.length);
		ArrayList <Integer>A=new ArrayList<Integer>();

		int start=0,right=start+1,down=start+1;
		A=subRectangleSum(rectangle,rectangle[0][0],start,rectangle.length,right,down);
		int max=A.get(0);
		for (int i=0;i<A.size();i++)
		{  if(max<A.get(i)) max=A.get(i);
		if(A.get(i)==15)	
		System.out.println(A.get(i));		
		}
		System.out.println("Max "+max);
	}
}
