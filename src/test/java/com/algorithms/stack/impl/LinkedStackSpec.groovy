package com.algorithms.stack.impl

import com.algorithms.stack.Stack
import org.junit.Test
import spock.lang.Specification

class LinkedStackSpec extends Specification {

    Stack<String> linkedStack = new LinkedStack<>()

    def setup() {
        linkedStack.push("to")
        linkedStack.push("be")
        linkedStack.push("or")
        linkedStack.push("not")
        linkedStack.push("to")
        linkedStack.push("be")
    }

    @Test
    def "should return right items when pop"() {
        expect:
        linkedStack.pop() == "be"
        linkedStack.pop() == "to"
        linkedStack.pop() == "not"
        linkedStack.pop() == "or"
        linkedStack.pop() == "be"
        linkedStack.pop() == "to"
    }

    @Test
    def "should return false when stack is not empty"() {
        expect:
        !linkedStack.isEmpty()
    }

    @Test
    def "should return true when stack is empty"() {
        given:
        linkedStack = new LinkedStack<>()
        expect:
        linkedStack.isEmpty()
    }

    @Test
    def "should not add null item onto stack"() {
        when:
        linkedStack.push(null)
        then:
        linkedStack.pop() != null
    }

    @Test
    def "should throw exception when try to pop an empty stack"() {
        given:
        linkedStack = new LinkedStack<>()
        when:
        linkedStack.pop()
        then:
        thrown(IllegalArgumentException)
    }

}
