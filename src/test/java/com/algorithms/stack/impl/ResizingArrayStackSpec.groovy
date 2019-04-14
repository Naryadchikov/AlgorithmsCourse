package com.algorithms.stack.impl

import com.algorithms.stack.Stack
import org.junit.Test
import spock.lang.Specification

class ResizingArrayStackSpec extends Specification {

    Stack<String> resizingArrayStack = new ResizingArrayStack<>()

    def setup() {
        resizingArrayStack.push("to")
        resizingArrayStack.push("be")
        resizingArrayStack.push("or")
        resizingArrayStack.push("not")
        resizingArrayStack.push("to")
        resizingArrayStack.push("be")
    }

    @Test
    def "should return right items when pop"() {
        expect:
        resizingArrayStack.pop() == "be"
        resizingArrayStack.pop() == "to"
        resizingArrayStack.pop() == "not"
        resizingArrayStack.pop() == "or"
        resizingArrayStack.pop() == "be"
        resizingArrayStack.pop() == "to"
    }

    @Test
    def "should return false when stack is not empty"() {
        expect:
        !resizingArrayStack.isEmpty()
    }

    @Test
    def "should return true when stack is empty"() {
        given:
        resizingArrayStack = new ResizingArrayStack<>()
        expect:
        resizingArrayStack.isEmpty()
    }

    @Test
    def "should not add null item onto stack"() {
        when:
        resizingArrayStack.push(null)
        then:
        resizingArrayStack.pop() != null
    }

    @Test
    def "should throw exception when try to pop an empty stack"() {
        given:
        resizingArrayStack = new ResizingArrayStack<>()
        when:
        resizingArrayStack.pop()
        then:
        thrown(IllegalArgumentException)
    }

}
