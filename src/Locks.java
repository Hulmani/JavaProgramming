import java.util.HashMap;
import java.util.LinkedList;


public class Locks {
	
	public static void main(String[] args) {
		HashMap <String,Integer> hash=new HashMap<String,Integer>();
		LinkedList<String> ll=new LinkedList<String>();
		
		String []events={"ACQUIRE 3","ACQUIRE 4","RELEASE 4","RELEASE 3"};
		int l=events.length;
		for(int i=0;i<l;i++)
		{
			String[] s=events[i].split(" ");
			if(s[0].equals("ACQUIRE"))
			{
				if(hash.containsKey(s[1]))
				{
					System.out.println("Claiming resource again");
					break;
				}
				hash.put(s[1], 1);
				ll.addFirst(s[1]);
			}
			else
			{
				if(ll.peek()!=null && !s[1].equals(ll.peek()))
				{
					System.out.println("trying to remove wrong resource "+i +" ");
					break;
				}
				
				if(!hash.containsKey(s[1]))
						{
					System.out.println("trying to release unclaimed resource ");
					break;
						}
				hash.remove(s[1]);
				ll.removeFirst();
			}
			
		}
		
		if(hash.size()>0) System.out.println("dangling resource ");
		
		else 
			System.out.println("cleaned resources ");
	}
}
