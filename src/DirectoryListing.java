


public class DirectoryListing {

	String name;
	int length;
	int spaces;
	DirectoryListing(String m)
	{
		name=m;
	}
	
	static int getLength(DirectoryListing[] nodes,int spaces,int i)
	{



		int len=0;
		

		if(i<0) return 0;



		if(nodes[i].spaces==spaces)
		{
			//System.out.println("p:"+nodes[i].name+" "+spaces);
			spaces--;
			len+=nodes[i].length + getLength(nodes,spaces,i-1);

			
		}

		else
		{
			//System.out.println("np:"+nodes[i].name);
			len=getLength(nodes,spaces,i-1);
		}


		return len;
	}


	static int leng(String s)
	{
		String[] val=s.split("\n");
		DirectoryListing[] nodes=new DirectoryListing[val.length];
		int len=0;
		int levelDone=Integer.MAX_VALUE;
		int spaces=0;

		for(int i=0;i<val.length;i++)				//index using spaces
		{
			int l=val[i].length();
			spaces=l-val[i].replace(" ", "").length();
			nodes[i]=new DirectoryListing(val[i]);
			nodes[i].spaces=spaces;
			nodes[i].length=l+1-spaces;  //includes '/'

			//System.out.println("j:"+val[i]+" "+nodes[i].length);
			
			if(spaces==0)
			{
				levelDone=Integer.MAX_VALUE;
			}
			if(spaces>levelDone)				//level
			{
				//System.out.println("not proc:"+val[i]+" "+nodes[i].length+" "+spaces);
				continue;
				// skip the other levels if a image is found
			}
			else
			{

				if(val[i].endsWith("jpeg")||val[i].endsWith("jpg") ||val[i].endsWith("gif"))  //the given file extensions
				{
					int absolutePath=getLength(nodes,spaces-1,i-1)+  nodes[i].length;
					//System.out.println("------al="+absolutePath);
					len+=absolutePath;          //getLenth of the absolute path	

					levelDone=spaces;    		//level that is done 

				}

			}

		}

		//System.out.println("-------------------");
		return len;
	}


	public static void main(String[] args)
	{

		String directory="dir1\n dir11\n dir12\n  picture.jpg\n  pice.jpg\n  dir121\n   films.gif\ndir2\n po.jpg";
		System.out.println(leng(directory)); 
		directory="dir1\ndi2";
		System.out.println(leng(directory));
		directory="dir1\n pic.jpg\n p.gif";
		System.out.println(leng(directory));
		directory="dir1\n pic.jpg\n dir12\n  poi.jpeg\ndir2\n dir21\n  l.jpeg\n  dir212";
		System.out.println(leng(directory));
		directory="dir1\n pic.jpg\n dir12\n  poi.jpeg\ndir2\n dir21\n  l.jpeg\n  dir212";
		System.out.println(leng(directory));
	}
}
