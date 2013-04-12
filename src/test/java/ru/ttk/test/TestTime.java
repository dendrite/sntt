package ru.ttk.test;

import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Date;

/**
 *
 */
public class TestTime {

    @Test
    public void testTime(){
        DateTime dateTime = new DateTime(new Date());
        System.out.println(dateTime);
        System.out.println(dateTime.plusDays(1));
    }
}
