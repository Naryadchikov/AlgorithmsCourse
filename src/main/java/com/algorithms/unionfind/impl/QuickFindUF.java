package com.algorithms.unionfind.impl;

import com.algorithms.unionfind.UF;

public class QuickFindUF implements UF {

	private int[] id;
	private int count;

	public QuickFindUF(int N) {
		id = new int[N];
		count = N;

		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	@Override
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];

		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid) {
				id[i] = qid;
			}
		}

		count--;
	}

	@Override
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	@Override
	public int getCount() {
		return count;
	}

}