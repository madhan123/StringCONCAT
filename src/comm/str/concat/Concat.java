package comm.str.concat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Concat {

	static String PDATA = "";
	static int x = 3;
	static int y = 4;
//	static String value = "You can spell check very long text areas without compromising";
	static String value ="You can spell check very long text areas without compromising any performance hits. Regardless of the size of the text, UltimateSpell only sends small portions of the text to the server as needed, while the user spell checks through the text"

+ "Basically the spell check dialog box makes on-demand calls to a callback page on the server without refreshing the whole page or dialog. It keeps processing small blocks of text using the AJAX (Asynchronous JavaScript and XML) techniques."

+ "Note that UltimateSpell displays the text in the dialog box sentence-by-sentence just like Microsoft Word. This helps the user understand the actual context in which the spelling error occurs. ";

	public static void main(String[] args){

		//	formatViolationTime(String.valueOf(new Date()));
		whileLoop();
		/*try {
			System.out.println(formatViolationTime("1979/09/10",false));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	private static Date formatViolationTime(String violationTime, boolean dob) throws ParseException {
		SimpleDateFormat mDateFormat;
		Date mDate = new Date();
		if(dob) {
			mDate =  new SimpleDateFormat("MM/DD/YYYY").parse(violationTime);
		}else {
			mDate =  new SimpleDateFormat("MM/DD/YYYY hh:mm:ss a").parse(violationTime);
		}
		return mDate;
	}


	public static String randInt(int min, int max) {

		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		String prefixZeroRandomNumber =String.format("%04d", randomNum);
		return  prefixZeroRandomNumber;
	}

	private static void whileLoop() {
		int count = 0;
		int startIndex = 0;
		int endIndex = 25;
		
		while(value.length() > 0) {
			value = value.trim();
			String row;
			if(value.length() <= 25) {
				row = value;
				value = "";
			} else {
				row = value.substring(startIndex, endIndex);
				int lastIndex = row.lastIndexOf(" ", 24);
				row = value.substring(startIndex, lastIndex);
				value = value.substring(lastIndex);
			}
			PDATA += "T 7 0 " + x + " " + y + " " +row+ "\r\n";
			y += 3.5;
			count++;
			if(count > 10) {
				break;
			}
		}
	}


	private static String CPCLData(){

		PDATA += "! 0 200 200 100 1\r\n";
		PDATA += "T 4 0 "+ x +" "+ y +" "+ value +"\r\n";
		return PDATA;

	}
}
