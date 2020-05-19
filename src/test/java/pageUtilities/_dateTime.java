package pageUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class _dateTime {
	
	public static String getDateTime() {
		Date thisDate = new Date();
		SimpleDateFormat dateForm = new SimpleDateFormat("dd/MM HH:mm");
		return dateForm.format(thisDate);
	}

}
