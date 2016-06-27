import java.util.*;
public class CloudJump {
	
	public static int minJump(int[] c,int i)
	{
		int l=c.length;
		int val1=0,val2=0;
		if(i>=l-1) return 0;
		
			
			if(i+1<l && c[i+1]==0)
			{
				//System.out.println("-Going"+ (i+1));
				 val1= 1+minJump(c, i+1);
				 
			}
			if(i+2<l && c[i+2]==0)
			{
				//System.out.println("Going"+ (i+2));
				 val1= 1+minJump(c, i+2);
				// System.out.println("val2 "+val2);
			}
			
		
			//System.out.println("values "+val1+" "+val2);
			return (val1);
	}
	
	
	   public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int c[] = new int[n];
	        for(int c_i=0; c_i < n; c_i++){
	            c[c_i] = in.nextInt();
	        }
	       // int []c={0, 0 ,0 ,0 ,0 ,1, 0};
	        
	        System.out.println(minJump(c,0));
	    }


}
