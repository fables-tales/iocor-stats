import com.iocor.stats.MathHelper;
import com.iocor.stats.samples.UnivariateSample;

import junit.framework.TestCase;

public class UnivariateSampleTest extends TestCase {
	public void testMode() {
		UnivariateSample us = new UnivariateSample();
		us.AddItem(3.0);
		us.AddItem(3.0);
		us.AddItem(3.0);
		us.AddItem(1.0);
		assertEquals(3.0, us.Mode());
	}

	public void testMean() {
		UnivariateSample us = new UnivariateSample();
		us.AddItem(1.0);
		assertEquals(1.0, us.Mean());
		us.AddItem(2.0);
		assertEquals(1.5, us.Mean());
		us.AddItem(3.0);
		assertEquals(2.0, us.Mean());
	}

	public void testStandardDeviation() {
		UnivariateSample us = new UnivariateSample();
		us.AddItem(1.0);
		us.AddItem(1.0);
		assertEquals(0.0, us.StandardDeviation());
		us = new UnivariateSample();
		us.AddItem(1.0);
		us.AddItem(2.0);
		assertEquals(MathHelper.SquareRoot(2.0) / 2, us.StandardDeviation());
		us.AddItem(3.0);
		assertEquals(1.0, us.StandardDeviation());
		us = new UnivariateSample();
		us.AddItem(1.0);
		assertEquals(Double.NaN, us.StandardDeviation());
		
	}
}
