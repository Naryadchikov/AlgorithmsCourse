package com.algorithms.assignment.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

  private boolean[][] grid;
  private final int gridSize;
  private int openedCounter;
  private final WeightedQuickUnionUF uf;

  /**
   * Creates n-by-n grid, with all sites blocked.
   *
   * @param n one side size
   */
  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException();
    }

    grid = new boolean[n][n];
    gridSize = n;
    uf = new WeightedQuickUnionUF(n * n + 2);

    for (int i = 1; i <= n; i++) {
      uf.union(0, i);
    }
  }

  /**
   * Opens site for passed position if it is not open already.
   *
   * @param row position by row
   * @param col position by column
   */
  public void open(int row, int col) {
    if (!isOpen(row, col)) {
      grid[row - 1][col - 1] = true;
      openedCounter++;
      processUnionOperations(row, col);
    }
  }

  /**
   * Shows is site open or not.
   *
   * @param row position by row
   * @param col position by column
   * @return is site open or not
   */
  public boolean isOpen(int row, int col) {
    validate(row, col);

    return grid[row - 1][col - 1];
  }

  /**
   * Shows is site full or not.
   * Full site is an open site that can be connected to an open site in the top row
   * via a chain of neighboring (left, right, up, down) open sites.
   *
   * @param row position by row
   * @param col position by column
   * @return is site full or not
   */
  public boolean isFull(int row, int col) {
    if (isOpen(row, col)) {
      return uf.connected(0, (row - 1) * gridSize + col);
    }

    return false;
  }

  // number of open sites
  public int numberOfOpenSites() {
    return openedCounter;
  }

  // does the system percolate?
  public boolean percolates() {
    return uf.connected(0, gridSize * gridSize + 1);
  }

  private void validate(int row, int col) {
    if (row <= 0 || col <= 0 || row > gridSize || col > gridSize) {
      throw new IllegalArgumentException();
    }
  }

  private void processUnionOperations(int row, int col) {
    if (row > 1 && row < gridSize) {
      tryUnionUp(row, col);
      tryUnionDown(row, col);
      processByCol(row, col);
    } else if (row == gridSize) {
      if (gridSize != 1) {
        tryUnionUp(row, col);
        processByCol(row, col);
      }
      uf.union(gridSize * gridSize + 1, (row - 1) * gridSize + col);
    } else {
      tryUnionDown(row, col);
      processByCol(row, col);
    }
  }

  private void processByCol(int row, int col) {
    if (col > 1 && col < gridSize) {
      tryUnionRight(row, col);
      tryUnionLeft(row, col);
    } else if (col == 1) {
      tryUnionRight(row, col);
    } else {
      tryUnionLeft(row, col);
    }
  }

  private void tryUnionUp(int row, int col) {
    if (grid[row - 2][col - 1]) {
      uf.union((row - 1) * gridSize + col, (row - 2) * gridSize + col);
    }
  }

  private void tryUnionRight(int row, int col) {
    if (grid[row - 1][col]) {
      uf.union((row - 1) * gridSize + col, (row - 1) * gridSize + col + 1);
    }
  }

  private void tryUnionDown(int row, int col) {
    if (grid[row][col - 1]) {
      uf.union((row - 1) * gridSize + col, row * gridSize + col);
    }
  }

  private void tryUnionLeft(int row, int col) {
    if (grid[row - 1][col - 2]) {
      uf.union((row - 1) * gridSize + col, (row - 1) * gridSize + col - 1);
    }
  }

}
