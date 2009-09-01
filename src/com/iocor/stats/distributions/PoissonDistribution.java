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
			throw new IllegalArgumentException("lambda must be greater than zero");
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
		return this.instanceConstant * Math.pow(this.lambda, x) / MathHelper.Factorial(x);
	}

	@Override
	public double Mean() {
		// TODO Auto-generated method stub
		return this.lambda;
	}

	@Override
	public double Median() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public double Mode() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public double StandardDeviation() {
		// TODO Auto-generated method stub
		return MathHelper.SquareRoot(this.lambda);
	}

	@Override
	public double Variance() {
		// TODO Auto-generated method stub
		return this.lambda;
	}

}
