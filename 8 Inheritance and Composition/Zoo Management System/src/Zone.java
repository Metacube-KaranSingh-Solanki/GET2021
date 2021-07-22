import java.util.ArrayList;
import java.util.List;

/**
 * Zone class to store the zone information
 * id is autoIncerement
 */
public class Zone {
	private static int count = 1;
	private int id;
	private final int capacity;
	private final AnimalType category;
	private boolean hasPark, hasCanteen;
	List<Cage> cages = new ArrayList<>();
	
	/**
	 * @param capacity capacity of the zone
	 * @param category category of type of animal it store
	 * @param hasPark if zone has park or not true/false
	 * @param hasCanteen if zone has canteen or not true/false
	 */
	public Zone(int capacity, AnimalType category, boolean hasPark, boolean hasCanteen) {
		this.capacity = capacity;
		this.category = category;
		this.hasPark = hasPark;
		this.hasCanteen = hasCanteen;
		this.id = count++;
	}
	
	/**
	 * Check zone has capacity to add cages
	 * @return true if capacity is available in the zone to add cage
	 */
	public boolean isAvailble() {
		return cages.size()<capacity? true: false;
	}
	
	/**
	 * Add cage to the zone
	 * @param cage Cage type object
	 */
	public void addCage(Cage cage) {
		cages.add(cage);
	}
	
	
	/**
	 * Check if zone has Park
	 * @return boolean true if contains park
	 */
	public boolean hasPark() {
		return hasPark;
	}
	
	/**
	 * Check if zone has Canteen
	 * @return boolean true if contains Canteen
	 */
	public boolean hasCanteen() {
		return hasCanteen;
	}
	
	/*** Getters of the Zone Data Members */
	public int getId() {
		return id;
	}

	public AnimalType getCategory() {
		return category;
	}

	public List<Cage> getCages() {
		return cages;
	}
}
