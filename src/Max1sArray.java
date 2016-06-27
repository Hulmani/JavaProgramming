
public class Max1sArray {

	static int max1s(int[][] m,int i,int j)
	{
		int max=0;
		if(i==m.length||i<0 ) return max;

		if (j==m[i].length|| j<0)  return max;


		if(m[i][j]==1)
		{
			max=1;
			System.out.println(i+ " "+j);
			m[i][j]=0;	
			max+=max1s(m,i,j-1);//look left
			max+=max1s(m,i,j+1);  //look right
			max+=max1s(m,i+1,j); //look down
			max+=max1s(m,i+1,j+1); //look  right  down diagonal
			max+=max1s(m,i-1,j-1); //look left up  diagonal
			max+=max1s(m,i+1,j-1); //look left down diagonal
			max+=max1s(m,i-1,j+1); //look right up  diagonal
			
			
			return max;
		}
		else { return max;}
		//					
		//					max=0;
		//					
		//					max+=max1s(m,i,j+1);
		//					max+=max1s(m,i+1,0);
		//						
		//					//return max;
		//				}
		//
		//			

		//		if(m[i][j]==1) max++;
		//		else max1s(m,i,j+1,max);
		//		
		//		if(valAt(m,i,j+1)==1) { max++;	setTo0(m,i,j+1);}//look right
		//		if(valAt(m,i+1,j)==1) { max++;  setTo0(m,i+1,j);} //look down
		//		if(valAt(m,i+1,j+1)==1){max++;  setTo0(m,i+1,j+1); } //look  right diagonal
		//		if(valAt(m,i-1,j-1)==1){max++;	setTo0(m,i-1,j-1);} //look left diagonal

		//return max;

	}

	static void setTo0(int[][]m,int i,int j)
	{
		if(i<m.length&&j<m[i].length)
			m[i][j]=0;

	}
	static int valAt(int[][]m,int i,int j)
	{
		if(i<0 || j<0 )return 0;
		if(i<m.length && j<m[i].length)
			return m[i][j];
		else return 0;
	}

	public static void main(String[] args)
	{
		int[][] m={ {0,1,0,1},
					{1,0,1,1},
					{0,0,1,1},
					{0,0,1,1},
		};
		int max=0;
		for(int i=0;i<m.length;i++){
			
			for(int j=0;j<m[i].length;j++)
			{
				//if(m[i][j]==1)
				
					int newMax=max1s(m,i,j);
					System.out.println("Run "+newMax);
					max=Math.max(max,newMax);
					
			}
		}
		System.out.println(max);
	}
}
