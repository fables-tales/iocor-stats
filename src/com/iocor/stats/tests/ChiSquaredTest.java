package com.iocor.stats.tests;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.iocor.stats.distributions.IContinuousProbabilityDistribution;
import com.iocor.stats.samples.UnivariateSample;

public class ChiSquaredTest {
	private UnivariateSample uvs;
	private IContinuousProbabilityDistribution cpd;

	public ChiSquaredTest(UnivariateSample uvs,
			IContinuousProbabilityDistribution cpd) {
		this.uvs = uvs;
		this.cpd = cpd;
	}

	private double TestStatistic() {
		List<Double> Expected = new ArrayList<Double>();
		double lastcdf = 0;

		for (int i = 0; i < uvs.getData().size(); i++) {
			int position = i + 1;
			double newcdf = cpd.CDF(position);
			Expected.add(Math.abs(newcdf - lastcdf));
			if (i == uvs.getData().size() - 1) {
				Expected.set(i, 1 - lastcdf);
			}
			lastcdf = newcdf;
		}

		List<Double> Actual = new ArrayList<Double>();

		for (int i = 0; i < uvs.getData().size(); i++) {
			Actual.add((double) uvs.Frequency(i + 1));
		}

		// merge classes expected smaller than 5
		int i = 1;
		while (i < Expected.size()) {
			if (Expected.get(i) <= 5) {
				double newval = Expected.get(i) + Expected.get(i - 1);
				double xval = Actual.get(i) + Actual.get(i - 1);
				Expected.set(i - 1, newval);
				Actual.set(i - 1, xval);
				Expected.remove(i);
				Actual.remove(i);
			}

			i++;
		}

		assert Actual.size() == Expected.size();

		double stat = 0;
		for (int j = 0; j < Actual.size(); j++) {
			stat += Math.pow(Actual.get(j) - Expected.get(j), 2)
					/ Expected.get(j);
		}

		return stat;
	}

	public double PassAt() {
		double ts = this.TestStatistic();
		return 1.0 - this.cpd.CDF(ts);
	}

	public boolean Passes(double minconfidence) {
		return this.PassAt() >= minconfidence;
	}
}
