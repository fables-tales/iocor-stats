package com.iocor.stats.distributions;

import com.iocor.stats.MathHelper;

/**
 * 
 * @author Sam Phippen (samphippen@gmail.com)
 * 
 */
public class NormalDistribution implements IContinuousProbabilityDistribution {
	/**
	 * the value used for the PDF at the beginning
	 */
	// private static final double NormalDistributionPDFConstant = 1.0 /
	// (MathHelper.SquareRoot(2.0 * Math.PI));
	private static final double NormalDistributionPDFConstant = 0.39894228040143267793994605;

	private double mu;
	private double sigma;
	private double InstanceConstant;

	/**
	 * constructs a new normal distribution with mean 0 and standard deviation
	 * of 1
	 */
	public NormalDistribution() {
		this.mu = 0.0;
		this.sigma = 1.0;
		this.InstanceConstant = NormalDistributionPDFConstant;
	}

	/**
	 * constructs a new normal distribution with the specified mean and standard
	 * deviation
	 * 
	 * @param Mu
	 *            the mean of the distribution
	 * @param Sigma
	 *            the standard deviation of the distribution
	 * @throws IllegalArgumentException
	 *             thrown when Sigma <= 0.0
	 */
	public NormalDistribution(double Mu, double Sigma) throws IllegalArgumentException {
		if (Sigma > 0) {
			this.mu = Mu;
			this.sigma = Sigma;
			this.InstanceConstant = NormalDistributionPDFConstant / this.sigma;
		} else {
			throw new IllegalArgumentException("Standard deviation must be greater than zero");
		}
	}

	private double InnerCalculation(double x) {
		double Exponent = (-MathHelper.Square(x - this.mu)) / (2 * MathHelper.Square(this.sigma));
		return MathHelper.Exp(Exponent);
	}

	@Override
	public double CDF(double x) {
		double value = 0;
		double last = 0;
		double trapeziumWidth = 0.005 * this.sigma;
		for (double i = -100 * this.sigma - this.mu; i < x; i += trapeziumWidth) {
			double pdf = this.InnerCalculation(i);
			value += MathHelper.TrapeziumArea(trapeziumWidth, last, pdf);
			last = pdf;
		}
		return value * this.InstanceConstant;
	}

	@Override
	public double PDF(double x) {
		return this.InstanceConstant * this.InnerCalculation(x);
	}

	@Override
	public double Mean() {
		return this.mu;
	}

	@Override
	public double Median() {
		return this.mu;
	}

	@Override
	public double Mode() {
		return this.mu;
	}

	@Override
	public double StandardDeviation() {
		return this.sigma;
	}

	@Override
	public double Variance() {
		return MathHelper.Square(this.sigma);
	}

}
