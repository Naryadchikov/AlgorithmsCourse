package com.algorithms.queue.impl;

import com.algorithms.queue.Queue;

public class LinkedQueue<T> implements Queue<T> {

  private Node first;
  private Node last;

  private class Node {

    T item;
    Node next;

  }

  @Override
  public void enqueue(T item) {
    if (item != null) {
      Node oldLast = last;

      last = new Node();

      last.item = item;
      last.next = null;

      if (isEmpty()) {
        first = last;
      } else {
        oldLast.next = last;
      }
    }
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      throw new IllegalArgumentException();
    }

    T item = first.item;

    first = first.next;

    if (isEmpty()) {
      last = null;
    }

    return item;
  }

  @Override
  public boolean isEmpty() {
    return first == null;
  }

}
