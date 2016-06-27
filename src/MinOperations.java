// Program to add_1 and/or multipy_2 to get to a number in MINIMUM operations starting at 0

import java.util.HashMap;
import java.util.LinkedList;


public class MinOperations {


	static int[] MinOperations(String[] nvalues) {

		int [] steps=new int[nvalues.length];
		for(int i=0;i<nvalues.length;i++)
		{

			int step=2;
			LinkedList <Integer>queue=new LinkedList<Integer>(); 
			HashMap<Integer,Integer>unique=new HashMap<Integer,Integer>();
			queue.add(2);

			int value=Integer.parseInt(nvalues[i]);
			int newFirst;
			int prev=1;
			int count=2;
			
			
			
			
			while(!queue.isEmpty())
			{
				
				int first=(int) queue.removeFirst();
				
				System.out.println("Removed Value : "+first);
				//adding 1 
				
				//System.out.println("Count <<1 "+ (prev<<1));
				
				
				
				if(count==(prev<<1))
				{
				step++;
				prev=count;
				System.out.println("count="+count+ "step="+step+ " Doubled prev value to "+prev);
				
				}
				newFirst=first+1;
				
				if(newFirst==value)
				{
					System.out.println("Step : "+step);
					steps[i]=step;
					break;
				}
				else
				{
					queue.addLast(newFirst);
					System.out.println("Pushed value : "+newFirst);
				}
				
				//multiplying 2
				//step++;
				newFirst=first*2;
				
				if(newFirst==value)
				{
					steps[i]=step;
					break;
				}
				else
				{
					queue.addLast(newFirst);
					System.out.println("Pushed value : "+newFirst);
					}
				
				
				//-----
				count+=2;
				//-----
				
			}
			System.out.println("FOund value "+value);
			System.out.println("----------");

		}
		return steps;
	}




	public static void main(String[] args) {


		String[] values={"3","4","5","6","8","9","10","11","12","15","16","17","18"};

		int[] val=MinOperations(values);
		int i=0;
		for(int v:val)
		{
			System.out.println(values[i]+":"+v);
			i++;
		}
	}

}

