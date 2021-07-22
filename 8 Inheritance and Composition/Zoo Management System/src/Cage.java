import java.util.ArrayList;
import java.util.List;

/** Cage class with capacity and subCategory(type of animal like tiger, that can be store in the cage) */
public class Cage {
	private static int count=1;
	private int id; //AutoGenerated
	private AnimalCategory subCategory;
	private final int capacity;
	private List<Animal> animals = new ArrayList<>();
	
	/** 
     * Constructor
	 * @param capacity capacity of the cage
	 * @param subCategory category of the cage
	 */
	public Cage(int capacity, AnimalCategory subCategory) {
		this.capacity = capacity;
		this.subCategory = subCategory;
		this.id = count++;
	}
	
	/** 
	 * Add the animal to the cage 
	 * @param animal Animal object that need to added
	 */
	void addAnimal(Animal animal) {
		animal.setIdAndName(animal.subCategory);
		animals.add(animal);
	}
	
	/**
	 * Remove the animal from the cage - death of Animal
	 * @param Animal that need to be removed
	 */
	void removeAnimal(Animal animal) {
		animals.remove(animal);
	}
	
	/**
	 * Check cage has capacity to add animals
	 * @return true if capacity is available in the cage
	 */
	public boolean isAvailble() {
		return animals.size() < getCapacity()? true: false;
	}
	
	/** To get id */
	public int getId() {
		return id;
	}
	
	/** To get sub category */
	public AnimalCategory getSubCategory() {
		return subCategory;
	}
	
	/** To get the maximum capacity */
	public int getCapacity() {
		return capacity;
	}
	
	/** To get the list of animals */
	public List<Animal> getAnimals() {
		return animals;
	}
}