package ass1;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.time.LocalDate;

public class DateFormatter {
	public static String getDateString(LocalDate date) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM d", Locale.ENGLISH);
		return date.format(dtf);
	}
	public static LocalDate getLocalDate(String date) {
		date = "2018" + date;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMMd", Locale.ENGLISH);
		LocalDate ld = LocalDate.parse(date, dtf);
		return ld;
	}
	
}
