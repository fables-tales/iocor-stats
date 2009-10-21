package com.iocor.stats.distributions;

import com.iocor.stats.MathHelper;

public class ChiSquaredDistribution implements
		IContinuousProbabilityDistribution {
	private double k;

	public ChiSquaredDistribution(double k) {
		this.k = k;
	}

	@Override
	public double CDF(double x) {
		// TODO Auto-generated method stub
		double top = MathHelper.LowerIncompleteGamma(this.k / 2, x / 2);
		return top / MathHelper.Gamma(this.k / 2);
	}

	@Override
	public double PDF(double x) {
		// TODO Auto-generated method stub
		double top = Math.pow(0.5, k / 2);
		double bottom = MathHelper.Gamma(k / 2);
		double two = Math.pow(x, k / 2 - 1);
		double three = MathHelper.Exp(-x / 2);
		return (top / bottom) * two * three;
	}

	@Override
	public double Mean() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double Median() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double Mode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double StandardDeviation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double Variance() {
		// TODO Auto-generated method stub
		return 0;
	}

}
