package com.algorithms.arraysearch;

public class FindInBitonicArray {

	private int[] array;
	private int indexOfMaxElement;

	public FindInBitonicArray(int[] array) {
		this.array = array;
		indexOfMaxElement = findMaxElementIndex(0, array.length - 1);
	}

	public int findIndexOf(int element) {
		int maxElement = array[indexOfMaxElement];

		if (element > maxElement) {
			return -1;
		}

		if (element == maxElement) {
			return indexOfMaxElement;
		}

		int indexInIncreasePart = findInIncreasePart(element);

		if (indexInIncreasePart != -1) {
			return indexInIncreasePart;
		}

		return findInDecreasePart(element);
	}

	public void setArray(int[] array) {
		this.array = array;
		indexOfMaxElement = findMaxElementIndex(0, array.length - 1);
	}

	private int findInIncreasePart(int element) {
		int lo = 0;
		int hi = indexOfMaxElement;

		while (lo <= hi) {
			int mid = (hi + lo) / 2;

			if (array[mid] == element) {
				return mid;
			}

			if (array[mid] > element) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}

		return -1;
	}

	private int findInDecreasePart(int element) {
		int lo = indexOfMaxElement;
		int hi = array.length - 1;

		while (lo <= hi) {
			int mid = (hi + lo) / 2;

			if (array[mid] == element) {
				return mid;
			}

			if (array[mid] < element) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}

		return -1;
	}

	private int findMaxElementIndex(int lo, int hi) {
		if (lo == hi) {
			return lo;
		}

		if (lo + 1 == hi) {
			if (array[lo] > array[hi]) {
				return lo;
			} else {
				return hi;
			}
		}

		int mid = (hi + lo) / 2;

		if (array[mid] > array[mid + 1] && array[mid] > array[mid - 1]) {
			return mid;
		}

		if (array[mid] > array[mid + 1] && array[mid] < array[mid - 1]) {
			return findMaxElementIndex(lo, mid - 1);
		} else {
			return findMaxElementIndex(mid + 1, hi);
		}
	}

}
