
public class RevereseStringE {

	
	public static void main(String[] args)
	{
		String str="eaitech";
		StringBuilder rev=new StringBuilder("");
		//StringBuilder revl=new StringBuilder("");
		for(int i=str.length()-1;i>=0;i--)
		{
			rev.append(str.charAt(i));
		}
		System.out.println(rev);
		int l=rev.length();
		for(int i=0;i<(l/2);i++)
		{
			char t=rev.charAt(i);
			rev.setCharAt(i, rev.charAt(l-(i+1)));
			rev.setCharAt(l-(i+1),t );
		}
		System.out.println(rev);
	}
}
