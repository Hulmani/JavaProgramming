import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


public class RomanNumbers {
	static char[] symbols={'I','V','X','L','C','D','M'};
	static int[] values=  {1,5,10,50,100,500,1000};
	static HashMap<Character,Integer> hash=new HashMap<Character,Integer>();

	static LinkedList<Integer> queue=new LinkedList<Integer>();

	static  int  romanToDecimal(String r)
	{
		char[] c=r.toCharArray();
		int d=0;

		int curValue=0,prevValue=0;
		char cur,prev=' ';
		int times=0;
		prevValue=hash.get(c[c.length-1]);
		d=prevValue;
		System.out.println("First value "+prevValue);
		int l=c.length-2;
		queue.addFirst(prevValue);
		//Math.max(max, prevValue);



		for(int i=l;i>=0;i--)
		{
			cur=c[i];

			if(!hash.containsKey(cur))
			{
				System.out.println("Contains incorrect characters");
				return -1;
			}

			// calculating if the value exists, thus eliminating exception 
			curValue=hash.get(cur);


			times=prevValue/curValue;      // IL has no meaning  LC has no meaning
			System.out.println("Cuurent "+cur);
			
			if(curValue<prevValue)
			{
				System.out.println("times"+times);
				if(times!=10 && times!=5)				//IC has no meaning 
				{
					System.out.println("Roman Number Syntax is wrong");
					return -1;
				}
			
				queue.removeFirst();   // remove previous value cause it might a
				int value=prevValue-curValue;
				
				if(!queue.isEmpty())
				{
					//System.out.println("Top "+queue.element());
					//System.out.println(queue);
					if(queue.element()>value)
					{
						System.out.println(":Syntax wrong: trying to insert lesser value between");
						return -1;
					}
				}
				
				else
					queue.addFirst(value);

				d-=curValue;
				System.out.println("- "+d);
			}

			else
			{

				d+=curValue;
				System.out.println("+ "+d);
				if(queue.element()>curValue)
				{
						System.out.println("Syntax wrong: trying to insert lesser value between");
						return -1;
				}
				queue.addFirst(curValue);
				
			}

			


			prev=c[i];
			prevValue=hash.get(prev);
			System.out.println(queue);
		}
		return d;
	}

	static  String decimalToRoman(int n)
	{
		String r="";



		return r;

	}


	public static void main(String[] args)
	{


		for(int i=0;i<symbols.length;i++)
		{
			hash.put(symbols[i], values[i]);
		}
		int n=100;
		String r="IXL";
		System.out.println(romanToDecimal(r));
		//decimalToRoman(n);


	}
}
