package com.algorithms.assignment.queue;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item> {

  private Item[] q;
  private int n;

  /**
   * Construct an empty randomized queue
   */
  public RandomizedQueue() {
    q = (Item[]) new Object[2];
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
   * Insert a new item onto queue
   *
   * @param item item to be inserted
   */
  public void enqueue(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }

    if (n == q.length) {
      resize(2 * q.length);
    }

    q[n++] = item;
  }

  /**
   * Remove and return a random item
   *
   * @return a random item
   */
  public Item dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    int randomId = getRandomIndex();

    Item item = q[randomId];

    q[randomId] = q[n - 1];
    q[n - 1] = null;

    n--;

    if (n > 0 && n == q.length / 4) {
      resize(q.length / 2);
    }

    return item;
  }

  /**
   * Return a random item (but do not remove it)
   *
   * @return a random item
   */
  public Item sample() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    return q[getRandomIndex()];
  }

  /**
   * Return an independent iterator over items in random order
   *
   * @return an independent iterator over items in random order
   */
  @Override
  public Iterator<Item> iterator() {
    return new RandomArrayIterator();
  }

  private class RandomArrayIterator implements Iterator<Item> {

    private int i = n;
    private final Item[] randomArray;

    RandomArrayIterator() {
      randomArray = (Item[]) new Object[n];

      for (int j = 0; j < n; j++) {
        randomArray[j] = q[j];
      }

      StdRandom.shuffle(randomArray);
    }

    @Override
    public boolean hasNext() {
      return i > 0;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }

      return randomArray[--i];
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }

  }

  private void resize(int capacity) {
    Item[] copy = (Item[]) new Object[capacity];

    for (int i = 0; i < n; i++) {
      copy[i] = q[i];
    }

    q = copy;
  }

  private int getRandomIndex() {
    return StdRandom.uniform(0, n);
  }

}
