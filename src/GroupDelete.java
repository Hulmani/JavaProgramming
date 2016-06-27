
public class GroupDelete {

		static int removeDigitLsb(int X)
		{
			int i=1;
			int rightMostDigit=1;
			int prev=10; // a 2 digit number
			int prev_group=0,group=1;
			int place=0;
			int inputValue=X;
			if(X==0 ) return 0;
			boolean found=false;
			
			while(X>0)
			{
				rightMostDigit=X%10; //lsb
				X=X/10;
				if(i==0) prev=rightMostDigit;

				if(prev==rightMostDigit)
				{
					found=true;			//found atleast one group
					group++;
					place=i;
				}
				else
				{
					prev=rightMostDigit;
					if(group>=2)   //record only if there was a group
						prev_group=group;
					//System.out.println(place+" prev group="+prev_group);
					group=1;
				}
				i++;
			}
			
			//System.out.println((place-prev_group)+" "+prev_group );
			
			int lsb=place-prev_group+1;  				 //place holder of lsb to be removed
			int leftPart=(int)(inputValue/Math.pow(10,lsb));
			int rightPart=(int) (((int) (inputValue-(leftPart*Math.pow(10,lsb))))%Math.pow(10,lsb-1));


			int total=(int) ((int) leftPart*Math.pow(10,lsb-1)+ rightPart);
			//System.out.println(place+" "+prev_group+" "+lsb+" "+leftPart+" "+rightPart+ " "+total);
          
			if(!found) return inputValue;
			
           else  return total;
		}
	
		
		
	public static void main(String[] args){
		
        System.out.println(removeDigitLsb(985410111));
        System.out.println(removeDigitLsb(99876644)); 
        System.out.println(removeDigitLsb(9876543));
        System.out.println(removeDigitLsb(3333884));
        System.out.println(removeDigitLsb(22334455));
        System.out.println(removeDigitLsb(875566));
        System.out.println(removeDigitLsb(7566));
        System.out.println(removeDigitLsb(556));
        System.out.println(removeDigitLsb(1));
		
	}
}
