package com.codingblocks.androidtesting;

public class FareUtils {

    public static float calcFare(float km, int min) {
        float fare = 25.0F;
        if (km > 2)
            fare += (km - 2) * 10;

        if (min > 15)
            fare += (min - 15);

        return fare;
    }
}
