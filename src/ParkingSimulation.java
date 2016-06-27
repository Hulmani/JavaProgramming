import java.util.Scanner;


public class ParkingSimulation {

	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);

		System.out.println("Enter the number of parking spaces");
		int totalSpaces=scan.nextInt();

		int controlSpaces=totalSpaces;

		while(true)
		{
			System.out.println("Enter any key if car enters or  0 when car exists");
			String status=scan.next();

			if(status.equals("0"))
			{

				if(controlSpaces==totalSpaces)
					System.out.println("No car parked");
				else
				{
					controlSpaces++;
					System.out.println("Car Exited");
				}
				System.out.println("Spaces remaining "+controlSpaces);

			}


			else
			{	if(controlSpaces==0)

				System.out.println("Parking space full");

			else
			{	
				controlSpaces--;
				System.out.println("Car Parked");
			}
			System.out.println("Spaces remaining "+controlSpaces);
			}
			System.out.println();
		}


	}
}
