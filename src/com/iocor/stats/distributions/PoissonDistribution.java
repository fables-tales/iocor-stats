package com.iocor.stats.distributions;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.iocor.stats.MathHelper;

/**
 * implements the poisson distribution
 * 
 * @author Sam Phippen (samphippen@gmail.com)
 * 
 */
public class PoissonDistribution implements IDiscreteProbabilityDistribution {
	private double lambda;
	private double instanceConstant;

	/**
	 * 
	 * @param Lambda
	 *            the mean and variance of the distribution
	 * @throws IllegalArgumentException
	 *             thrown when lambda <= 0 or is not a number
	 */
	public PoissonDistribution(double Lambda) throws IllegalArgumentException {
		if (Lambda > 0 && !Double.isNaN(Lambda)) {
			this.lambda = Lambda;
			this.instanceConstant = MathHelper.Exp(-this.lambda);
		} else {
			throw new IllegalArgumentException(
					"lambda must be greater than zero");
		}
	}

	@Override
	public double CDF(int x) {
		double sum = 0;
		for (int i = 0; i <= x; i++) {
			sum += PMF(x);
		}
		return sum;
	}

	@Override
	/*
	 * * x must be greater than zero for this function
	 */
	public double PMF(int x) {
		return this.instanceConstant * Math.pow(this.lambda, x)
				/ MathHelper.Factorial(x);
	}

	@Override
	public double Mean() {
		
		return this.lambda;
	}

	@Override
	public double Median() {
		
		return Math.floor(this.lambda + (1 / 3) + 0.02 / this.lambda);
	}

	@Override
	public double Mode() {
		double floorL = Math.floor(this.lambda);
		if(this.lambda == floorL){
			return this.lambda - 1;
		}
		return floorL;
	}

	@Override
	public double StandardDeviation() {
		
		return MathHelper.SquareRoot(this.lambda);
	}

	@Override
	public double Variance() {
		
		return this.lambda;
	}

}
