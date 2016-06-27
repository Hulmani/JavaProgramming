import java.util.Scanner;


public class JillRides {

	static String calculateMaximalDP(int[][] maximal,int r)
	{
		int maximalVal=0;
		int source=maximal.length;
		int longestCycle=0;
		int destination=0;
		for(int i=1;i<maximal.length;i++)
			
			
			{
			for(int j=i;j<maximal.length;j++)
			
			{
				
				if(i!=j)
				{
					 //the prev sum val
					
					maximal[i][j]=maximal[i][j-1]+maximal[j][j]; // include the next productt val
				
				}
				
				if(maximalVal<=maximal[i][j])
				{
					
					if(maximalVal==maximal[i][j])
					{
					//	System.out.println("Maximal is equal "+maximalVal);
						
						// System.out.println("Longest Cycle "+longestCycle+" "+j+" "+i);
						
					if(longestCycle<=(j-i))
					  {
						
						//longest cycle  is equal to cur 
						  if(longestCycle==(j-i))
						  {
							  //System.out.println("LongestCycle is  equal "+(j-i) );
							  //System.out.println("earliest Stop"+source); 
						     
							  
							  //since the ith source is earlier update source and destination 
							 if(source>=i)
						     {
						    	// System.out.println("earliest Stop and dest changed to  "+i +" "+j );
						    	 //earliestStop=i; 
						    	
						    	 //if(source>i)
						    	 source=i;
						    	 
						    	 //if source is equal and logest cycle is equal -its the same destination
						    }
							 
							 
							 //else
								// System.out.println("Longest cycle is equal but  Not changed  "+i +" "+j );
							 //retains prev source and destination if the source is not earlier 
							
						 }
						  //System.out.println("LongestCycle from" +i+" to "+(j+1));  
						  
						//source and destination changes because it has longer cycle 
					else  
						{
					   	source=i;
						 longestCycle=j-i;
						 destination=j; 
						
						// System.out.println("-----------"+longestCycle+" src and dest "+i +" "+j );
						}
					  }
					}
					
					
					
					
					// when maximalVal>prev maximMum value
					else
					{
						
						source=i;
						destination=j;	
						maximalVal=maximal[i][j];
						longestCycle=j-i;
						//System.out.println("Maximal is less "+maximalVal+" "+ source+" "+destination);
					}
					
				
					//System.out.println(maximalVal+" "+longestCycle+ " "+source +" "+destination);
				}
				
					
			}
			  //for the  next source 
			}
		String result=null;
		if(maximalVal>0) result= "The nicest part of route "+r+" is between stops "+source+" and "+(destination+1);
		else
		result="Route "+r+" has no nice parts";
		
		
		return result;
	}
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		int routeNo=scan.nextInt();
		String[] strings=new String[routeNo+1];
		for(int r=1;r<=routeNo;r++)
		{
			int maximalVal=0;
			int stopNo=scan.nextInt();
			int[][] maximal=new int[stopNo][stopNo];
			for(int s=1;s<stopNo;s++)
			{
				//maximal[s]=new int [stopNo];
				
				int niceness=scan.nextInt();
				maximal[s][s]=niceness;
//				if(niceness >maximalVal)
//				maximalVal=niceness;
				
			}
			//System.out.println(maximal.length);
			strings[r]=calculateMaximalDP(maximal,r);
			
			maximal=null;
		}
		
		for(int i=1;i<strings.length;i++)
			System.out.println(strings[i]);
	}
}
