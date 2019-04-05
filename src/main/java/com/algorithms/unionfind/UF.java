package com.algorithms.unionfind;

public interface UF {

	/**
	 * Add connection between p and q elements
	 *
	 * @param p p element
	 * @param q q element
	 */
	void union(int p, int q);

	/**
	 * Returns are p and q in the same component?
	 *
	 * @param p p element
	 * @param q q element
	 * @return are p and q in the same component?
	 */
	boolean connected(int p, int q);

	/**
	 * Returns number of components
	 *
	 * @return number of components
	 */
	int getCount();

}
