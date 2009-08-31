package com.iocor.stats.distributions;

/**
 * information for a base probability distribution
 * 
 * @author Sam Phippen (samphippen@gmail.com)
 *
 */
public interface ProbabilityDistribution {
	public double Mean();
	
	public double Median();
	
	public double Mode();
	
	public double StandardDeviation();
	
	public double Variance();
}
