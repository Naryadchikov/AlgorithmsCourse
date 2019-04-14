package com.algorithms.stack;

public interface Stack<T> extends Iterable<T> {

  /**
   * Insert a new item onto stack
   *
   * @param item item to be inserted
   */
  void push(T item);

  /**
   * Remove and return the most recently added item
   *
   * @return the most recently added item
   */
  T pop();

  /**
   * Return is the stack empty
   *
   * @return is the stack empty
   */
  boolean isEmpty();

}
