package com.algorithms.arraysearch

import org.junit.Test
import spock.lang.Specification

class FindInBitonicArraySpec extends Specification {

    int[] initArray = [8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1]
    FindInBitonicArray findInBitonicArray = new FindInBitonicArray(initArray)

    @Test
    def "should return right position of passed element"() {
        expect:
        findInBitonicArray.findIndexOf(element) == position

        where:
        element | position
        8       | 0
        10      | 1
        20      | 2
        80      | 3
        100     | 4
        200     | 5
        400     | 6
        500     | 7
        3       | 8
        2       | 9
        1       | 10
        0       | -1
    }

}
