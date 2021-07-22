/**
 * There are 3 categories of animals: mammal, reptile and bird
 * Sub categories of these are defined as follows
 */
public interface AnimalCategory {
	enum Mammal implements AnimalCategory{
		LION,
		TIGER
	}
	enum Reptile implements AnimalCategory{
		CROCODILE,
		SNAKES
	}
	enum Bird implements AnimalCategory{
		PEACOCK,
		CROW
	}
}
