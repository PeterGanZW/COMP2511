package ass1;

import ass1.Booking;
import ass1.Room;
import ass1.Hotel;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import ass1.DateFormatter;
import ass1.RejectException;
import ass1.Requirement;
public class HotelBookingSystem {
	private static ArrayList<Hotel> hotels;

	public static void main(String[] args) {
		Scanner sc = null;
		hotels = new ArrayList<Hotel>();
		try {
			// args[0] is the first command line argument
			sc = new Scanner(new File(args[0]));
			while (sc.hasNextLine()) {
				String sentence = sc.nextLine();
				String[] arg = sentence.split(" ");
				System.out.println(sentence);
				switch (arg[0]) {
				case "Hotel":
					addRoom(arg[1], Integer.parseInt(arg[2]), Integer.parseInt(arg[3]));
					break;
				case "Booking":
					if (arg.length == 7) {
						makeBooking(arg[1], DateFormatter.getLocalDate(arg[2] + arg[3]), Integer.parseInt(arg[4]),
								new Requirement(arg[5],arg[6]));
					} else if (arg.length == 9) {
						makeBooking(arg[1], DateFormatter.getLocalDate(arg[2] + arg[3]), Integer.parseInt(arg[4]),
								new Requirement(arg[5],arg[6]), new Requirement(arg[7],arg[8]));
					} else if (arg.length == 11) {
						makeBooking(arg[1], DateFormatter.getLocalDate(arg[2] + arg[3]), Integer.parseInt(arg[4]),
								new Requirement(arg[5],arg[6]), new Requirement(arg[7],arg[8]), new Requirement(arg[9],arg[10]));
					} else {
						System.out.println("Booking rejected.");
					}
					break;
				case "Change":
					
					break;
				case "Cancel":
					cancelBooking(arg[1]);
					break;

				case "Print":
					printOccupacy(arg[1]);
					break;
				default:
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			if (sc != null)
				sc.close();
		}
	}
	/*
	 * A requirement is A String of (Capacity+quantity);
	 */
	
	public static ArrayList<Room> getBookedRoomsByPerson(String customer) {
		ArrayList<Room> rooms = new ArrayList<Room>();
		for (Hotel hotel:hotels) {
			for(Room room: hotel.getRooms()) {
				for(Booking booking:room.getBookings()) {
					if (booking.getCustomer().equals(customer)) {
						rooms.add(room);
					}
				}
			}
			//exist early to improve performance
			if (!rooms.isEmpty()) {
				return rooms;
			}
		}
		return rooms;
	}
	
	public static void makeBooking(String customer, LocalDate date, int duration, Requirement...requirements) {
		try {
			ArrayList<Room> hotelRooms = selectHotelRooms(date, duration, requirements);
			for (Room room : hotelRooms) {
				System.out.println(" "+room.getRoomNumber());
				room.addBooking(customer,date,duration);
			}
			
		} catch (RejectException e) {
			System.out.println("Booking rejected");
		}
	}
	public static ArrayList<Room> selectHotelRooms(LocalDate date, int duration, Requirement...requirements) throws RejectException {
		for (Hotel hotel : hotels) {
			ArrayList<Room> allRooms = hotel.matchAllRequirements(date, duration, requirements);
			if (!allRooms.isEmpty()) {
				return allRooms;
			}
		}
		throw new RejectException();
	}
	/*
	 * add a room to the given hotel.
	 */
	public static void addRoom(String hotelName, int roomNumber, int capacity) {
		Hotel hotel = getHotel(hotelName);
		hotels.add(hotel);;
		Room rm = new Room(hotelName, roomNumber, capacity);
		hotel.addRoom(rm);
	}

	/*
	 * get a hotel by its name. if not exist, create a new one.
	 */
	public static Hotel getHotel(String hotelName) {
		for (Hotel hotel : hotels) {
			if (hotel.getName().equals(hotelName)) {
				return hotel;
			}
		}
		return new Hotel(hotelName);
	}

	public static void printOccupacy(String hotel) {
		for (Room room: getHotel(hotel).getRooms()) {
			System.out.println(room.toString());
		}
	}

	public static void cancelBooking(String customer) {
			ArrayList<Room> rooms = getBookedRoomsByPerson(customer);
			if (rooms.isEmpty()) {
				System.out.println("Cancel rejected");
			} else {
				for(Room room:rooms) {
					room.deleteBooking(room.getBookingByCustomer(customer));
				}
			}
			
		}

	public void modifyBooking() {

	}


}
