/**
 * Abstract Class and base class
 * Define Data Members and Operations of animal
 * id is in sequence through out the animal categories. No specific id for categories and sub-categories.
 * dynamic name allocation to allocate unique name to each animal
 */
abstract class Animal {
	String name;
	static int count = 101;
	int id;
	int age;
	int weight;
	AnimalType category; //Categories can be Mammal, Bird, Reptile etc.
	AnimalCategory subCategory; //SubCategories can be Lion, peacock, crocodile etc.
	
	/**
	 * Sound of the Animal
	 * @return string to get the sound of the animal
	 */
	abstract String getSound();
	abstract AnimalType getCategory();
	
	/**Getters and setters of the Data Members*/
	protected void setIdAndName(AnimalCategory subCategory2) {
		id = count++;
		name = subCategory2.toString() + id;
	}

	/** To get the age */
	protected int getAge() {
		return age;
	}

	/** To get the weight */
	protected int getWeight() {
		return weight;
	}

	/** To set the weight */
	protected void setWeight(int weight) {
		this.weight = weight;
	}

	/** To set the category */
	protected void setCategories(AnimalType category) {
		this.category = category;
	}

	/** To get the name */
	protected String getName() {
		return name;
	}

	/** To get the id */
	protected int getId() {
		return id;
	}
}
