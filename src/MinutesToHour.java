
public class MinutesToHour {

	static void hour(int[] minutes)
	{
		for(int i: minutes)
		{
			int j=(int)i/60;
			int k=i%60;
		System.out.println(j+":"+k);
		}
	}
	
	public static void main(String[] args)
	{
		int[] minutes={600,1160,405,1452,1430,262};
		hour(minutes);
		
	}
}
