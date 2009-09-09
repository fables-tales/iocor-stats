package com.iocor.stats.samples;

import java.util.ArrayList;
import java.util.HashMap;

import com.iocor.stats.CachedValue;
import com.iocor.stats.MathHelper;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * impliments a univariate sample of continuous data
 * 
 * @author Sam Phippen (samphippen@gmail.com)
 * 
 */
public class UnivariateSample {
	private ArrayList<Double> data;
	/*
	 * private double sum; private double mean; private double
	 * standardDeviation; private double sumOfSquares; private boolean
	 * sumUpdateNeeded = false; private boolean meanUpdateNeeded = false;
	 * private boolean standardDeviationUpdateNeeded = false; private boolean
	 * sumOfSquaresUpdateNeeded = false;
	 */
	private CachedValue<Double> sum;
	private CachedValue<Double> mean;
	private CachedValue<Double> standardDeviation;
	private CachedValue<Double> sumOfSquares;

	public UnivariateSample() {
		this.data = new ArrayList<Double>();
		this.sum = new CachedValue<Double>(Double.NaN);
		this.mean = new CachedValue<Double>(Double.NaN);
		this.standardDeviation = new CachedValue<Double>(Double.NaN);
		this.sumOfSquares = new CachedValue<Double>(Double.NaN);
	}

	public void AddItem(double value) {
		data.add(value);
		this.Reset();
	}

	private void Reset() {
		this.sum.SetOutDated();
		this.mean.SetOutDated();
		this.sumOfSquares.SetOutDated();
		this.standardDeviation.SetOutDated();
	}

	private void UpdateSum() {
		double sum = 0;
		for (int i = 0; i < this.data.size(); i++) {
			sum += this.data.get(i);
		}
		this.sum.SetValue(sum);
	}

	private void UpdateSumOfSquares() {
		double sumsquares = 0;
		for (int i = 0; i < this.data.size(); i++) {
			sumsquares += MathHelper.Square(this.data.get(i));
		}
		this.sumOfSquares.SetValue(sumsquares);
	}

	public double Mean() {
		if (this.sum.GetUpdateNeeded()) {
			this.UpdateSum();
		}
		if (this.mean.GetUpdateNeeded()) {
			this.mean.SetValue(this.sum.GetValue() / this.data.size());
		}
		return this.mean.GetValue();
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
		return this.StandardDeviation() * this.StandardDeviation();
	}

	public double StandardDeviation() {
		if (this.sumOfSquares.GetUpdateNeeded()) {
			this.UpdateSumOfSquares();
		}
		if (this.standardDeviation.GetUpdateNeeded()) {
			this.standardDeviation.SetValue((this.sumOfSquares.GetValue() - (this.data.size() * MathHelper.Square(this.Mean()))) / (this.data.size() - 1));
			this.standardDeviation.SetValue(MathHelper.SquareRoot(this.standardDeviation.GetValue()));
		}
		return this.standardDeviation.GetValue();
	}

	public double Sum() {
		if (this.sum.GetUpdateNeeded()) {
			this.UpdateSum();
		}
		return this.sum.GetValue();
	}

	public double SumOfSquares() {
		if (this.sumOfSquares.GetUpdateNeeded()) {
			this.UpdateSumOfSquares();
		}
		return this.sumOfSquares.GetValue();
	}

	public ArrayList<Double> getData() {
		return this.data;
	}
}
