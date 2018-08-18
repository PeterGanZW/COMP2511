package ass1;

public class Requirement {
	private static final Requirement requirement = null;
	private int capacity;
	public int getCapacity() {
		return capacity;
	}
	private int quantity;
	public int getQuantity() {
		return quantity;
	}
	private int fulfilledQuantity;
	public int getFulfilled() {
		return fulfilledQuantity;
	}
	public void setFulfilledQuantity(int fulfilledQuantity) {
		this.fulfilledQuantity = fulfilledQuantity;
	}
	public Requirement(String capacity, String quantity){
		this.capacity = capacityStringToInt(capacity);
		this.quantity = Integer.parseInt(quantity);
		this.fulfilledQuantity = 0;
	}
	public static int capacityStringToInt(String capacity) {
		if (capacity.equals("single")) {
			return 1;
		} else if (capacity.equals("double")) {
			return 2;
		} else {
			return 3;
		}
	}
	public void increFulfilled() {
		this.fulfilledQuantity+=1;
		//System.out.println("CAPACITY"+this.capacity+":"+"UPDATED FULFILLED"+ this.fulfilledQuantity);
	}
	public boolean isFulfilled() {
		//System.out.println("Capacity:"+ this.capacity+ "FULFILLED"+ fulfilledQuantity + "  GOAL"+ this.quantity);
		return (fulfilledQuantity == this.quantity);
	}
	
	public void reset() {
		this.fulfilledQuantity = 0;
	}
	public static boolean allRequirementsFulfilled(Requirement...requirements) {
		for(Requirement requirement : requirements) {
			if (!requirement.isFulfilled()) return false;
		}
		return true;
	}
	public static void resetAllRequirements(Requirement...requirements) {
		for (Requirement requirement: requirements) {
			requirement.reset();
		}
	}
	
}

