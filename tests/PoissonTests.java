import com.iocor.stats.distributions.PoissonDistribution;

import junit.framework.Assert;
import junit.framework.TestCase;

public class PoissonTests extends TestCase {
	public void testConstructor() {
		PoissonDistribution p1 = new PoissonDistribution(1);
		Assert.assertEquals(1.0, p1.Mean());
		Assert.assertEquals(1.0, p1.Variance());
		
	}
	public void testPMF(){
		PoissonDistribution p1 = new PoissonDistribution(2);
		assertEquals(0.13533528323661269189, p1.PMF(0));
		assertEquals(0.27067056647322538378, p1.PMF(1));
	}
}
