package ass1;
import ass1.Booking;
import java.util.ArrayList;
import java.time.LocalDate;
import java.lang.StringBuilder;


public class Room {
	 private String hotel;
	 private int capacity;
	 private int roomNumber;
	 private ArrayList<Booking> bookings;
	 public ArrayList<Booking> getBookings() {
		return bookings;
	}


	public Room(String hotel, int roomNumber, int capacity) {
		 this.hotel = hotel;
		 this.capacity = capacity;
		 this.roomNumber = roomNumber;
		 this.bookings = new ArrayList<Booking>();
	 }


	/**
	 * Add an booking.
	 * @param b
	 */
	public void addBooking(String customer, LocalDate date, int duration) {
		this.bookings.add(new Booking(customer, date, duration));
	}
	
	public void deleteBooking(Booking booking) {
		bookings.remove(booking);
	}
	
	public String getHotel() {
		return hotel;
	}

	/**
	 * @return the roomNumber
	 */
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public int getCapacity() {
		return capacity;
	}
	/**
	 * @return the dates that this room is unavailable
	 */
	
	public Booking getBookingByCustomer(String customer){
		for(Booking booking:bookings) {
			if (booking.getCustomer().equals(customer)) {
				return booking;
			}
		}
		return null;
	}
	public ArrayList<LocalDate> getBookedDates(){
		ArrayList<LocalDate> dates = new ArrayList<LocalDate>();
		for (Booking booking : this.bookings) {
			for (int i = 0; i<= booking.getDuration(); i++) {
				dates.add(booking.getDate().plusDays(i));
			}
		}
		return dates; 
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Hotel "+ this.hotel + " " + this.roomNumber);
		for (Booking booking : this.bookings) {
			sb.append(" " + DateFormatter.getDateString(booking.getDate())+" "+booking.getDuration());
		}
		return sb.toString();
	}
	
	/**
	 * @return if the given room match with the given specs
	 */
	public boolean roomMatch(int capacity, LocalDate date, int duration) {
		if (this.getCapacity() != capacity) {
			return false;
		}
		for (int i = 0; i<= duration; i++) {
			if (this.getBookedDates().contains(date.plusDays(i))) {
				return false;
			}
		}
		return true;
	}
	

}