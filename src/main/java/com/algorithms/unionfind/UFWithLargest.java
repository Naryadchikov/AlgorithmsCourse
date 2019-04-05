package com.algorithms.unionfind;

public interface UFWithLargest extends UF {

  /**
   * Returns the largest element in the component containing i
   *
   * @param i element
   * @return the largest element in the component containing i
   */
  int getLargest(int i);

}
