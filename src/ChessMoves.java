import java.util.Scanner;


public class ChessMoves {
	
		public static String[] moves=new String[64];
	public static int findsteps(int x2,int y2,int x1,int y1,int steps)
	{
		
		if(x2==x1 && y2==y1)
		{
			//System.out.println("Reached Destination");
			
		
			return steps;
		}
		
		else if(x2-x1>0 && y2-y1>0)
		{
			
			//System.out.println("RU");
			moves[steps]="RU";
			steps=findsteps(x2,y2,x1+1,y1+1,++steps);
		}
		
		
		else if(x2-x1>0 && y2-y1<0)
		{
			moves[steps]="RD";
			//System.out.println("RD");
			steps=findsteps(x2,y2,x1+1,y1-1,++steps);
		}
		
		
		else if(x2-x1>0 && y2==y1)
		{
			moves[steps]="R";
			//System.out.println("R");
			steps=findsteps(x2,y2,x1+1,y1,++steps);
		}
		
		
		else if(x2-x1<0 && y2-y1>0)
		{
			moves[steps]="LU";
			//System.out.println("LU");
			steps=findsteps(x2,y2,x1-1,y1+1,++steps);
		}
		
		
		else if(x2-x1<0 && y2-y1>0)
		{
			moves[steps]="LD";
			//System.out.println("LD");
			steps=findsteps(x2,y2,x1+1,y1+1,++steps);
		}
		
		
		else if(x2-x1<0 && y2==y1)
		{
			moves[steps]="L";
			//System.out.println("L");
			steps=findsteps(x2,y2,x1-1,y1,++steps);
		}
		
		else if(x2==x1 && y2-y1>0)
		{
			moves[steps]="U";
			//System.out.println("U");
			steps=findsteps(x2,y2,x1,y1+1,++steps);
		}
		else
		{
			moves[steps]="D";
			//System.out.println("D");
			steps=findsteps(x2,y2,x1,y1-1,++steps);
		}
		return steps;
	}
		
		public static void main(String[] args)
		{
			int steps=0;
			//System.out.println((int)'a');
			Scanner scan=new Scanner(System.in);
			String source=scan.next();
			String dest=scan.next();
			int x1=(int)source.charAt(0)-96;//System.out.println(x1);
			int y1=(int)source.charAt(1)-'0';//System.out.println(y1);
			int x2=(int)dest.charAt(0)-96;//System.out.println(x2);
			int y2=(int)dest.charAt(1)-'0';//System.out.println(y2);
			
			
			
			steps=findsteps(x2,y2,x1,y1,steps);
			System.out.println(steps);
			for(int i=0;i<steps;i++)
				System.out.println(moves[i]);	
			System.out.println();
		}
}
