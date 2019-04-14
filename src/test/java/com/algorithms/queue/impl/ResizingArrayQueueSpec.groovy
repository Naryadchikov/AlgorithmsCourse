package com.algorithms.queue.impl

import com.algorithms.queue.Queue
import org.junit.Test
import spock.lang.Specification

class ResizingArrayQueueSpec extends Specification {

    Queue<String> resizingArrayQueue = new ResizingArrayQueue<>()

    def setup() {
        resizingArrayQueue.enqueue("to")
        resizingArrayQueue.enqueue("be")
        resizingArrayQueue.enqueue("or")
        resizingArrayQueue.enqueue("not")
        resizingArrayQueue.enqueue("to")
        resizingArrayQueue.enqueue("be")
    }

    @Test
    def "should return right items when dequeue"() {
        expect:
        resizingArrayQueue.dequeue() == "to"
        resizingArrayQueue.dequeue() == "be"
        resizingArrayQueue.dequeue() == "or"
        resizingArrayQueue.dequeue() == "not"
        resizingArrayQueue.dequeue() == "to"
        resizingArrayQueue.dequeue() == "be"
    }

    @Test
    def "should return false when queue is not empty"() {
        expect:
        !resizingArrayQueue.isEmpty()
    }

    @Test
    def "should return true when queue is empty"() {
        given:
        resizingArrayQueue = new ResizingArrayQueue<>()
        expect:
        resizingArrayQueue.isEmpty()
    }

    @Test
    def "should throw exception when try to dequeue an empty queue"() {
        given:
        resizingArrayQueue = new ResizingArrayQueue<>()
        when:
        resizingArrayQueue.dequeue()
        then:
        thrown(IllegalArgumentException)
    }

}
