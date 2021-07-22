/** Child class of Bird and Animal following multilevel hierarchy */
public class Peacock extends Bird{
	
	/** 
	 * Constructor
	 * @param age age of the Peacock
	 * @param weight weight of the Peacock
	 */
	public Peacock(int age, int weight) {
		this.age = age;
		this.weight = weight;
		subCategory = AnimalCategory.Bird.PEACOCK;
	}

	/**
	 * Sound of the peacock
	 * @return string representing the sound of the peacock
	 */
	@Override
	String getSound() {
		return "Train Rattle";
	}

}
