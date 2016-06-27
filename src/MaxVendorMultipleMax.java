import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class MaxVendorMultipleMax {
	
	static Object[] findMax(int[][] vendors)
	{
		HashMap<Integer,Integer> hashMapItemsCount=new HashMap<Integer,Integer>(); //index -> item
		
		
		HashMap<Integer,HashMap> hashMapVendorIdsItem=new HashMap<Integer,HashMap>(); //vendor id to items in hashMap
		
		//ArrayList<Integer> maxCountItems=new ArrayList<Integer>();
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
				
				
				
				if(count>=maxCount)  
				{
					
//					if(maxCount==count)
//					{
//						maxCountItems.add(i);
//					}
//					else
//					{
//						maxCountItems.clear();     //maxCount increased hence all the previous items are removed
//						maxCountItems.add(i);
//					}
					maxCount=count;
				}
			}
			
			
			hashMapVendorIdsItem.put(vendorId,hashMapItems); 
			vendorId++;  //VendorId is assumed to be incremented order
			
		}
		//for(int items:maxCountItems)
			//System.out.println(" List "+items);
		
		System.out.println("max count"+maxCount);
		ArrayList<Integer> vendorsId=new ArrayList<Integer>();
		//int index=0;
		for(Integer item: hashMapItemsCount.keySet()) 
		{
			
			int itemCount= hashMapItemsCount.get(item); //key is the item 
			
			if(itemCount==maxCount)  // for each item that has the max Count
			{
				System.out.println("Item="+item +"count="+itemCount);
				for(Integer i: hashMapVendorIdsItem.keySet())  
				{
				if(hashMapVendorIdsItem.get(i).containsKey(item))
				{
					//System.out.println("id="+i+" index="+index);
				  if(!vendorsId.contains(i))
					vendorsId.add(i);
				}
				
				}
				System.out.println("Product "+item  +" Repeated "+itemCount);
			}
		}

	int[] ids;
		//	System.out.println(vendorsId.length);
		 return vendorsId.toArray();
		 
	}
	
		

	public static void main(String[] args)
	{
			int [][] vendors={{1},   //id=1
							  {1,2,4},//id =2
							  {4,5,2,6,3},	//id=3
							  {1,2,3 },//id=4
								
							  {3,4,2,5}, //id=5
							  
						       {4,2}, //6
							  {1,3,6,8}, //7
						       //{1},
						       //{1},
			};
			
			Object[] max=findMax(vendors);
			System.out.println(max.length);
			for(Object i:max)
			{
				System.out.println("VendorId :"+i);
			}
	}
}
