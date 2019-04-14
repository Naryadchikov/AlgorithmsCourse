package com.algorithms.assignment.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

  private Node first;
  private Node last;
  private int n;

  private class Node {

    Item item;
    Node next;
    Node prev;

  }

  /**
   * Construct an empty deque
   */
  public Deque() {
  }

  /**
   * Check is the deque empty
   *
   * @return is the deque empty
   */
  public boolean isEmpty() {
    return n == 0;
  }

  /**
   * Return the number of items on the deque
   *
   * @return the number of items on the deque
   */
  public int size() {
    return n;
  }

  /**
   * Add the item to the front
   *
   * @param item item to add
   */
  public void addFirst(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }

    Node oldFirst = first;

    first = new Node();

    first.item = item;

    if (isEmpty()) {
      last = first;
    } else {
      oldFirst.prev = first;
      first.next = oldFirst;
    }

    n++;
  }

  /**
   * Add the item to the end
   *
   * @param item item to add
   */
  public void addLast(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }

    Node oldLast = last;

    last = new Node();

    last.item = item;

    if (isEmpty()) {
      first = last;
    } else {
      oldLast.next = last;
      last.prev = oldLast;
    }

    n++;
  }

  /**
   * Remove and return the item from the front
   *
   * @return the item from the front
   */
  public Item removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    Item item = first.item;

    if (n > 1) {
      first = first.next;
      first.prev = null;
    } else {
      first = null;
      last = null;
    }

    n--;

    return item;
  }

  /**
   * Remove and return the item from the end
   *
   * @return the item from the end
   */
  public Item removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    Item item = last.item;

    if (n > 1) {
      last = last.prev;
      last.next = null;
    } else {
      first = null;
      last = null;
    }

    n--;

    return item;
  }

  /**
   * Return an iterator over items in order from front to end
   *
   * @return an iterator over items in order from front to end
   */
  @Override
  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {

    private Node current = first;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }

      Item item = current.item;

      current = current.next;

      return item;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }

  }

}