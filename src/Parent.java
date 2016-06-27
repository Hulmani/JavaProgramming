//Input will consist of multiple test cases. The first line of the input will contain a single integer indicating the
// number of test cases. Each test case starts with a single line containing
//two positive integers n and d, where n indicates the number of lines to follow containing information about the family tree, 
//and d indicates the specific question being asked about the tree: 
//if d = 1, then we are interested in persons with the most children (1 generation away); 
//if d = 2, then we are interested in persons with the most grandchildren (2 generations away), and so on. T
//he next n lines are of the form 
//name m dname1 dname2 ... dnamem 
//where name is one of the family members' names, m is the number of his/her children, 
//and dname1 through dnamem are the names of the children. These lines will be given in no particular order. 
//You may assume that all n lines describe one single, connected tree. 
//There will be no more than 1000 people in any one tree, and all names will be at most 10 characters long.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Parent {
	HashMap <Parent,Integer> children;
	String name;
	int count;
	ArrayList<Integer> childrenCount;
	public Parent(String n){
		name=n;
		count=0;
		children=new HashMap<Parent,Integer>();	
		childrenCount=new ArrayList<Integer>();
	}

	public String getName()
	{
		return name;
	}
	public void addChild(String child)
	{
		Parent childP=new Parent(child);
		children.put(childP,count++);
	}
	public void addChild(Parent p)
	{

		children.put(p,count++);
	}
	public void removeChild(Parent p)
	{

		children.remove(p);
	}

	public HashMap<Parent,Integer> getChildren()
	{
		return this.children;
	}

	public int getCount()
	{
		return this.count;
	}

	public void printChildren(Parent p)
	{

		for(Parent key:children.keySet())
		{
			System.out.print(key.getName()+" ");
		}

		System.out.println();

	}

	
	static ArrayList<Integer> calculateAncestorTree(Parent p)
	{
		
			//System.out.println(p.getName()+" "+p.children.size() );

			ArrayList<Integer> countChildren=new ArrayList<Integer>();
			countChildren.add(p.children.size());
			
			if(p.children.size()==0){
			p.childrenCount=countChildren;	
			return countChildren;
			}
			
		
			for(Parent key:p.children.keySet())
			{
				//System.out.println(key.getName());
				
				ArrayList<Integer> each=calculateAncestorTree(key);
				
				for(int i=0;i<each.size();i++)
				{
					if(countChildren.size()>i+1)
					countChildren.set(i+1,countChildren.get(i+1)+each.get(i));  //i=0 has its children
					else
						countChildren.add(each.get(i));
				}
				
			}
//			System.out.println(p.getName());
//			for(int i: countChildren)
//				System.out.print(i+" ");
//			System.out.println();
//			System.out.println("----------------------------");
			p.childrenCount=countChildren;	
			return countChildren;
			

		
		////System.out.println();

	}

	
	static void printIfChildren(Parent p,int n)
	{
		
		p.childrenCount=calculateAncestorTree(p);
		ArrayList<Integer> m=p.childrenCount;
		//System.out.println(n);
		if(n<m.size())
		System.out.println(p.getName()+":"+m.get(n-1) );
		
		for(Parent key:p.children.keySet())
		{
			printIfChildren(key,n);
		}
		
	}

	static void printChildrenAll(Parent p)
	{
		if(p.children.size()>0)
		{
			System.out.println(p.getName());

			for(Parent key:p.children.keySet())
			{
				System.out.print(key.getName()+" ");
			}
			System.out.println();
			System.out.println("--------------------");
			//System.out.println();

			for(Parent key:p.children.keySet())
			{
				printChildrenAll(key);
			}
		}
		////System.out.println();

	}

	static Parent getParentR(HashMap<Parent,Integer> list, String parent)
	{

		Parent p=new Parent("");
		//System.out.println("Children ");
		for(Parent key:list.keySet())
		{
			//System.out.println(key.getName());
		}

		//  search all the children 

		////System.out.println("Contains : Searching "+parent);	
		for(Parent key:list.keySet())
		{

			if(key.getName().equals(parent))  //the parent name matches
			{

				return key;
			}
		}


		//depth search 
		//get each child and then search

		//System.out.println("Not found in immediate ");
		for(Parent key:list.keySet())
		{
			p=getParentR(key.getChildren(),parent);
			if(p.getName().equals(parent))
			{
				return p;
			}
		}
		////System.out.println("This should not be printed");
		return p;
	}

	static Parent getParent(HashMap<String,HashMap<Parent,Integer>> listTop,String parent )
	{

		HashMap<Parent,Integer> localList=null;
		Parent p=new Parent("");
		if(listTop.containsKey(parent))
		{	
			Parent pa=new Parent(parent);
			pa.children=(HashMap<Parent,Integer>) listTop.get(parent);

			return pa;
		}
		else
		{
			for(String key:listTop.keySet())
			{
				//System.out.println("Searching "+key +" size"+listTop.size());
				localList=(HashMap<Parent,Integer>) listTop.get(key);
				//depth first

				p=getParentR(localList,parent);
				//System.out.println("---------");

				if(p.getName().equals(parent)) 
				{
					//System.out.println("Parent "+p +" received parent "+parent);
					return p;
				}

				if(p.getName().equals("")) 
				{
					//System.out.println("Parent not found in the root "+key +" "+parent);
					//return p;
				}

				//System.out.println("----------------------------n");
			}

			//System.out.println("This should not be printed");

			return p; // should never return null cause parent exists somewhere
		}
	}



	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		for(int i=1;i<=t;i++)
		{
			int count=0;
			HashMap<String,Integer> listNames=new HashMap<String,Integer>();
			HashMap<String,HashMap<Parent,Integer>> listTop=new HashMap<String,HashMap<Parent,Integer>>();
			int n=scan.nextInt();
			int d=scan.nextInt();

			String parent="",child="";

			Parent p=null;
			Parent parentFound=null;



			for(int j=1;j<=n;j++)
			{
				boolean normal=true;
				parent=scan.next();  //parent name


				if(!listNames.containsKey(parent))  //simply lookup
				{
					p=new Parent(parent);
					//System.out.println("Put "+parent+" in list");
					listNames.put(parent,count++);  
					listTop.put(parent,p.getChildren());    //altough parent is assumed to be given only once!
					//we will add a parent if it has never seen before
					//cause if it not a super parent found

				}
				else
				{
					//find where the  parent is  to add the children to that specific hashMap
					normal=false;

					if(!listTop.containsKey(parent))  //it should not contain parents name repeated any way
					{								  //only children may be present as a parent

						// RECURSIVELY find the hasMap (childrenList) to put  the children directly to that hashMap		

						parentFound=getParent(listTop,parent);

					}

				}

				int m=scan.nextInt(); // number of children 
				for(int k=0;k<m;k++)
				{
					child=scan.next();
					if(!listNames.containsKey(child))  //child  is not found
					{
						//System.out.println("Put "+child+" in list");
						listNames.put(child,count++);


						if(normal)
						{
							//System.out.println("Children added normally");
							p.addChild(child);  //children name
						}
						else //add the child to the index of
						{
							//System.out.println(parent +" was found as a parent");
							Parent childP=new Parent(child);

							//childrenList.put(childP,childP.getCount()+1);

							parentFound.addChild(child);
						}

					}

					else  //child exists as a parent
					{
						//System.out.println("Child is already found");
						//parent must not have been found

						//get the parent reference of the child and add it to the parent;

						Parent c=getParent(listTop,child);
						//System.out.println("Parent found "+c.getName());

						p.addChild(c);
						//c.printChildren(c);
						//now the child and its children has been added as the children to the Parent

						//delete the parent from the listop so that,if one of the children, child is added in the future it gets added to the  
						// root parent (which contains the sub parent ) instead	
						if(listTop.containsKey(child))
							//System.out.println(child +" exixts");
							listTop.remove(child);
					}

				}



				//				if(!listNames.containsKey(parent))
				//				listTop.put(parent,p.getChildren());




			}
			System.out.println("Tree "+i );
			for(String key:listTop.keySet())
			{
				Parent root=new Parent(key);
				root.children=(HashMap<Parent,Integer>) listTop.get(key);;
				printIfChildren(root,d);

				//System.out.println();
			}
		}

	}
}
