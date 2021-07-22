import java.util.ArrayList;
import java.util.List;
/** Zoo Management System Class to maintain the zoo - Zones, Cages and Animals */

public class ZooManagementSystem {

	List<Zone> zones = new ArrayList<>();
	private final int capacity;
	private int cageCapacity, zoneCapacity;

	public void setCapacity(int cageCapacity, int zoneCapacity) {
		this.cageCapacity = cageCapacity;
		this.zoneCapacity = zoneCapacity;
	}

	/**
	 * Constructor of Zone Management System
	 * @param capacity capacity of the zone
	 */
	public ZooManagementSystem(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Add animal to zoo
	 * @param animal Object of type animal
	 * @return true if animal get added
	 */
	public boolean addToZoo(Animal animal) {
		boolean isSuccess = false;
		for (Zone zone : zones) {
			if (zone.getCategory() == animal.getCategory()) {
				for (Cage cage : zone.getCages()) {
					if (cage.getSubCategory() == animal.subCategory && cage.isAvailble()) {
						cage.addAnimal(animal);
						return true;
					}
				}
				if (zone.isAvailble()) {
					Cage cage = new Cage(cageCapacity, animal.subCategory);
					zone.addCage(cage);
					cage.addAnimal(animal);
					return true;
				}
			}
		}

		if (isAvailable()) {
			Zone zone = new Zone(zoneCapacity, animal.getCategory(), true, false);
			Cage cage = new Cage(cageCapacity ,animal.subCategory);
			zones.add(zone);
			zone.addCage(cage);
			cage.addAnimal(animal);
			isSuccess = true;
		}
		return isSuccess;
	}
	
	/**
	 * Remove animal from zoo when dead
	 * @param animal Object of type animal
	 * @return true if animal get added
	 */
	public boolean deathOfAnimal(int id) {
		for (Zone zone : zones) {
			for (Cage cage : zone.getCages()) {
				for (Animal a : cage.getAnimals()) {
					if (a.getId() == id) {
						cage.removeAnimal(a);
						return true;
					}
				}
			}
		}
		
		throw new AssertionError("Animal with this id not present in zoo.");
	}

	/**
	 * Check zone has capacity to add cage
	 * @return true if capacity is available in the zone
	 */
	public boolean isAvailable() {
		return zones.size() < capacity ? true : false;
	}
}
