import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class MaxVendor {
	
	static int[] findMax(int[][] vendors)
	{
		HashMap<Integer,Integer> hashMapItemsCount=new HashMap<Integer,Integer>(); //index -> item
		
		
		HashMap<Integer,HashMap> hashMapVendorIdsItem=new HashMap<Integer,HashMap>(); //vendor id to items in hashMap
		
		//HashMap<Integer,Integer> maxRepeatedItemList=new HashMap<Integer,Integer>();
		//maxRepeatedItemList.addLast(0);
		int top=0;
		int count=0,maxCount=0;
		int vendorId=1;
	
		for(int[] vendor: vendors)  //traversing the vendors
		{
			
			HashMap<Integer,Integer> hashMapItems=new HashMap<Integer,Integer>(); //item -> 0 or 1
			
			for(int i: vendor)  	//traversing the items
			{
				hashMapItems.put(i, 1);
				//hashMapItemVendorIds.put(i, );
			
				if(!hashMapItemsCount.containsKey(i))  
				{
					count=1;
					hashMapItemsCount.put(i, 1);
					
				}
				else
				{
					count=hashMapItemsCount.get(i)+1;
					hashMapItemsCount.put(i,count); //incrementing the count of item in the global list of items
					// System.out.println(i+" "+count);
					 
				}
				
				
				
				maxCount=(count>=maxCount)? count:maxCount;  // the most recent repeated max item
				
			}
			
			
			hashMapVendorIdsItem.put(vendorId,hashMapItems); 
			vendorId++;  //VendorId is assumed to be incremented order
			
		}
		
		
		int[] vendorsId=new int[vendors.length];
		int index=0;
		for(Integer item: hashMapItemsCount.keySet())
		{
			
			int itemCount= hashMapItemsCount.get(item); //key is the item 
			if(itemCount==maxCount)
			{
				for(Integer i: hashMapVendorIdsItem.keySet())
				{
				if(hashMapVendorIdsItem.get(i).containsKey(item))
				   vendorsId[index]=i;
				
				index++;
				}
				System.out.println("Product "+item  +" Repeated "+itemCount);
			}
		}

	//	System.out.println(vendorsId.length);
		return vendorsId;
	}
	
		

	public static void main(String[] args)
	{
			int [][] vendors={{1,2,3},   //id=1
							  {1,2,3,4},//id =2
							  {4,5,2,6,3},	//id=3
							  {1,2,3 },//id=4
								
							  {3,2,4,5} //id=5
			};
			
			int[] max=findMax(vendors);
			for(int i:max)
			{
			if(i>0)	System.out.println("VendorId :"+i);
			}
	}
}
