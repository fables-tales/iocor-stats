package com.iocor.stats.distributions;

/**
 * information for a Continuous Probability Distribution
 * 
 * @author Sam Phippen (samphippen@gmail.com)
 * 
 */
public interface IContinuousProbabilityDistribution extends
		IProbabilityDistribution {

	/**
	 * the Probability Density Funcion of the distribution
	 * 
	 * @param x
	 * @return probability density at value x
	 */
	public double PDF(double x);

	/**
	 * 
	 * @param x
	 * @return the cumulative probability at x
	 */
	public double CDF(double x);
	
	
}
