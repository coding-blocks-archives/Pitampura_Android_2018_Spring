package com.codingblocks.androidtesting

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CalcFareTest {
    @Test
    fun fare_is_25_for_0Km_0Min() {
        assertEquals(
                25.0F,
                FareUtils.calcFare(0F,0),
                0.005F
        )
    }
    @Test
    fun fare_is_30_for_0Km_20Min() {
        assertEquals(
                30.0F,
                FareUtils.calcFare(0F,20),
                0.005F
        )
    }
    @Test
    fun fare_is_40_for_3Km_20Min() {
        assertEquals(
                40.0F,
                FareUtils.calcFare(3F,20),
                0.005F
        )
    }

}
