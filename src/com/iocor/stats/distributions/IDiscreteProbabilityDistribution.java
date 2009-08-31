package com.iocor.stats.distributions;

public interface IDiscreteProbabilityDistribution extends IProbabilityDistribution {
	public double PMF(int x);

	public double CDF(int x);

}
