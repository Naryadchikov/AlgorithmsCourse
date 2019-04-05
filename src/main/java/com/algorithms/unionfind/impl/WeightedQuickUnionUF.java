package com.algorithms.unionfind.impl;

import com.algorithms.unionfind.UF;

public class WeightedQuickUnionUF implements UF {

	private int[] id;
	private int[] sz;
	private int count;

	public WeightedQuickUnionUF(int N) {
		id = new int[N];
		sz = new int[N];
		count = N;

		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	@Override
	public void union(int p, int q) {
		int pRoot = getRoot(p);
		int qRoot = getRoot(q);

		if (pRoot == qRoot) {
			return;
		}

		if (sz[pRoot] > sz[qRoot]) {
			id[qRoot] = id[pRoot];
			sz[pRoot] += sz[qRoot];
		} else {
			id[pRoot] = id[qRoot];
			sz[qRoot] += sz[pRoot];
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

	private int getRoot(int i) {
		while (i != id[i]) {
			id[i] = id[id[i]]; // Extra: adding path compression -> tree becomes much flatter
			i = id[i];
		}

		return i;
	}

}
