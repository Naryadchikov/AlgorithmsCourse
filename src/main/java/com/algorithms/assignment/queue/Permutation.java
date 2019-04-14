package com.algorithms.assignment.queue;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {

  /**
   * Client, that that takes an integer k as a command-line argument,
   * reads in a sequence of strings from standard input
   * and prints exactly k of them, uniformly at random.
   *
   * @param args input argument (number of strings to print)
   */
  public static void main(String[] args) {
    RandomizedQueue<String> rq = new RandomizedQueue<>();

    while (!StdIn.isEmpty()) {
      rq.enqueue(StdIn.readString());
    }

    int n = Integer.parseInt(args[0]);

    for (int i = 0; i < n; i++) {
      StdOut.println(rq.dequeue());
    }
  }

}
