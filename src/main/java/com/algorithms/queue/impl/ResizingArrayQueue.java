package com.algorithms.queue.impl;

import com.algorithms.queue.Queue;

public class ResizingArrayQueue<T> implements Queue<T> {

  private T[] q;
  private int head;
  private int tail;
  private int N;

  public ResizingArrayQueue() {
    q = (T[]) new Object[2];
  }

  @Override
  public void enqueue(T item) {
    if (item != null) {
      if (N == q.length) {
        resize(2 * q.length); // repeated doubling
      }

      q[tail++] = item;

      if (tail == q.length) {
        tail = 0; // wrap-around
      }

      N++;
    }
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      throw new IllegalArgumentException();
    }

    T item = q[head];

    q[head++] = null;
    N--;

    if (head == q.length) {
      head = 0; // wrap-around
    }

    if (N > 0 && N == q.length / 4) {
      resize(q.length / 2);
    }

    return item;
  }

  @Override
  public boolean isEmpty() {
    return head == tail;
  }

  private void resize(int capacity) {
    T[] copy = (T[]) new Object[capacity];

    for (int i = 0; i < N; i++) {
      copy[i] = q[(head + i) % q.length];
    }

    head = 0;
    tail = N;
    q = copy;
  }

}
