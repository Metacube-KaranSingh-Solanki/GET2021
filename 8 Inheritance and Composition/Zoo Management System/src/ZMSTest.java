import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ZMSTest {
	/** 2 Zones and 2 Cages each through out has been consider while adding the animal **/
	ZooManagementSystem zms = new ZooManagementSystem(3);
	Animal lion1 = new Lion(3, 40);			// For testing the death (removal) of animal 
	
	@BeforeEach
	public void testCreateZoo() {
		zms.setCapacity(2, 2);
		zms.addToZoo(lion1); //Zone1
		zms.addToZoo(new Crocodile(1, 10)); //Zone2
		zms.addToZoo(new Lion(5, 45)); //Zone1
		zms.addToZoo(new Crocodile(2, 15)); //Zone2
		zms.addToZoo(new Peacock(1, 15)); //Zone3
		zms.addToZoo(new Lion(5, 45)); //Zone1
		zms.addToZoo(new Lion(5, 45)); //Zone1
		zms.addToZoo(new Peacock(1, 15)); //Zone3
	}
	
	/** Adding zone first time - zoo is empty creates a zone and a cage within. */
	@Test
	public void testAddZoneAndCageInitial() {
		zms = new ZooManagementSystem(0);
		assertFalse(zms.addToZoo(new Lion(3, 140)));
	}
	
	/** Adding the mammal, will return false if capacity is full */
	@Test
	public void testAddMammalFail() {
		assertFalse(zms.addToZoo(new Lion(5, 180)));
	}
	
	/** Adding the reptile, capacity available */
	@Test
	public void testAddReptileTrue() {
		assertTrue(zms.addToZoo(new Crocodile(2, 180)));
	}
	/**
	 * Adding the reptile, capacity not available
	 */
	@Test
	public void testAddReptileFail() {
		zms.addToZoo(new Crocodile(4, 100));
		zms.addToZoo(new Crocodile(3, 130));
		assertFalse(zms.addToZoo(new Crocodile(2, 180)));
	}
	
	/**
	 * Adding the Bird, capacity available
	 */
	@Test
	public void testAddBirdPass() {
		assertTrue(zms.addToZoo(new Peacock(2, 155)));
	}
	
	/**
	 * Adding the Bird, capacity not available
	 */
	@Test
	public void testAddBirdFail() {
		zms.addToZoo(new Peacock(7, 100));
		zms.addToZoo(new Peacock(5, 56));
		assertFalse(zms.addToZoo(new Peacock(1, 95)));
	}
	
	/**
	 * Removing an animal if it is present (On Animal Death)
	 */
	@Test
	public void testRemoveLionPass() {
		assertTrue(zms.deathOfAnimal(lion1.getId()));
	}
	
	/**
	 * Removing an animal if it is not present (On Animal Death)
	 * Throws Assertion Error
	 */
	@Test
	public void testRemoveLionFail() {
		assertThrows(AssertionError.class, () -> {zms.deathOfAnimal(999);});
	}
}	
