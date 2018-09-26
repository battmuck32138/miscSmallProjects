package hw2;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;


public class PercolationStats {
    private int N;
    private int T;
    private PercolationFactory pf;
    private double[] results;


    // perform T indep
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        this.N = N;
        this.T = T;
        this.pf = pf;
        this.results = new double[T];
        double singleExperiment;

        for (int i = 0; i < results.length; i++) {
            Percolation p = pf.make(N);
            while (!p.percolates()) {
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);
                p.open(row, col);
            }
            singleExperiment = p.numberOfOpenSites() / ((double) N * N);
            results[i] = singleExperiment;
        }
    }


    // sample mean of
    public double mean() {
        return StdStats.mean(results);
    }


    // sample standard
    public double stddev() {
        return StdStats.stddev(results);
    }


    // low endpoint of
    public double confidenceLow() {
        double avg = mean();
        double sdev = stddev();
        return avg - (1.96 * sdev) / Math.sqrt(((double) T));
    }


    // high endpoint o
    public double confidenceHigh() {
        double avg = mean();
        double sdev = stddev();
        return avg + (1.96 * sdev) / Math.sqrt(((double) T));

    }

}
