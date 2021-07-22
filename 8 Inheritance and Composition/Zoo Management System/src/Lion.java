/** Child class of Mammal and Animal following multilevel hierarchy */
public class Lion extends Mammal {
	
	/** 
	 * Constructor
	 * @param age age of the Lion
	 * @param weight weight of the Lion
	 */
	public Lion(int age, int weight) {
		this.age = age;
		this.weight = weight;
		subCategory = AnimalCategory.Mammal.LION;
	}
	
	/**
	 * Sound of the Lion
	 * @return string representing the sound of the lion
	 */
	@Override
	String getSound() {
		return "Roar";
	}
}
