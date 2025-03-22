package com.parkinglot.utils;

import java.util.Date;

public class DateUtils {

    public static long calculateHour(Date entryTime, Date exitTime) {

        long diff = exitTime.getTime() - entryTime.getTime();

        return diff / (60 * 60 * 1000);
    }
}
