package com.hendisantika.springboottesttimezones;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-test-timezones
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-08-04
 * Time: 05:31
 */
public class Utils {
    private static final Logger log = LoggerFactory.getLogger(Utils.class);

    public static void logCalendar(String name, Calendar calendar) {
        log.info("{} - epoch: {} - hour of day: {} - timezone: {}", name, calendar.getTimeInMillis(),
                calendar.get(Calendar.HOUR_OF_DAY), calendar.getTimeZone().getID());
    }
}
