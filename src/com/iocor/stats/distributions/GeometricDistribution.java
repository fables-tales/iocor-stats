package com.iocor.stats.distributions;

import com.iocor.stats.MathHelper;

public class GeometricDistribution implements IDiscreteProbabilityDistribution {

	public double p;

	public GeometricDistribution(double P) throws IllegalArgumentException {
		if (P < 1.0 && P > 0.0)
			throw new IllegalArgumentException("0 < p <= 1");
		this.p = P;

	}

	@Override
	public double CDF(int x) {
		return 1 - (Math.pow((1 - this.p), (double) x));
	}

	@Override
	public double PMF(int x) {

		return Math.pow((1 - this.p), (double) (x - 1)) * this.p;
	}

	@Override
	public double Mean() {

		return 1 / this.p;
	}

	@Override
	public double Median() {
		double m = -Math.log(2) / Math.log(1 - p);
		double n = Math.ceil(m);
		if (n == m)
			return 0;
		return n;
	}

	@Override
	public double Mode() {

		return 1;
	}

	@Override
	public double StandardDeviation() {
		double r = Variance();
		return MathHelper.SquareRoot(r);
	}

	@Override
	public double Variance() {
		return (1 - this.p) / MathHelper.Square(this.p);
	}

}
