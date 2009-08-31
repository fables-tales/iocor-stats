package com.iocor.stats.distributions;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.iocor.stats.MathHelper;

public class PoissonDistribution implements IDiscreteProbabilityDistribution {
	private double lambda;

	public PoissonDistribution(double Lambda) throws IllegalArgumentException {
		if (Lambda > 0 && !Double.isNaN(Lambda)) {
			this.lambda = Lambda;
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
	public double PMF(int x) {
		return MathHelper.Exp(-this.lambda) * Math.pow(this.lambda, x) / MathHelper.Factorial(x);
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