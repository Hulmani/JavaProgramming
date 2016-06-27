import java.util.LinkedList;
import java.util.Scanner;


public class Encode {
	static LinkedList <LinkedList> list=new LinkedList <LinkedList>() ;

	public static LinkedList merge()
	{
		return null;

	}

	public static void addTolist(String str)
	{
		LinkedList<Character>  ref=null;
		LinkedList<Character> add=null;
		boolean match_one=false;
		if(list.isEmpty()){	
			LinkedList<Character> l=new LinkedList<Character>(); 
			for(char c:str.toCharArray())
				l.add(c);

			list.add(l);
		}		// Linked List is created for first time


		else{
			LinkedList<Character> stack=new LinkedList<Character>(); //stack to push the elements which do not match 
			for(int i=0;i<list.size();i++)	// traverse all the lists
			{
				ref=list.get(i);
				for(int j=0;j<str.length();j++)
				{ 		//for each character - see if its in list 
					// if it is then we empty the queue and add to the list
					char c= (char) str.charAt(j);
					System.out.println("c is "+c);
					if(!ref.contains(c))
					{
						System.out.println("Does not contain "+ " "+c +" "+j);
						stack.addFirst(c);

					}
					else
					{
						match_one=true;					// atleast one matched then one of old lists is modified


						while(!stack.isEmpty())
						{
							char d= stack.removeLast();
							System.out.println("Adding "+d);
							ref.addFirst(d);

						}
					}

					if(match_one && j!=str.length()-1) //the string has to exhausted or  the rest of the string should match the elements in the linked list
					{
						boolean flag=false;
						for(j=j+1;j<str.length();j++)
						{
							char e=str.charAt(j);
							if(!ref.contains(e))
							{
								if(j!=str.length()-1 &&!flag)
								{
								System.out.println("ambiguous");
								System.exit(0);
								}
								else
								{
									flag=true;
									ref.addLast(e);
								}
							}
							
						}
					}//if one is matched
				}//j-for each character

			}//i-has lists

			if(!match_one)
			{
				add=new LinkedList();
				while(!stack.isEmpty())
				{
					char d= stack.removeFirst();
					System.out.println("New Lst "+d);
					add.addFirst(d);
				}

			}//matched one 


	

		list.add(add);
	}//else

	System.out.println("end");
}





public static void main(String [] args)
{


	System.out.println("Enter the details");
	Scanner scan=new Scanner(System.in);
	int n=scan.nextInt();
	LinkedList  l=null;
	while(n!=0)
	{
		int i=0;
		while(i<n){
			String str=scan.next();

			addTolist(str);

			i++;}//i<n

		n=scan.nextInt();
		list=new LinkedList <LinkedList>() ;
	}



}
}
