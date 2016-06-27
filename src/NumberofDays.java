import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class NumberofDays {
	static int diff(int year1,int month1,int day1,int year2,int month2,int day2)
	{
		int d=0;
		int year=year1;
		//days left in first month
		d=numberofDays(month1,year)-day1;
		
		if(month1==month2 && year1==year2) return day2-day1;
		
		else if(year1==year2) 
		{
			
		
			//System.out.println(" "+d);
			for(int m=month1+1;m<month2;m++)
			{
				int n=numberofDays(m,year);
				d+=n;
				System.out.println(m+" "+n +" "+d);
			}
			
			d+=day2;
			System.out.println();
			
			return d;
		}
		
		//System.out.println("Remaining days in the month "+d);
		else
		{
		
		if(month1==12) {month1=0;year++;}
		
		for(int i=month1+1;i<month2 || year<year2 ;i++)
		{
			d+=numberofDays(i,year);
			System.out.println(i+" "+d);
			
			if(i==12){ year++; i=0;	}
		}
		
		d+=day2;
		}
		return d;
	}
	
	static int daysInYear(int year)
	{
		if(numberofDays(2,year)==28)
				{
			return  365;
				}
		else return 366;
	}
	
	static int numberofDays(int month,int year)
	{
		if(month==2)return 28;
		
		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 ||month==12   )
		return 31;
		
		else return 30;
			
	}
			public static void main(String[] args)
			{
				String inputString1 = "12 03 2017";
				String inputString2 = "12 09 2018";
				String[] in1=inputString1.split(" ");
				String[] in2=inputString2.split(" ");
				int d1=Integer.parseInt(in1[0]);
				int m1=Integer.parseInt(in1[1]);
				int y1=Integer.parseInt(in1[2]);

				int d2=Integer.parseInt(in2[0]);
				int m2=Integer.parseInt(in2[1]);
				int y2=Integer.parseInt(in2[2]);
				
				System.out.println("diff "+diff(y1,m1,d1,y2,m2,d2));
			
				
				SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
				

				try {
				    Date date1 = myFormat.parse(inputString1);
				    Date date2 = myFormat.parse(inputString2);
				    long diff = date2.getTime() - date1.getTime();
				    //System.out.println(date1.getDate());
				    //System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
				   
				} catch (ParseException e) {
				    e.printStackTrace();
				}
			}
}
