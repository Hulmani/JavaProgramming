
public class TOH {
	
	public static void toi(int n, char a,char b,char c)
	{
		if(n==0)
			 System.out.println("Move "+a+" to"+b);	
		else
		{
			toi(n-1,a,c,b);
			 System.out.println("Move "+a+" to"+b);	
			 toi(n-1,c,b,a);
		}
	}
	public static void main(String[] args) {
	//toi(2,'A','B','C');
	
	String sa="1cbcbcb";
	
	
	char[] s=sa.toCharArray();
	
	int n=s.length;
	int l=0;
	int[] kmp=new int[n+1];
	kmp[1] = 0;
	
	for (int i = 2; i <= n-1; i = i + 1){
	    l = kmp[i - 1];
	    while (l > 0 && s[i] != s[l + 1]){
	        l = kmp[l];
	    }
	  //  System.out.println(i+" "+(l+1));
	    if (s[i] == s[l + 1]){
	        kmp[i] = l + 1;
	    }
	    else{
	        kmp[i] = 0;
	    }
	}
	for(int i=1;i<n;i++)
	System.out.print(kmp[i]+",");
}}
