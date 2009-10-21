package com.iocor.stats.distributions;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class InverseChiSquaredDistribution implements
		IContinuousProbabilityDistribution {

	private double v;

	public InverseChiSquaredDistribution(double DegreesOfFreedom) {
		this.v = DegreesOfFreedom;
	}

	@Override
	public double CDF(double x) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double PDF(double x) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double Mean() {
		// TODO Auto-generated method stub
		if (this.v > 2) {
			return 1.0 / (this.v - 2);
		} else {
			throw new IllegalStateException("mean not well defined for v <= 2");
		}

	}

	@Override
	public double Median() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double Mode() {
		// TODO Auto-generated method stub
		return 1.0 / (this.v + 2);
	}

	@Override
	public double StandardDeviation() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public double Variance() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

}
