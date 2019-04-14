package com.algorithms.stack.impl;

import com.algorithms.stack.Stack;
import java.util.Iterator;

public class LinkedStack<T> implements Stack<T> {

  private Node first = null;

  private class Node {

    T item;
    Node next;

  }

  @Override
  public void push(T item) {
    if (item != null) {
      Node oldFirst = first;

      first = new Node();
      first.item = item;
      first.next = oldFirst;
    }
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      throw new IllegalArgumentException();
    }

    T item = first.item;

    first = first.next;

    return item;
  }

  @Override
  public boolean isEmpty() {
    return first == null;
  }

  @Override
  public Iterator<T> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<T> {

    private Node current = first;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public T next() {
      if (!hasNext()) {
        throw new IllegalArgumentException();
      }

      T item = current.item;

      current = current.next;

      return item;
    }

  }

}
