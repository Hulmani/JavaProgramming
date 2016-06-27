import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MFib {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan=new Scanner(System.in);
        int a=scan.nextInt();
        int b=scan.nextInt();
        int n=scan.nextInt();
        BigInteger[] fibs=new BigInteger[ n];
        fibs[0]= BigInteger.valueOf (a); 
        fibs[1]=BigInteger.valueOf (b) ;
        fib(n,fibs);
      //  System.out.println();
       // for(int i=0;i<n;i++)
            System.out.println(fibs[(n-1)]);
    }
    
    public static BigInteger fib(int n,BigInteger[] fibs)
        {
        
        if(n==0) return fibs[0];
        else if(n==1) return fibs[1];
       // else if(fibs[n]>0) return fibs[n];
        else 
        {
          
            fibs[(n-1)]=fib(n-1,fibs);
            
            fibs[(n-2)]=fib(n-2,fibs);
           return  fibs[(n-1)].multiply(fibs[(n-1)]).add( fibs[(n-2)]);//,fibs);
           
             //fibs[n-1];
        }
    }
}