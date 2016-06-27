
import java.util.HashMap;
import java.util.Map.Entry;
public class MinDistanceGraph {


	static HashMap<Integer,Integer> distance=new HashMap<Integer,Integer>();
	static HashMap<Integer,Integer> temp=new HashMap<Integer,Integer>();
	static HashMap<Integer,Integer> permanent=new HashMap<Integer,Integer>();
	public static void main(String[] args) throws InterruptedException
	{

		int [][]adj={{0,0,0,0,0,0},
					{0,0,1,1,0,0},//1
					{0,1,0,1,0,1},//2
					{0,1,1,0,1,1},//3
					{0,0,0,0,1,0},//4
					{0,0,1,0,0,0}//5
		};


		int [][]dist={{16,16,16,16,16,16},
					  {16,0,3,6,16,16},//1
					  {16,3,0,12,16,6},//2
					  {16,6,12,0,6,6},//3
					  {16,16,16,6,0,16},//4
					  {16,16,6,16,16,16}//5
		};
		int source=0;

		permanent.put(5, 0);
		int i=5;
		int next=16;
		do
		{
			for(int j=1; j<adj[i].length;j++)
			{
				if(j==i) continue;
				if(permanent.containsKey(j)) continue;
				
				
					if(!temp.containsKey(j)) 
					{
						int d=dist[i][j];
						System.out.println(j+" not present "+d);
						temp.put(j,d); //add if temp does not exists
						
						//if(d<next)
						//{source=j; next=d;}
					}
					else
					{
						int prev=temp.get(j);
						int d=dist[i][j]+permanent.get(i); //i is in the permanent 

						int min=Math.min(prev,d);
						temp.put(j, min);
						System.out.println(j+"  present "+min);
						//if(min<next)
						//{source=j; next=min;}
					}


				//}//adjacent=1
				
				System.out.println("distance of ["+i+" "+j+"]"+"= "+dist[i][j]);
			}//j
			//printTemp();
				source=calculateMin();
				System.out.println("Next is  "+source );
				//permanent.put(source,next);
				//temp.remove(source);
				i=source;
		Thread.sleep(2000);
		}while(temp.size()>0);// till  elements in temp list
		System.out.println(" ");
	
		for (Entry<Integer, Integer> entry : permanent.entrySet())
        {
			
            System.out.println(" Key : " +entry.getKey()  + " Value : "+entry.getValue());
        }
			
	}
	
	
	private static int  calculateMin() {
		int min=17;
		int i=0,s=0;
		for (Entry<Integer, Integer> entry : temp.entrySet())
        {
			int val=entry.getValue();
			 s=entry.getKey();
			 System.out.println(s+" "+val);
			if(val<min)
			{
				min=val;
				i=s;
			}
          
        }
		  System.out.println(temp.size()+"Choosen Key : " +i  + " Value : "+min);
		
		permanent.put(i, min);
		temp.remove(i);
		return i;//new Pair(s,min);
	}
}
