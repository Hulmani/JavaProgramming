import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileWriter2 {
	private static final int SIZE = 100;

	public static void main(String[] args) throws IOException, InterruptedException {
	    File file = new File("/Users/manojhulmani/Desktop/l.txt");
	    FileWriter fileWriter = new FileWriter(file, true);
	    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	    for (int i = 0; i < SIZE; i++) {
	        bufferedWriter.write("2\n");
	        System.out.println(i);
	        Thread.sleep(100);
	    }

	    if (bufferedWriter != null) bufferedWriter.close();
	    if (fileWriter != null) fileWriter.close();
	}
}
