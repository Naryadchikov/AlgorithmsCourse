package com.algorithms.unionfind.impl;

import com.algorithms.unionfind.UF;

public class QuickUnionUF implements UF {

	private int[] id;
	private int count;

	public QuickUnionUF(int N) {
		id = new int[N];
		count = N;

		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	@Override
	public void union(int p, int q) {
		int pRoot = getRoot(p);
		int qRoot = getRoot(q);

		id[pRoot] = id[qRoot];
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
			i = id[i];
		}

		return i;
	}

}
