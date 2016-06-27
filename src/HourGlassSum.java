import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



public class HourGlassSum {
//	static int[][] arr={
//		{1 ,1, 1, 0, 0, 0},
//		{0, 1, 0, 0, 0, 0},
//		{1 ,1, 1, 0 ,0 ,0},
//		{0, 0, 2, 4, 4, 0},
//		{0 ,0 ,0 ,2, 0 ,0},
//		{0 ,0, 1, 2, 4, 0}
//		};
	
	
	static int[][] arr={
	{-1, 1, -1, 0, 0, 0},
	{0 ,-1 , 0, 0, 0 ,0},
	{-1,-1 ,-1, 0 ,0, 0},
	{0 ,-9 , 2 ,-4,-4,0},
	{-7, 0, 0 ,-2, 0, 0},
	{0, 0 ,-1 ,-2 ,-4, 0}};
	
//	static int[][] arr={
//	{-1, -1, 0 ,-9 ,-2 ,-2},
//	{-2, -1, -6 ,-8 ,-2 ,-5},
//	{-1, -1, -1, -2, -3, -4},
//	{-1 ,-9 ,-2 ,-4 ,-4 ,-5},
//	{-7, -3, -3, -2, -9, -9},
//	{-1 ,-3 ,-1 ,-2 ,-4, -5}};
	public static boolean isPossible(int i,int j,int iLength,int jLength)
    {
		//i-1 <0 need not be checked...  
        if( i+1 ==iLength || i+2==iLength || i==iLength) return false;
        
        if(j-1<0 || j+1 ==jLength || j==jLength) return false;
        //System.out.print(true);
    return true;
    }
public static int hourGlassSum(int i,int j,int[][] array)
    {
	
	if(!isPossible(i,j,array.length,array[i].length))
     return Integer.MIN_VALUE;  
	
	else
		return 
				array[i][j-1]+array[i][j]+array[i][j+1]+
						array[i+1][j]+
			array[i+2][j-1]+array[i+2][j]+array[i+2][j+1];
								
}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
   //     int arr[][] = new int[6][6];
//        for(int arr_i=0; arr_i < 6; arr_i++){
//            for(int arr_j=0; arr_j < 6; arr_j++){
//                arr[arr_i][arr_j] = in.nextInt();
//            }
        
            int max=Integer.MIN_VALUE;
          
            int startI=0,startJ=0;
            for(int i=0;i<arr.length;i++)
            {   for(int j=0;j<arr[i].length;j++)
                  {
                int val=hourGlassSum(i,j,arr);
                System.out.println(val);
                if( max<val)
                      {
                      startI=i;
                      startJ=j;
                        max=val;
                      }
                  }  
            }
            System.out.println(max+" "+startI+" "+ startJ);
        System.out.println(arr[startI][startJ-1]+" "+arr[startI][startJ] +" "+ arr[startI][startJ+1]);
        System.out.println("  "+arr[startI+1][startJ] );
        System.out.println(arr[startI+2][startJ-1]+" "+arr[startI+2][startJ] +" "+ arr[startI+2][startJ+1]);
    	}
    }


