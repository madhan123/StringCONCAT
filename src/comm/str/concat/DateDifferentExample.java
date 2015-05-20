package comm.str.concat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDifferentExample {

	public static void main(String[] args) {
		
		String dateStart = "04/23/2015 14:10:58";
		String dateStop = "01/15/2012 10:31:48";

		//HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		Date d1 = null;
		Date d2 = null;

		try {
			d1 = format.parse(dateStart);
			//d2 = format.parse(dateStop);
			

			Date date = format.parse(format.format(new Date()));
			System.out.println("Date" + d1.getTime());
			//in milliseconds
			long diff = date.getTime() - d1.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);

			if(diffMinutes > 2){
				System.out.println("Greater than 10"+""+diffMinutes);
			}else{
				System.out.println("Less than 10" + ""+ diffMinutes);
			}
			System.out.print(diffDays + " days, ");
			System.out.print(diffHours + " hours, ");
			System.out.print(diffMinutes + " minutes, ");
			System.out.print(diffSeconds + " seconds.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
