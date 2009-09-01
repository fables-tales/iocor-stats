import com.iocor.stats.MathHelper;
import com.iocor.stats.distributions.BinomialDistribution;

import junit.framework.Assert;
import junit.framework.TestCase;

public class BinomialDistributionTests extends TestCase {
	public static final int PLACES = 8;

	public static void RoundedAssertEquals(double a, double b, int places) {
		assertEquals(MathHelper.Round(a, places), MathHelper.Round(b, places));
	}

	public void testConstructor() {
		BinomialDistribution b1 = new BinomialDistribution(3, 0.5);
		Assert.assertEquals(1.5, b1.Mean());
		Assert.assertEquals(0.75, b1.Variance());
	}
}
