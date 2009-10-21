import junit.framework.Test;
import junit.framework.TestSuite;

public class StatsTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for iocor-stats");
		// $JUnit-BEGIN$
		suite.addTestSuite(NormalDistributionTests.class);
		suite.addTestSuite(PoissonTests.class);
		suite.addTestSuite(UnivariateSampleTest.class);
		suite.addTestSuite(BinomialDistributionTests.class);
		suite.addTestSuite(ChiSquaredTestTest.class);
		// $JUnit-END$
		return suite;
	}

}
