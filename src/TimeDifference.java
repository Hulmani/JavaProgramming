/*
 * Complete the function below.
 */
class TimeDiffernce{
	static int getMinTimeDifference(String[] times) {
		int l=times.length;
		int minDiff=Integer.MAX_VALUE;
		int[][] val=new int[l][l];
		int cur=0;
		for(String i:times)
		{
			//  System.out.println(i);
			String[] vals= i.split(":");
			int hrs=Integer.parseInt(vals[0]);
			if(hrs==0)
				hrs=24*60;
			else 
				hrs=hrs*60;
			int min=Integer.parseInt(vals[1]);
			int total=hrs+min;
			System.out.println(hrs+" "+min+" "+total);
			// System.out.println("---------------");
			val[cur][cur]=total;
			cur++;
			// minDiff=Math.min(minDiff,total);
			System.out.println(minDiff);
		}

		for(int j=0;j<l;j++)
		{
			for(int k=j+1;k<l;k++)
			{
				if(j==k) continue;

				else
				{
					val[j][k]=(int)Math.abs(val[j][k-1]-val[k][k]);  
					//System.out.println("diff"+val[j][k]);
					minDiff=Math.min(minDiff, val[j][k]);


				}
			}
		}

		return minDiff;
	}


	public static void main(String[] args)
	{

	}
}