import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;


public class ParkingSimulation2 {

	static HashMap<Integer,Boolean> hash=new HashMap<Integer,Boolean>();

	static void intialize(int n)
	{

		for(int i=1;i<=n;i++)
		{

			hash.put(i, true);
		}
	}
	static void printAvailable()
	{
		System.out.println();
		System.out.println("Available spots");

		System.out.println("----------------------");
		for(Integer key:hash.keySet())
		{
			if(hash.get(key))
			{
				System.out.print( key+ " ");
			}

		}
		System.out.println();
		System.out.println("----------------------");

		System.out.println();

	}

	public static void main(String[] args)
	{

		Scanner scan=new Scanner(System.in);

		System.out.println("Enter the number of parking spaces");
		int totalSpaces=scan.nextInt();
		intialize(totalSpaces);

		int controlSpaces=totalSpaces;

		while(true)
		{
			printAvailable();
			System.out.println("Enter any key if car enters or  0 when car exists");
			String status=scan.next();


			
			if(status.equals("0"))
			{

				if(controlSpaces==totalSpaces)
					System.out.println("No car parked");
				else
				{
					boolean valid=false;
					while(!valid)
					{
						System.out.println("Enter which spot was freed");
						int spot=scan.nextInt();
						if(hash.get(spot))
						{
							valid=false;
							System.out.println("Spot was not occupied");
						}
						else
						{
							valid=true;
							hash.put(spot, true);
							controlSpaces++;
							System.out.println("Shutter Open, please exit");
						}
					}
				}
				

			}


			else
			{	
				printAvailable();
				if(controlSpaces==0)
					System.out.println("Parking space full");

				else
				{	
					boolean valid=false;
					while(!valid)
					{
						System.out.println("Enter the spot number you wish to park");
						int spot=scan.nextInt();

						if(!hash.get(spot))
						{
							valid=false;
							System.out.println("Spot occupied");
						}


						else
						{
							valid=true;
							hash.put(spot, false);
							controlSpaces--;
							System.out.println("Shutter open, please park the car");
						}
					}
				}
				
			}
			System.out.println("Spaces remaining "+controlSpaces);
			//printAvailable();
			//System.out.println();
		}


	}
}
