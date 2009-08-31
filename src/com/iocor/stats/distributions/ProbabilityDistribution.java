package com.iocor.stats.distributions;

/**
 * information for a base probability distribution
 * 
 * @author Sam Phippen (samphippen@gmail.com)
 * 
 */
public interface ProbabilityDistribution {

	/**
	 * 
	 * @return the mean of the probability distribution
	 */
	public double Mean();

	/**
	 * 
	 * @return the median of the probability distribution
	 */
	public double Median();

	/**
	 * 
	 * @return the mode of the probability distribution
	 */
	public double Mode();

	/**
	 * 
	 * @return the standard deviation of the probability distribution
	 */
	public double StandardDeviation();

	/**
	 * 
	 * @return the variance of the probability distribution
	 */
	public double Variance();
}
