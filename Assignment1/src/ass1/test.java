package ass1;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import ass1.Booking;
import ass1.Room;
import ass1.HotelBookingSystem;
import ass1.DateFormatter;
public class test {
	public static void main(String[] args) {
		/*HotelBookingSystem hbs = new HotelBookingSystem();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd", Locale.ENGLISH);
		LocalDate date = LocalDate.of(1999, 03, 01);
		System.out.println(date.plusDays(1).format(dtf));
		Room rm1 = new Room("Seasons", 203, 2);
		HotelBookingSystem.addRoom("Sherton", 101, 1);
		hbs.makeBooking("Peter", 1 , date, 3);
		hbs.makeBooking("Peter", 1, date.plusDays(5), 1);
		System.out.println(rm1.toString());
		hbs.printOccupacy("Sherton");*/
		String a = "Jan";
		String b = "3";
		LocalDate ab = DateFormatter.getLocalDate(a+b);
		//LocalDate ab = LocalDate.of(1999, 03, 01);
		System.out.println(DateFormatter.getDateString(ab.plusDays(1)));
		String yes = "single";
		System.out.println(capacityStringToInt(yes));
		int[] array = {0};
		for (int i = 0; i<3;i++) {
			array[0]++;
		}
		System.out.println(array[0]);
		
	}	
	public static ArrayList<Room> rooms(){
		return null;
	}
	
	public static int capacityStringToInt(String capacity) {
		System.out.println("CAPACITY ="+capacity);
		if (capacity == "single") {
			return 1;
		} else if (capacity == "double") {
			return 2;
		} else if (capacity == "triple") {
			return 3;
		} else {
			return 0;
		}
	}
}


