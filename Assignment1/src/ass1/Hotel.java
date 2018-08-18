package ass1;
import ass1.Room;
import java.time.LocalDate;
import java.util.ArrayList;
import ass1.RejectException;
public class Hotel {
	private ArrayList<Room> rooms;
	private String name;
	public Hotel(String name) {
		rooms = new ArrayList<Room>();
		this.name = name;
	}
	
	
	public void addRoom(Room room) {
		rooms.add(room);
	}
	
	public String getName() {
		return this.name;
	}
	public ArrayList<Room> getRooms(){
		return this.rooms;
	}
	
	public ArrayList<Room> matchAllRequirements(LocalDate date, int duration, Requirement... requirements) {
		ArrayList<Room> matchedRooms = new ArrayList<Room>();
		for (Room room: rooms) {
			for (Requirement requirement : requirements) {
				if (!requirement.isFulfilled()) {
					if (room.roomMatch(requirement.getCapacity(), date, duration)) {
						requirement.increFulfilled();
						matchedRooms.add(room);
						break;
					}
				} else {
					break;
				}
			}
		}
		if (Requirement.allRequirementsFulfilled(requirements)) {
			return matchedRooms;
		}
		Requirement.resetAllRequirements(requirements);
		return new ArrayList<Room>();
	}


	
}
