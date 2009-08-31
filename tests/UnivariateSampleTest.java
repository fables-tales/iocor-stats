import com.iocor.stats.samples.UnivariateSample;

import junit.framework.TestCase;



public class UnivariateSampleTest extends TestCase {
	public void testMode(){
		UnivariateSample us = new UnivariateSample();
		us.AddItem(3.0);
		us.AddItem(3.0);
		us.AddItem(3.0);
		us.AddItem(1.0);
		assertEquals(3.0, us.Mode());
	}
}
