package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * Klasa komparator datuma jer se datum pojavljuje kod profesora i kod studenata
 * @author Mile
 *
 */
public class DateComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		try {
			Date dat1 = new SimpleDateFormat("dd.MM.yyyy.").parse(o1);
			Date dat2 = new SimpleDateFormat("dd.MM.yyyy.").parse(o2);
			
			if (dat1.after(dat2))
				return 1;
			else
				return -1;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
