/*
 * Complete the function below.
 */
class TimeDifference2{
    static int getMinTimeDifference(String[] times) {
        int l=times.length;
        int minDiff=Integer.MAX_VALUE;
            int[] val=new int[l];
            int cur=0;
            int total=0;
            int zeroIndex[]=new int[l];
            for(String i:times)
                        {
                      //  //System.out.println(i);
                        String[] vals= i.split(":");
                        int hrs=Integer.parseInt(vals[0]);
                        int min=Integer.parseInt(vals[1]);
                        if(hrs==0)
                        {
                            total=min;
                            zeroIndex[cur]=1;
                        }
                            else 
                                hrs=hrs*60;
                       
                       
                        total =hrs+min;
                        //System.out.println(hrs+" "+min+" "+total);
                        //System.out.println("---------------");
                        val[cur]=total;
                cur++;
               // minDiff=Math.min(minDiff,total);
                
                    }
        
        for(int j=0;j<l-1;j++)
            {
            for(int k=j+1;k<l;k++)
                {
            	int diff=0, diff1=0,diff2=0;
            	
            	if(zeroIndex[k]==1 && zeroIndex[j]==1)
             	{
             		 diff1=Math.abs(val[j]-val[k]);
             		 diff2=Math.abs(val[j]-val[k]);
             		diff=Math.min(diff1, diff2);
             		
             	}
            	else if(zeroIndex[k]==1 || zeroIndex[j]==1)
            	{
            		//System.out.println("-------------");
            		
            		if(zeroIndex[k]==1)
            		 {
            			
            			//System.out.print("1 ="+val[k]+" ");	
            		  diff1=Math.abs(val[j]-val[k]);  //00 
            		  diff2=Math.abs(val[j]-(val[k]+24*60)); // 24
            		 
            		 }
            		 
            		 //j is 00
            		 else {
            			 //System.out.print("1 ="+val[j]+" ");	
            		  diff1=Math.abs(val[k]-val[j]);  //00 
            		  diff2=Math.abs(val[k]-(val[j]+24*60)); // 24
            		  
            		 }
            		//System.out.println(val[j]+" "+val[k]+" "+diff1+" "+diff2);
            		 diff=Math.min(diff1, diff2);
            		 
            		 
            			//System.out.println("+++++++++++++++++++++++++++++++++++");
            	}
            	
            	
            	else
            		{ diff=Math.abs(val[j]-val[k]);
                   
            		}
            	
            	//System.out.println(diff+" between "+val[j] +"& "+val[k]);
            	
            	 minDiff=Math.min(minDiff, diff);
                    
                }
            }
       
        
return minDiff;
    }


public static void main(String[] args)
{
	String[] times={"10:00","19:20","06:45","00:12","24:13","23:50","04:22"};
	System.out.println("Min Diff="+getMinTimeDifference(times));
}
}