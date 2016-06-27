import java.util.ArrayList;
import java.util.HashMap;


public class DirectoryListing2 {

	static int leng(String s)
	{

		HashMap<String,Integer> hash=new HashMap<String,Integer>();
		DirectoryListing2 root=null;

		ArrayList <Integer> found=new ArrayList<Integer>();
		String prevL="";
		int spaces=0,prevSpace=0;

		int len=0;

		String[] val=s.split("\n");
		for(int i=0;i<val.length;i++)
		{
			
			System.out.println(val[i]+" "+spaces);
			spaces = val[i].length() - val[i].replace(" ", "").length();
			
			if(spaces==0) //new root;
			{
				hash.put(val[i],val[i].length()+1);
				prevSpace=0;


			}

			else if(spaces>prevSpace)  //new child
			{
				System.out.println("Prev "+prevL);
				
				int parentLength=hash.get(prevL)-prevSpace;
				hash.put(val[i], parentLength+val[i].length()+1-spaces);

				if(val[i].endsWith("jpeg")||val[i].endsWith("jpg") ||val[i].endsWith("gif"))
				{
					len+=hash.get(prevL)+val[i].length();
					System.out.println("len="+len);
					for(i=i+1;i<val.length;i++)
					{
						//scan till next 
						spaces = val[i].length() - val[i].replace(" ", "").length();
						System.out.println(spaces+" "+val[i]);
						if(spaces<prevSpace)
						{
							
							i=i-1;
							
							
							break;
						}
					}
				}
				prevSpace=spaces;

				
			}
			else
			{
				//preVal has the value of the parent+itself  so subtract value of that
				hash.put(val[i], hash.get(prevL)+ val[i].length()+1-prevL.length()+val[i].length()+1-spaces);
			}
			if(i<val.length)
			prevL=val[i];
			//System.out.println(val[i]+" "+spaces+" "+prevSpace);
			System.out.println("-------------------");
		}
		return len;
	}
	public static void main(String[] args)
	{

		String directory="dir1\n dir11\n dir12\n  picture.jpg\n  dir121\n   films.gif\ndir2\n po.jpg";
		System.out.println(leng(directory));
	}
}
