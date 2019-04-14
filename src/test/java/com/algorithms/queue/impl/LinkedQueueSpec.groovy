package com.algorithms.queue.impl

import com.algorithms.queue.Queue
import org.junit.Test
import spock.lang.Specification

class LinkedQueueSpec extends Specification {

    Queue<String> linkedQueue = new LinkedQueue<>()

    def setup() {
        linkedQueue.enqueue("to")
        linkedQueue.enqueue("be")
        linkedQueue.enqueue("or")
        linkedQueue.enqueue("not")
        linkedQueue.enqueue("to")
        linkedQueue.enqueue("be")
    }

    @Test
    def "should return right items when dequeue"() {
        expect:
        linkedQueue.dequeue() == "to"
        linkedQueue.dequeue() == "be"
        linkedQueue.dequeue() == "or"
        linkedQueue.dequeue() == "not"
        linkedQueue.dequeue() == "to"
        linkedQueue.dequeue() == "be"
    }

    @Test
    def "should return false when queue is not empty"() {
        expect:
        !linkedQueue.isEmpty()
    }

    @Test
    def "should return true when queue is empty"() {
        given:
        linkedQueue = new LinkedQueue<>()
        expect:
        linkedQueue.isEmpty()
    }

    @Test
    def "should throw exception when try to dequeue an empty queue"() {
        given:
        linkedQueue = new LinkedQueue<>()
        when:
        linkedQueue.dequeue()
        then:
        thrown(IllegalArgumentException)
    }

}
