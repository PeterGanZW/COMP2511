package ass1;
import java.time.LocalDate;
import java.util.ArrayList;

import ass1.DateFormatter;

public class Booking {
	private LocalDate date;
	private int duration;
	private String customer;
	
	public Booking(String customer, LocalDate date, int duration) {
		this.date = date;
		this.duration = duration;
		this.customer =  customer;
	}
	
	public LocalDate getDate() {
		return this.date;
	}
	public int getDuration() {
		return this.duration;
	}
	public String getCustomer() {
		return this.customer;
	}
		
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getCustomer()+ " " + DateFormatter.getDateString(this.date)+ " " + this.duration);
		return sb.toString();
	}
	
}

