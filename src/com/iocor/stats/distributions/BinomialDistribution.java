package com.iocor.stats.distributions;

import com.iocor.stats.MathHelper;

public class BinomialDistribution implements IDiscreteProbabilityDistribution {

	private int n; // no. of trials
	private double p; // chance of success

	public BinomialDistribution(int N, double P) throws IllegalArgumentException {
		if (N > 0 && P < 1.0 && P > 0.0) {
			this.n = N;
			this.p = P;
		} else {
			throw new IllegalArgumentException("n must be greater than zero; p must satisfy 0 < p < 1");
		}
	}

	@Override
	public double CDF(int x) {
		double sum = 0.0;
		for (int i = 0; i <= x; i++) {
			sum += PMF(i);
		}
		return sum;
	}

	@Override
	public double PMF(int x) {

		return MathHelper.nCr(this.n, x) * Math.pow(this.p, x) * Math.pow(this.p, this.n - x);
	}

	@Override
	public double Mean() {

		return this.p * this.n;
	}

	@Override
	public double Median() {

		return this.p * this.n;
	}

	@Override
	public double Mode() {

		return this.p * this.n;
	}

	@Override
	public double StandardDeviation() {

		return MathHelper.SquareRoot(Variance());
	}

	@Override
	public double Variance() {

		return this.p * this.n * (1.0 - this.p);
	}

}
