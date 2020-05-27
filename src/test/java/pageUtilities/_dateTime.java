package pageUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class _dateTime {
	
	public static String getDateTime() {
		Date thisDate = new Date();
		SimpleDateFormat dateForm = new SimpleDateFormat("ddMM'T'HHmmss");
		return dateForm.format(thisDate);
	}
}
