import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.*;
import java.text.*;
public class Browser {
    public static void main(String[] args) {
        String url = "https://www.youtube.com/watch?v=N2q-obGUX8Q&list=RDN2q-obGUX8Q#t=21";
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("hh:mm:ss");
        // display time and date using toString()
        System.out.println(date.toString());
        System.out.println(ft.format(date));
        
        String time="10:00:10";
        while(true)
        {
             date = new Date();
            ft = new SimpleDateFormat ("hh:mm:ss");
           //  System.out.println(ft.format(date));
            if(ft.format(date).toString().equals(time))
                break;
            
            if(ft.format(date).toString().compareTo(time)>0)
            	break;
            
        }
        
        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                System.out.println("run time");
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}