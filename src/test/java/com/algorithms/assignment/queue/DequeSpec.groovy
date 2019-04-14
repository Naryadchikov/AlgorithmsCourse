package com.algorithms.assignment.queue


import org.junit.Test
import spock.lang.Specification

class DequeSpec extends Specification {

    Deque<String> deque = new Deque<>()

    def setup() {
        deque.addLast("or")
        deque.addLast("not")
        deque.addLast("to")
        deque.addLast("be")
        deque.addFirst("be")
        deque.addFirst("to")
    }

    @Test
    def "should return right items when removeFirst"() {
        expect:
        deque.removeFirst() == "to"
        deque.removeFirst() == "be"
        deque.removeFirst() == "or"
        deque.removeFirst() == "not"
        deque.removeFirst() == "to"
        deque.removeFirst() == "be"
    }

    @Test
    def "should return right items when removeLast"() {
        expect:
        deque.removeLast() == "be"
        deque.removeLast() == "to"
        deque.removeLast() == "not"
        deque.removeLast() == "or"
        deque.removeLast() == "be"
        deque.removeLast() == "to"
    }

    @Test
    def "should return false when queue is not empty"() {
        expect:
        !deque.isEmpty()
    }

    @Test
    def "should return true when queue is empty"() {
        given:
        deque = new Deque<>()
        expect:
        deque.isEmpty()
    }

    @Test
    def "should throw exception when try to removeFirst an empty queue"() {
        given:
        deque = new Deque<>()
        when:
        deque.removeFirst()
        then:
        thrown(NoSuchElementException)
    }

}
