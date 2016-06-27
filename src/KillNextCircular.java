import java.util.ArrayList;
import java.util.Scanner;


public class KillNextCircular {
	public static void main(String []args)
	{
		ArrayList<Integer> ppl= new ArrayList<Integer>();

		KillItem item=new KillItem(1);

		KillItem head=item,next,last;
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Number of People ");
		int n=scan.nextInt();
		System.out.println("Head "+head.getVal());
		
		for(int i=2;i<=n-1;i++)
		{
			next=new KillItem(i);
			item.setNext(next);
			//System.out.println("Next:"+item.getNext().getVal());
			item=item.getNext();


		}
		last=new KillItem(n); 
		item.setNext(last);
		//System.out.println("last but one"+item.getVal()+"Last:"+last.getVal()+" "+item.getNext().getVal());
		last.setNext(head);


		KillItem cur=head;
		while(cur.getNext()!=head)
		{
			//System.out.println(cur.getVal());
			cur=cur.getNext();
		}
		System.out.println("Tail:"+cur.getVal());


		while(head.getNext()!=head)
		{
			head=head.delete(head);
			
		}
		System.out.println("Survivor:"+head.getVal());
	
	}

}

