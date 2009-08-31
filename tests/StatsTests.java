import junit.framework.Test;
import junit.framework.TestSuite;


public class StatsTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for default package");
		//$JUnit-BEGIN$
		suite.addTestSuite(NormalDistributionTests.class);
		suite.addTestSuite(PoissonTests.class);
		//$JUnit-END$
		return suite;
	}

}
