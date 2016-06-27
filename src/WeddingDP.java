//The Input
//The first line of the input contains an integer, N, indicating the number of test cases. 
//For each test case, some lines appear, the first one contains two integers, M and C, 
//separated by blanks (1<=M<=200, and 1<=C<=20), where M is the available amount of money and C is the number of garments you have to buy.
//Following this line, there are C lines, each one with some integers separated by blanks; in each of these lines the first integer, 
//K (1<=K<=20), indicates the number of different models for each garment and it is followed by K integers indicating the price 
//of each model of that garment.

//The Output
//For each test case, the output should consist of one integer indicating the maximum amount of money necessary to buy one element 
//of each garment without exceeding the initial amount of money. If there is no solution, you must print "no solution".



import java.util.Scanner;


public class WeddingDP {

	public static void main(String[] args)
	{
		int capAmount=3,garments;
//				int [][]items={ 
//						{0,0,0,0,0},
//						{ 0,8, 6, 4},
//						{ 0,6, 10},
//						{0,7, 3, 1, 7},
//						{ 0,50 ,14, 23, 8},
//						//{0,4,5,6,8}
//				};


		Scanner scan=new Scanner(System.in);
		int test_cases=scan.nextInt();
		for(int t=0;t<test_cases;t++)
		{
			//	maxPossible=0;
			//System.out.println(capAmount);
			capAmount=scan.nextInt();

			garments=scan.nextInt();
			int[][] items=new int[garments+1][];
			int[][] cost=new int[garments+1][200+1];
			int brands=0;
			items[0]=new int[201];
			//System.out.println(items[0][201]);
//			for(int o=0;o<201;o++)
//			{
//				System.out.println(items[0][o]);
//			}
			for(int j=1;j<=garments;j++)
			{

				brands=scan.nextInt();
				items[j]=new int[brands+1];
				for(int k=1;k<=brands;k++)
					items[j][k]=scan.nextInt();
			}

			int maxPossible=0;
			for(int i=1;i<=items.length-1;i++)
			{
				//System.out.println("Brands for "+i+"th item "+items[i].length);
				for(int j=1;j<=items[i].length-1;j++)
				{
					if(i==1)
					{
					//	System.out.println(items[i][j]);
						cost[i][items[i][j]]=1;
					}
					else
					{
						for(int k=0;k<=200;k++)  		
						{

							if(cost[i-1][k]==1)  // if for the given  price the previous item can be taken
							{
								if(items[i][j]+k<=capAmount)
								{cost[i][items[i][j]+k]=1;		// 	then the prev price +current price can be taken for these items
								//System.out.println((items[i][j]+k)+" can be taken "+ "k:"+k+"  items price:"+items[i][j]+" i:"+i);
								if (i == items.length - 1) 
									maxPossible=(items[i][j]+k>maxPossible)?items[i][j]+k:maxPossible;
								}
							}

						}
					}

				}
			}		
			if(cost[items.length-1][capAmount]==1)
				System.out.println(capAmount);
			else
			{
				if(maxPossible>0)
					System.out.println(maxPossible);
				else
					System.out.println("no solution");

			}

		}
	}
}
