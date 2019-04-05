package com.algorithms.unionfind.impl


import com.algorithms.unionfind.UFWithLargest
import org.junit.Test
import spock.lang.Specification

class WeightedQuickUnionUFWithLargestSpec extends Specification {

    UFWithLargest uf = new WeightedQuickUnionUFWithLargest(10)

    def setup() {
        uf.union(4, 3)
        uf.union(3, 8)
        uf.union(6, 5)
        uf.union(9, 4)
        uf.union(2, 1)
        uf.union(5, 0)
        uf.union(7, 2)
        uf.union(6, 1)
    }

    @Test
    def "should return right largest element inside component"() {
        expect:
        uf.getLargest(3) == 9
        uf.getLargest(1) == 7
    }

}
