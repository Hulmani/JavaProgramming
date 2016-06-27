import java.util.LinkedList;


public class LinkedListOperations {


	 

		public static void main(String args[])
	    {
	    LinkedList<Integer> list=new LinkedList<Integer>();
	    for(int i=0;i<10;i++)
	    list.add(4);
	    
	    System.out.println(list);
	    int j=4;
	   // for(int j=0;j<10;j++)
	    //{
	    	while(list.contains(j))
	    		list.remove(j);
	    //}
	        System.out.println(list);

	    }
	
}
