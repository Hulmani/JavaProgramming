import java.util.LinkedList;
import java.util.Scanner;


public class Block {


	int val;
	int pos;
	LinkedList<Integer> queue;

	Block(int i)
	{
		val=1;									//to know the block is in its initial position
		queue=new LinkedList<Integer> ();
		pos=i;
	}

	static  Block[] moveInitial(int a,Block[] blocks)
	{
		if(blocks[a].val==1)
		{
			while(!blocks[a].queue.isEmpty())
			{
				int i=blocks[a].queue.removeFirst();
				blocks[i].val=1;
				blocks[i].pos=i;
			}

			blocks[a].val=1;
			blocks[a].pos=a;
		}
		else
		{
			int pos=blocks[a].pos;  //get where is a
			int i=0;

			while(blocks[pos].queue.get(i)!=a) //till I find a
				i++;

			//remove from i+1;
			i++;
			while(i<blocks[pos].queue.size())
			{
				int k=blocks[pos].queue.remove(i);
				blocks=setPosition(k,k,blocks);
				i++;
			}
			// now top of a 
		}
		return blocks;	
	}


	static int getPosition(int b,Block[] blocks)
	{

		if(blocks[b].val==0) return b;
		else
			return	blocks[b].pos;

	}

	static Block[] setPosition(int a,int b,Block[] blocks)
	{
		blocks[a].val=0;
		blocks[a].pos=b;
		return	blocks;

	}
	
	
	//move a onto b
	//where a and b are block numbers, puts block a onto block b 
	//after returning any blocks that are stacked on top of blocks a and b to their initial positions.
	static  Block[] moveOnto(int a,int b,Block[] blocks)
	{
//		int posa=getPosition(a,blocks);
//		int posb=getPosition(b,blocks);

		blocks=moveInitial(a,blocks);
		blocks=moveInitial(b,blocks);
		blocks[b].queue.addLast(a);

		return blocks;	
	}


	//move a over b
	//where a and b are block numbers, puts block a onto the top of the stack containing block b, 
	//after returning any blocks that are stacked on top of block a to their initial positions.
	static  Block[] moveOver(int a,int b,Block[] blocks)
	{
		int posa=getPosition(a,blocks);
		int posb=getPosition(b,blocks);
		//is a is on top of b dont do anything
		
		if(posa!=posb)
		{
			blocks=moveInitial(a,blocks);
			blocks=setPosition(a,b,blocks);
		}
		return blocks;	
	}


	
	
	//pile a over b
	//where a and b are block numbers, puts the pile of blocks consisting of block a,
	//and any blocks that are stacked above block a, onto the top of the stack containing block b. 
	//The blocks stacked above block a retain their original order when moved.
	static  Block[] pileOver(int a,int b,Block[] blocks)
	{
		int posa=getPosition(a,blocks);
		int posb=getPosition(b,blocks);
		
		if(posa!=posb)
		{
			
			
			
			blocks=setPosition(a,b,blocks);
		}
		
		return blocks;	
	}

	//pile a onto b
	//where a and b are block numbers, moves the pile of blocks consisting of block a, 
	//and any blocks that are stacked above block a, onto block b. 
	//All blocks on top of block b are moved to their initial positions prior to the pile taking place. 
	//The blocks stacked above block a retain their order when moved.
	static  Block[] pileOnto(int a,int b,Block[] blocks)
	{
		if(blocks[a].pos!=b)      //if a is not already on b
		{
			if(blocks[b].val==1) //if b is in its position 
			{
				blocks=moveInitial(b,blocks); // b is cleared
				while(!blocks[a].queue.isEmpty())
				{
					int k=blocks[a].queue.removeFirst();   //retains order
					blocks[k].val=0;
					blocks[k].pos=b;
					blocks[b].queue.addLast(k);
				}
				blocks[a].val=0;
			}

			else
			{
				int i=blocks[b].pos; 
				int j=0;
				while(blocks[i].queue.get(j)!=b)
					j++;   

				j=j+1;  //remove from next block to clear b
				//clear blocks on top of b
				while(j<blocks[i].queue.size())
				{
					int k=blocks[i].queue.remove(j);
					blocks[k].pos=k;
					blocks[k].val=1;
					j++;
				}

				//place a block  on b

				blocks[i].queue.addLast(a); //a is added and a is empty 
				blocks[a].val=0; //redundant?
				blocks[a].pos=i;    //a is on ith block now


				while(!blocks[a].queue.isEmpty())
				{
					int k=blocks[a].queue.removeFirst(); //retaining order
					blocks[k].pos=i;    //the blocks on top of a are changed to ith block
					blocks[k].val=0;  //redundant? - already on top of a
					blocks[i].queue.addLast(k);

				}

			}

		}

		return blocks;	
	}

	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		int n=Integer.parseInt(scan.nextLine());
		Block[] blocks=new Block [n]; 	

		for(int i=0;i<n;i++)
		{
			blocks[i]=new Block(i);
		}
		String command=scan.nextLine();
		while(!command.equals("quit"))
		{

			String space="\\s+";
			String[] values=command.split(space);
			//			for (String val:values)
			//				System.out.println(val);

			//	System.out.println(values.length);
			int a=Integer.parseInt(values[1]);
			int b=Integer.parseInt(values[3]);
			switch(values[0])
			{
			case "move":
				switch(values[2])
				{
				case "onto":
					blocks=moveOnto(a,b,blocks);
					break;
				case "over":
					blocks=moveOver(a,b,blocks);
					break;
				}
				break;
			case "pile":
				switch(values[2])
				{
				case "onto":
					blocks=pileOnto(a,b,blocks);
					break;
				case "over":
					blocks=pileOver(a,b,blocks);
					break;
				}
				break;
			}	 
			command=scan.nextLine();
		}
		for(int i=0;i<n;i++)
		{
			System.out.print(i+":"+" ");
			if(blocks[i].val==0)
				System.out.println();
			else if(blocks[i].queue.isEmpty())
			{
				System.out.println(i);
			}
			else
			{
				while(!blocks[i].queue.isEmpty())
				{
					System.out.print(blocks[i].queue.removeFirst());
				}
				System.out.println();
			}


		}

	}
}
