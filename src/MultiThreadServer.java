import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer implements Runnable {
   Socket csocket;
   MultiThreadServer(Socket csocket) {
      this.csocket = csocket;
   }

   public static void main(String args[]) 
   throws Exception {
      ServerSocket ssock = new ServerSocket(1234);
      //System.out.println("Listening");
      while (true) {
         Socket sock = ssock.accept();
        // System.out.println("Connected");
         new Thread(new MultiThreadServer(sock)).start();
      }
   }
   public void run() {
      try {
         
          BufferedReader  in  = new BufferedReader (new InputStreamReader(csocket.getInputStream()));
          PrintStream pstream = new PrintStream
         (csocket.getOutputStream());
        
            String s="",out="";
            
            while (!(s = in.readLine()).equals("END")) {
                if(s!="END")
            	out+=s+"\n";
            }
            pstream.println(out);
         pstream.close();
         csocket.close();
      }
      catch (IOException e) {
         System.out.println(e);
      }
   }
}