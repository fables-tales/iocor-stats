package com.iocor.stats.samples;

import java.util.ArrayList;

import com.iocor.stats.MathHelper;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class UnivariateSample {
	private ArrayList<Double> data;
	private double sum;
	private double mean;
	private double standardDeviation;
	private double sumOfSquares;
	private boolean sumUpdateNeeded = false;
	private boolean meanUpdateNeeded = false;
	private boolean standardDeviationUpdateNeeded = false;
	private boolean sumOfSquaresUpdateNeeded = false;

	public UnivariateSample() {

	}

	public void AddItem(double value) {
		data.add(value);
		this.Reset();
	}

	private void Reset() {
		this.meanUpdateNeeded = true;
		this.standardDeviationUpdateNeeded = true;
		this.sumUpdateNeeded = true;
		this.sumOfSquaresUpdateNeeded = true;
	}

	private void UpdateSum() {
		double sum = 0;
		for (int i = 0; i < this.data.size(); i++) {
			sum += this.data.get(i);
		}
		this.sum = sum;
		this.sumUpdateNeeded = false;
	}

	private void UpdateSumOfSquares() {
		double sumsquares = 0;
		for (int i = 0; i < this.data.size(); i++) {
			sumsquares += MathHelper.Square(this.data.get(i));
		}
		this.sumOfSquares = sumsquares;
		this.sumOfSquaresUpdateNeeded = false;
	}

	public double Mean() {
		if (this.sumUpdateNeeded) {
			this.UpdateSum();
		}
		if (this.meanUpdateNeeded) {
			this.mean = this.sum / this.data.size();
			this.meanUpdateNeeded = false;
		}
		return this.mean;
	}

	public double Median() {
		throw new NotImplementedException();
	}

	public double Mode() {
		throw new NotImplementedException();
	}

	public double Variance() {
		return this.StandardDeviation();
	}

	public double StandardDeviation() {
		if (this.sumOfSquaresUpdateNeeded) {
			this.UpdateSumOfSquares();
		}
		if (this.standardDeviationUpdateNeeded) {
			this.standardDeviation = (this.sumOfSquares - (this.data.size() * MathHelper.Square(this.Mean()))) / (this.data.size() - 1);
			this.standardDeviation = MathHelper.SquareRoot(this.standardDeviation);
			this.standardDeviationUpdateNeeded = false;
		}
		return this.standardDeviation;
	}

	public ArrayList<Double> getData() {
		return this.data;
	}
}
