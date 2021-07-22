/**
 * Abstract class Mammal with base class as Animal
 * */
public abstract class Mammal extends Animal {
	
	/** 
	 * Get the category of the animal it belongs to.
	 * @return AnimalType Category of the animal
	 */
	@Override
	AnimalType getCategory() {
		this.category = AnimalType.MAMMAL;
		return category;
	}
}
