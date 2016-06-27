import java.util.HashMap;
import java.util.LinkedList;


public class BlastHays {

	
	public static boolean myequals( LinkedList<HayBlade> queue,int val)
	{
		for(HayBlade h:queue)
		if(h.getVal()==val)
		{
			return true;
		}
		return false;
	}
	public static HayBlade[] impactValues(HayBlade h)
	{
		HayBlade n[]=new HayBlade[h.radius*2];
		//System.out.println(h.radius+1);

		System.out.println("For "+h.getVal()+ "impact is ");
		for(int i=0;i<h.radius;i++)
		{
			n[i]=new HayBlade(h.getVal()-(1)*(i+1),h.radius+1);
			
			System.out.print( n[i].getVal()+",");
			
		}
		for(int i=h.radius;i<2*h.radius;i++)
		{
			int j=h.getVal()+(i-h.radius+1);
			//System.out.println("j: "+j);
			n[i]=new HayBlade(j,h.radius+1);
			
			System.out.print( n[i].getVal()+",");
			
		}
		System.out.println();
		System.out.println(n.length +" "+ (h.radius+1));
		return n;
	}
	public static void main(String[] args)
	{
		int[] pos={8,5,6,13,3,4};
		HashMap<Integer,Integer> hashMap=new HashMap();
		LinkedList<HayBlade> queue=new LinkedList<HayBlade>();
		for(int i=0;i<pos.length;i++)
		{
			hashMap.put(pos[i], pos[i]);    //creating hashmap of all the positions
		}

		int maxBlasted=0;
		int start=0;
		for(int i=0;i<pos.length;i++)   //for each position calculate the max impact
		{
			HashMap<Integer,Integer> hash=new HashMap(hashMap);
			
			int blasted=0;	
			queue.addLast(new HayBlade(pos[i],1));   //add the ith node with blast_radius=1 to the queue 
				
			while(!queue.isEmpty())
			{
				HayBlade h=queue.removeFirst(); //removes the  first element  to add the other values within radius -  for breadth first 
				blasted++; 					   // when a blade is removed its blasted
				hash.remove(h.getVal());
				System.out.println("Blasted "+h.getVal() +" radius "+h.radius);
				HayBlade[] impactVal=impactValues(h);
				
				for(HayBlade b:impactVal)      // for each HayBlade in the impact list calculate 
				{
				//	System.out.println("BBBBBB "+b.getVal());
					if(hash.containsKey(b.getVal()))  // if that HayBlade position is present in given positions
					{
				//		System.out.println("Hash Contains:"+b.getVal());
						
						if(!myequals(queue,b.getVal())) // if it is already in the queue it would have been blasted
						{

					//		System.out.println("Added  "+b.getVal());
							
							queue.addLast(b);   //if not blasted add to the list
//							System.out.println("------------------Queue----------------------");
//							
//							for(HayBlade l:queue)
//							{
//								System.out.println(l.getVal());
//							}
//							System.out.println("----------------------------------------");

						}
						else
							System.out.println("Queue contains " +b.getVal());  // prints if the list has the blade already in queue 
					}
					//else
					//	System.out.println("Hash does not Contains:"+b.getVal());
					
				}//for all impactValues

			}
			maxBlasted=(maxBlasted>blasted) ? maxBlasted:blasted;
			start=pos[i];
			System.out.println("Done with "+pos[i]+" Max_Blasted:"+maxBlasted +" "+blasted);
			System.out.println("----------------------------------------");
		}
		System.out.println("Solution: "+maxBlasted +"position "+start);
	}
}
