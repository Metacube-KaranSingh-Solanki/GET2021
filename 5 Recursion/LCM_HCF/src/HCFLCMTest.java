import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HCFLCMTest {
	
	static LCMHCF lcmhcf;
	
	@BeforeEach
	public void init() {
		lcmhcf = new LCMHCF();
	}
	
	@Test
	public void testHCF1() {
		assertEquals(13, lcmhcf.findHCF(91, 130));
	}

	@Test
	public void testHCF2() {
		assertEquals(3, lcmhcf.findHCF(69, 54));
	}

	@Test
	public void testLCM1() {
		assertEquals(12, lcmhcf.findLCM(3, 4));
	}

	@Test
	public void testLCM2() {
		assertEquals(60, lcmhcf.findLCM(20, 15));
	}
}