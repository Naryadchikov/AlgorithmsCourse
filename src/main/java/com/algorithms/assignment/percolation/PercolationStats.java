package com.algorithms.assignment.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

  private static final double CONFIDENCE_95 = 1.96;

  private final double[] openSitesAmountArray;
  private double mean = -1;
  private double stddev = -1;

  /**
   * Performs trials independent experiments on an n-by-n grid.
   *
   * @param n grid size
   * @param trials repetition times
   */
  public PercolationStats(int n, int trials) {
    if (n <= 0 || trials <= 0) {
      throw new IllegalArgumentException();
    }

    openSitesAmountArray = new double[trials];

    for (int i = 0; i < trials; i++) {
      Percolation percolationSystem = new Percolation(n);

      while (!percolationSystem.percolates()) {
        int row = StdRandom.uniform(n) + 1;
        int col = StdRandom.uniform(n) + 1;

        while (percolationSystem.isOpen(row, col)) {
          row = StdRandom.uniform(n) + 1;
          col = StdRandom.uniform(n) + 1;
        }

        percolationSystem.open(row, col);
      }

      openSitesAmountArray[i] = 1.0 * percolationSystem.numberOfOpenSites() / (n * n);
    }
  }

  /**
   * Returns sample mean of percolation threshold.
   *
   * @return sample mean of percolation threshold
   */
  public double mean() {
    if (mean < 0.0) {
      mean = StdStats.mean(openSitesAmountArray);
    }

    return mean;
  }

  /**
   * Returns sample standard deviation of percolation threshold.
   *
   * @return sample standard deviation of percolation threshold
   */
  public double stddev() {
    if (stddev < 0.0) {
      stddev = StdStats.stddev(openSitesAmountArray);
    }

    return stddev;
  }

  /**
   * Returns low endpoint of 95% confidence interval.
   *
   * @return low endpoint of 95% confidence interval
   */
  public double confidenceLo() {
    if (isSingleTrial()) {
      return Double.NaN;
    }

    return mean() - CONFIDENCE_95 * stddev() / Math.sqrt(openSitesAmountArray.length);
  }

  /**
   * Returns high endpoint of 95% confidence interval.
   *
   * @return high endpoint of 95% confidence interval
   */
  public double confidenceHi() {
    if (isSingleTrial()) {
      return Double.NaN;
    }

    return mean() + CONFIDENCE_95 * stddev() / Math.sqrt(openSitesAmountArray.length);
  }

  private boolean isSingleTrial() {
    return openSitesAmountArray.length == 1;
  }

  /**
   * Test client for checking percolation stats.
   *
   * @param args input arguments (first - grid size; second - trials)
   */
  public static void main(String[] args) {
    try {
      int n = Integer.parseInt(args[0]);
      int trials = Integer.parseInt(args[1]);
      PercolationStats stats = new PercolationStats(n, trials);

      System.out.println("mean                    = " + stats.mean());
      System.out.println("stddev                  = " + stats.stddev());
      System.out.println(
          "95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    } catch (NumberFormatException ex) {
      System.out.println("The first two arguments must be integers.");
    }
  }

}
