import java.util.LinkedList;
public class ReverseLinkedList {

	public static void main(String[] args) throws InterruptedException
	{
		LinkedList<Integer> ll=new LinkedList<Integer> ();
		LinkedList<Integer> li=new LinkedList<Integer> ();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		System.out.println(ll);
		int l=ll.size(),i=0;
		while(i!=l)
		{
			int r=ll.pollLast();
			System.out.println("removed "+r);
			System.out.println(ll);
			li.addLast(r);
			i++;
		}
		System.out.println(li);
	}
}
