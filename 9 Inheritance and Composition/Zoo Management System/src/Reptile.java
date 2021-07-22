/** Abstract class Reptile with base class as Animal */
public abstract class Reptile extends Animal{
	
	/** Get the category of the animal it belongs to.
	 *  @return AnimalType Category of the animal
	 */
	@Override
	AnimalType getCategory() {
		this.category = AnimalType.REPTILE;
		return category;
	}
}
