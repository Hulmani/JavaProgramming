import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Fraud {

	
//	private static class minsComparator implements Comparator<String>{  
//		public int compare(Object o1,Object o2){  
//			Integer s1=(Integer)o1;  
//			Integer	 s2=(Integer)o2;  
//		  
//			if(s1==s2)  
//				return 0;  
//				else if(s1>s2)  
//				return 1;  
//				else  
//				return -1;  
//				}  
//			
//	}
	
	private  static class trans
	{
		String loc;
		int mins;
		
		trans(String loc,int mins)
		{
			this.loc=loc;
			this.mins=mins;
		}
	}
	

	
	 static String[] getSuspiciousList(String[] transactions) {
		  HashMap<String,trans> list=new HashMap<String,trans>();
			 HashMap<Integer,String> slist=new HashMap<Integer,String>();
		 for (String t:transactions)
		 {
			 String name="",location="";int mins=0,amount=0;
			 String[] tokens=t.split("\\|");
			 name=tokens[0];
			 amount=Integer.parseInt(tokens[1]);
			 location=tokens[2];
			 mins=Integer.parseInt(tokens[3]);
			// System.out.println(name+" "+amount+" "+location+" "+mins);
			 if(amount>3000)
			 {
				 slist.put(mins,name);
			 }
			
			 if(!list.containsKey(name))
			 list.put(name,new Fraud.trans(location,mins));
			 
			 else
			 {
				// System.out.println("Already Present");
				 trans p=list.get(name);						//cur mins > p.mins ordering
				 //System.out.println(p.loc+" "+p.mins);
				 if (!p.loc.equals(location) && (mins-p.mins<60))  //60 mins=1 hour 
				 {
					 if(!slist.containsValue(name))
					 slist.put(p.mins,name);
				 }
				 
				 list.put(name,new Fraud.trans(location,mins));
			 }
			  
		 }
		 Map<Integer, String> map = new TreeMap<Integer, String>(slist); 
       //  System.out.println("After Sorting:");
		 
		 
		 
		
         //return (String[]) map.values().toArray();
		 String [] names = new String[map.size()];
        int i=0;
		 Set set = map.entrySet();
         Iterator iterator= set.iterator();
         while(iterator.hasNext()) {
              Map.Entry m = (Map.Entry)iterator.next();
              //System.out.print(me2.getKey() + ": ");
             // System.out.println(me2.getValue());
             
            	 names[i++]=(String) m.getValue();
         }
//		 //Collections.sort(slist,new minsComparator());
//        
	 return names;
	    }
	 
	 
	
	 
//	public static void main(String[] args)
//	{
//		String[] t={"Krasi|9000|C|1230","Shilpa|500|California|1300","Matt|99999|Georgia|1305","k|99999|Georgia|1306","Shilpa|50|mic|1306"};
//		String names[]=getSuspiciousList(t);
//		for(String j:names)
//		System.out.println(j);
//	}
	
}
