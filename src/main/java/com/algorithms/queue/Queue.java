package com.algorithms.queue;

public interface Queue<T> {

  /**
   * Insert a new item onto queue
   *
   * @param item item to be inserted
   */
  void enqueue(T item);

  /**
   * Remove and return least recently added item
   *
   * @return least recently added item
   */
  T dequeue();

  /**
   * Return is the queue empty
   *
   * @return is the queue empty
   */
  boolean isEmpty();

}
