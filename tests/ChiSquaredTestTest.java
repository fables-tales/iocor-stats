import junit.framework.TestCase;

import com.iocor.stats.distributions.NormalDistribution;
import com.iocor.stats.samples.UnivariateSample;
import com.iocor.stats.tests.ChiSquaredTest;



public class ChiSquaredTestTest extends TestCase {
	public void testNormalTest(){
		NormalDistribution nd = new NormalDistribution(0, 1);
		
		UnivariateSample uvs = new UnivariateSample();
		
		double lastcdf = 0;
		for (int i = -5; i < 5; i++){
			double nextcdf = nd.CDF(i);
			uvs.AddItem(nextcdf-lastcdf);
			lastcdf = nextcdf;
		}
		
		uvs.AddItem(1-lastcdf);
		ChiSquaredTest cs = new ChiSquaredTest(uvs, nd);
		System.out.println(cs.PassAt());
		
	}
	
}
