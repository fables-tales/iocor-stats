import com.iocor.stats.MathHelper;
import com.iocor.stats.distributions.NormalDistribution;

import junit.framework.Assert;
import junit.framework.TestCase;

public class NormalDistributionTests extends TestCase {
	public void testConstructor() {
		NormalDistribution d1 = new NormalDistribution();
		Assert.assertEquals(0.0, d1.Mean());
		Assert.assertEquals(0.0, d1.Mode());
		Assert.assertEquals(0.0, d1.Median());
		Assert.assertEquals(1.0, d1.StandardDeviation());
		Assert.assertEquals(1.0, d1.Variance());
		try {
			@SuppressWarnings("unused")
			NormalDistribution d2 = new NormalDistribution(0.0, -1.0);
			fail("setting a negative standard devation did not cause an exception");
		} catch (IllegalArgumentException IAE) {

		}
		NormalDistribution d3 = new NormalDistribution(0.0, 2.0);
		Assert.assertEquals(0.0, d3.Mean());
		Assert.assertEquals(0.0, d3.Mode());
		Assert.assertEquals(0.0, d3.Median());
		Assert.assertEquals(2.0, d3.StandardDeviation());
		Assert.assertEquals(4.0, d3.Variance());
	}

	public void testCDF() {
		NormalDistribution d1 = new NormalDistribution();
		Assert
				.assertEquals(0.5, Double.valueOf(MathHelper
						.Round(d1.CDF(0), 5)));
		// hax, no idea why this is necessary
		Assert.assertEquals(MathHelper.Round(0.68269, 5), MathHelper.Round(d1
				.CDF(1)
				- d1.CDF(-1), 5));
	}
}
