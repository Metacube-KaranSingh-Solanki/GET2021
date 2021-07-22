import java.util.ArrayList;
import java.util.List;
/** Zoo Management System Class to maintain the zoo - Zones, Cages and Animals */

public class ZooManagementSystem {

	List<Zone> zones = new ArrayList<>();
	List<Animal> animals = new ArrayList<>(); //Stores the list of all the animals of the zoo. 
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
						animals.add(animal);
						return true;
					}
				}
				if (zone.isAvailble()) {
					Cage cage = new Cage(cageCapacity, animal.subCategory);
					zone.addCage(cage);
					cage.addAnimal(animal);
					animals.add(animal);
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
			animals.add(animal);
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
		Animal animal = null;
		for (Animal a : animals) {
			if (a.getId() == id)
				animal = a;
		}

		if (animal == null)
			throw new AssertionError("Animal not present");
		boolean isSuccess = false;

		for (Zone zone : zones) {
			if (zone.getCategory() == animal.getCategory()) {
				for (Cage cage : zone.getCages()) {
					if (cage.getSubCategory() == animal.subCategory) {
						for (Animal a : cage.getAnimals()) {
							if (a.getId() == id) {
								cage.removeAnimal(animal);
								return true;
							}
						}
					}
				}
			}
		}

		return isSuccess;
	}

	/**
	 * Check zone has capacity to add cage
	 * @return true if capacity is available in the zone
	 */
	public boolean isAvailable() {
		return zones.size() < capacity ? true : false;
	}
}
