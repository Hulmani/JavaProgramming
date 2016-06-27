import java.util.ArrayList;
import java.util.Arrays;


public class Stri {
	public static boolean isFriend(String A ,String B)
	{
		char a[]=A.toCharArray();
		char b[]=B.toCharArray();
		boolean[] arrayA=new boolean[256];
		boolean[] arrayB=new boolean[256];
		// System.out.println("dsf");
		int length=a.length;
		for (int i = 0; i <length ; i++) {

			int indexA=a[i]-'0';
			int indexB=b[i]-'0';
			if(arrayA[indexA]) arrayA[indexA]=false;

			else arrayA[indexA]=true;

			if(arrayB[indexB]) arrayB[indexB]=false;

			else arrayB[indexB]=true;

		}

		for(int i=0;i<length;i++)
		{
			int indexA=a[i]-'0';
			int indexB=b[i]-'0';
			if(arrayA[indexA]!=arrayA[indexB]) return false;
		}
		//System.out.println("dsf");
		return true;
	}
	public static String[] friends(String[] words)
	{
		Arrays.sort(words);
		int l=words.length;
		int []matches=new int[l];
		for(int i=0;i<l;i++)
		{
			matches[i]=i;
			//System.out.println(matches[i]);
		}

		for(int i=0;i<l;i++)
		{
			for(int j=i+1;j<l;j++)
				if(words[i].length()==words[j].length()){
					if(isFriend(words[i],words[j]))
					{
						if(matches[j]==j)
							matches[j]=i;
					}
				}
		}

//				for(int i=0;i<l;i++)
//				{
//		
//					System.out.println(words[i]+" "+matches[i]);
//				}
		ArrayList <String> results=new ArrayList<String>();
		for(int i=0;i<l;i++)
		{
			String r="";
			int count=0;
			for(int k=0;k<l;k++){
				
				if(matches[k]==i)
				{
					
						r+=words[k]+" ";	
						count++;	
				
				}

			}
			if(!r.equals("") && count>1)
			results.add(r);

		}
		String[] rs=new String[results.size()];
		return results.toArray(rs);
	}

	public static void main(String[] args) {
		//System.out.println("dsf");
		System.out.println(isFriend("cat","tac"));

		String []words={"cat","toc","teaching","cheating","dibs","lade","deal","tac","tic","deal"};

		String[] rs=friends(words);
		for(int i=0;i<rs.length;i++)
		System.out.println(rs[i]);
	}
}
