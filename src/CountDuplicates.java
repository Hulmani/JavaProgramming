import java.util.ArrayList;
import java.util.HashMap;


public class CountDuplicates {

	
	
	static int countDuplicates(int[] numbers) {
        
        HashMap<Integer,Integer> hash =new HashMap<Integer,Integer>();
            ArrayList<Integer> r=new ArrayList<Integer>();
          
            int count=0;
            int repeatedNumbers=0;
            for(int val:numbers)
            {
            //contains all unique numbers
            if(!hash.containsValue(val))
                {
                hash.put(count++,val);
               
            }
                // if a number is not found then adds to ArrayList
                else
                    {
                	if(!r.contains(val))
                	{
                		r.add(val);
                    repeatedNumbers++;
                    //repeatedNumbers.add(val);
                	}
                }
                
        }
    return repeatedNumbers;
}
	
public static void main(String[] args) {

		
		int a[]={1,2,3,4,8,8,3,4,7,9,0,8,1,3,5,7};
		//1 3 4 8  7
		System.out.println(countDuplicates(a));
	}
}
