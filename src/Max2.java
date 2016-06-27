
public class Max2 {

	
	public static void main(String[]args)
	{
		int []myArray={7,8,9,2,3,4,5,9};
		 int max=Math.max(myArray[0],myArray[1]);
		    int max2=Math.min(myArray[0],myArray[1]);
		    for(int i=2;i<myArray.length;i++)
		        {
		    		if(max<myArray[i])
		    		{
		    			max2=max;
		                max=Math.max(max,myArray[i]);
		    		}
		            if(max2<myArray[i] && myArray[i]!=max)
		            max2=Math.max(max2,myArray[i]);
		              
		            }
		        
		  
		System.out.println(max2);
	
		   for(int i=0;i<14;i++)
		   {   for(int j=0;j<7;j++)
		          {
		      System.out.print("/"+"\\");
		                  }
		   System.out.println();
		  } 
		
		   for(int i=1;i<=10;i++)
		   {   for(int j=1;j<=10-i;j++)
		            System.out.print(" ");
		    if(i==1)
		    {
		    	 System.out.println("*");
		    	 for(int j=1;j<=10-i;j++)
			            System.out.print(" ");
		    	 System.out.print("0");
		    }
		    else 
		    {
			   for(int k=1;k<=2*(i-1)+1;k++) 
				   System.out.print("0");
		    }
		    System.out.println();
		  }
		   }
	
	
}
