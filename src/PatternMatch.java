import java.util.regex.Matcher;
import java.util.regex.Pattern;

//I am more interested in forming a different regex than the proposed solution.

//so, could anyone explain me is this wrong?

//[123]{1}[120]{1} [xs0]{1} [30Aa]{1} [xsu]{1} [\\.,])$
public class PatternMatch {

	public static void main(String[] args)
	{
		Pattern p=Pattern.compile("(^\\s\\d)");
		Matcher m=p.matcher("djsf");
		 System.out.println(m.find());
		 
		 System.out.println("a".matches("\\."));
	}
}
