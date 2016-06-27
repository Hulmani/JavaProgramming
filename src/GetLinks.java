import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GetLinks {

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner scan =new Scanner(new File("/Users/manojhulmani/Desktop/websites.html"));
	int count=0;
	String pattern = "(siteinfo/)(.*)(\")";
	String line="";
    // Create a Pattern object
    Pattern r = Pattern.compile(pattern);
    
		while(scan.hasNextLine())
		{
			line=scan.nextLine();
		    Matcher m = r.matcher(line);
			if(m.find())
			System.out.println(count+" "+m.group(0));
			else
			{
				//System.out.println(count+" "+line);
			}
			count++;
		}
	}
}
