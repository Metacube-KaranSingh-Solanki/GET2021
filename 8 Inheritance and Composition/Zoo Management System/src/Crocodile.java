/** Child class of Reptile and Animal following multilevel hierarchy */
public class Crocodile extends Reptile {

	/** 
	 * Constructor
	 * @param age age of the crocodile
	 * @param weight weight of the crocodile
	 */
	public Crocodile(int age, int weight) {
		this.age = age;
		this.weight = weight;
		subCategory = AnimalCategory.Reptile.CROCODILE;
	}

	/**
	 * Sound of the Crocodile
	 * @return string representing the sound of the crocodile
	 */
	@Override
	String getSound() {
		return "Croc-sound";
	}
}
