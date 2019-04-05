package com.algorithms.unionfind.impl

import com.algorithms.unionfind.UF
import org.junit.Test
import spock.lang.Specification

class QuickUnionUFSpec extends Specification {

    UF uf = new QuickUnionUF(10)

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
    def "should return true checking connection inside one component"() {
        expect:
        uf.connected(8, 9)
        uf.connected(1, 0)
        uf.connected(6, 7)
    }

    @Test
    def "should return false checking connection inside different components"() {
        expect:
        !uf.connected(0, 3)
        !uf.connected(1, 9)
        !uf.connected(7, 8)
    }

}
