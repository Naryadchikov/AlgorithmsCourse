package com.algorithms.stack.impl;

import com.algorithms.stack.Stack;
import java.util.Iterator;

public class ResizingArrayStack<T> implements Stack<T> {

  private T[] s;
  private int N;

  public ResizingArrayStack() {
    s = (T[]) new Object[2];
  }

  @Override
  public void push(T item) {
    if (item != null) {
      if (N == s.length) {
        resize(2 * s.length); // repeated doubling
      }

      s[N++] = item;
    }
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      throw new IllegalArgumentException();
    }

    T item = s[--N];

    s[N] = null;

    if (N > 0 && N == s.length / 4) {
      resize(s.length / 2);
    }

    return item;
  }

  @Override
  public boolean isEmpty() {
    return N == 0;
  }

  @Override
  public Iterator<T> iterator() {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<T> {

    private int i = N;

    @Override
    public boolean hasNext() {
      return i > 0;
    }

    @Override
    public T next() {
      return s[--i];
    }

  }

  private void resize(int capacity) {
    T[] copy = (T[]) new Object[capacity];

    for (int i = 0; i < N; i++) {
      copy[i] = s[i];
    }

    s = copy;
  }

}
