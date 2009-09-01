package com.iocor.stats.samples;

import java.util.ArrayList;
import java.util.HashMap;

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
		this.data = new ArrayList<Double>();
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
		HashMap<Double, Integer> values = new HashMap<Double, Integer>();
		int greatest = 0;
		for (int i = 0; i < this.data.size(); i++) {
			double key = this.data.get(i);
			int value = 0;
			if (values.containsKey(key)) {
				value = values.get(key) + 1;
				if (value > greatest) {
					greatest = value;
				}
			} else {
				value = 1;
			}
			values.put(key, value);
		}
		double mode = 0;
		for (int i = 0; i < this.data.size(); i++) {
			double key = this.data.get(i);
			double value = values.get(key);
			if (value == greatest) {
				mode = value;
				break;
			}
		}
		return mode;
	}

	public double Variance() {
		return this.StandardDeviation() * this.standardDeviation;
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

	public double Sum() {
		if (this.sumUpdateNeeded) {
			this.UpdateSum();
		}
		return this.sum;
	}

	public double SumOfSquares() {
		if (this.sumOfSquaresUpdateNeeded) {
			this.UpdateSumOfSquares();
		}
		return this.sumOfSquares;
	}

	public ArrayList<Double> getData() {
		return this.data;
	}
}
