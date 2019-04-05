package com.algorithms.unionfind.impl;

import com.algorithms.unionfind.UFWithLargest;

public class WeightedQuickUnionUFWithLargest implements UFWithLargest {

	private int[] id;
	private int[] sz;
	private int[] largest;
	private int count;

	public WeightedQuickUnionUFWithLargest(int N) {
		id = new int[N];
		sz = new int[N];
		largest = new int[N];
		count = N;

		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
			largest[i] = i;
		}
	}

	@Override
	public void union(int p, int q) {
		int pRoot = getRoot(p);
		int qRoot = getRoot(q);

		if (pRoot == qRoot) {
			return;
		}

		int pLargest = largest[pRoot];
		int qLargest = largest[qRoot];

		if (sz[pRoot] > sz[qRoot]) {
			id[qRoot] = id[pRoot];
			sz[pRoot] += sz[qRoot];

			if (pLargest < qLargest) {
				largest[pRoot] = qLargest;
			}
		} else {
			id[pRoot] = id[qRoot];
			sz[qRoot] += sz[pRoot];

			if (qLargest < pLargest) {
				largest[qRoot] = pLargest;
			}
		}

		count--;
	}

	@Override
	public boolean connected(int p, int q) {
		return getRoot(p) == getRoot(q);
	}

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public int getLargest(int i) {
		return largest[getRoot(i)];
	}

	private int getRoot(int i) {
		while (i != id[i]) {
			id[i] = id[id[i]]; // Extra: adding path compression -> tree becomes much flatter
			i = id[i];
		}

		return i;
	}

}
