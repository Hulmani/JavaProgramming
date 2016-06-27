import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MySqlBooks {
	public static void main(String[] args) throws FileNotFoundException {
		
		
		Scanner scan=new Scanner(new File("/Users/manojhulmani/Dropbox/BookS/BX-Users.csv"),"iso-8859-1");
		//Scanner scan=new Scanner(new File("/Users/manojhulmani/Desktop/BX-Books.txt"),"iso-8859-1");
		int i=0;
		scan.nextLine();
		while(scan.hasNextLine())
		{
			i++;
			String line =scan.nextLine();
			String  l="\"";
			String p=line.replace(l, "");
			
			String []o=p.split(";");
			for(int j=0;j<o.length;j++)
			{
				System.out.print(o[j]+" ");
			}
			
			String sql="INSERT INTO books values (\""+o[0]+"\",\""+o[1]+"\",\""+o[2]+"\")";
			System.out.println("\n"+sql);
			if(i==4) break;
		}
		System.out.println(i);
		
	}
}
