import com.iocor.stats.MathHelper;
import com.iocor.stats.distributions.PoissonDistribution;

import junit.framework.Assert;
import junit.framework.TestCase;

public class PoissonTests extends TestCase {
	public static final int PLACES = 8;

	public static void RoundedAssertEquals(double a, double b, int places) {
		assertEquals(MathHelper.Round(a, places), MathHelper.Round(b, places));
	}

	public void testConstructor() {
		PoissonDistribution p1 = new PoissonDistribution(1);
		Assert.assertEquals(1.0, p1.Mean());
		Assert.assertEquals(1.0, p1.Variance());
		try{
			PoissonDistribution p2 = new PoissonDistribution(0);
			fail("construction of a poisson distribution with a passed did not fail");
		} catch (IllegalArgumentException iae){
			
		}

	}

	public void testPMF() {
		PoissonDistribution p1 = new PoissonDistribution(2);
		RoundedAssertEquals(0.13533528323661269189, p1.PMF(0), PLACES);
		RoundedAssertEquals(0.27067056647322538378, p1.PMF(1), PLACES);
		RoundedAssertEquals(0.27067056647322538378, p1.PMF(2), PLACES);
		RoundedAssertEquals(0.18044704431548358919, p1.PMF(3), PLACES);
		PoissonDistribution p2 = new PoissonDistribution(5);
		RoundedAssertEquals(0.0067379469990854, p2.PMF(0), PLACES);
		RoundedAssertEquals(0.0336897349954273, p2.PMF(1), PLACES);
		RoundedAssertEquals(0.0842243374885683, p2.PMF(2), PLACES);
	}
}
