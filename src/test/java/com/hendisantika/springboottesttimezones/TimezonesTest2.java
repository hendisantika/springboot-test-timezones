package com.hendisantika.springboottesttimezones;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.TimeZone;

import static com.hendisantika.springboottesttimezones.Utils.logCalendar;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-test-timezones
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-08-04
 * Time: 05:52
 */
@RunWith(SpringRunner.class)
@DataJpaTest(properties = {"spring.jpa.properties.hibernate.jdbc.time_zone=UTC"})
public class TimezonesTest2 {

    @Autowired
    DemoRepository demoRepository;

    @Test
    public void testTimezones2() {

        Calendar utcCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        utcCalendar.set(2019, Calendar.MARCH, 7, 10, 0, 0);
        utcCalendar.clear(Calendar.MILLISECOND);


        Calendar gmt1Calendar = Calendar.getInstance();
        gmt1Calendar.set(2019, Calendar.MARCH, 7, 10, 0, 0);
        gmt1Calendar.clear(Calendar.MILLISECOND);

        logCalendar("Written GMT+1 Cal", gmt1Calendar);
        logCalendar("Written UTC Cal  ", utcCalendar);

        DemoEntity demoEntity1 = DemoEntity.builder()
                .id(1)
                .utcCalendar(utcCalendar)
                .gmt1Calendar(gmt1Calendar)
                .build();

        demoRepository.saveAndFlush(demoEntity1);


        Calendar utcCalendar2 = demoRepository.getUtcCalendar(demoEntity1.getId());
        Calendar gmt1Calendar2 = demoRepository.getGmt1Calendar(demoEntity1.getId());

        logCalendar("Read GMT+1 Cal", gmt1Calendar2);
        logCalendar("Read UTC Cal  ", utcCalendar2);

        Assertions.assertThat(gmt1Calendar2).as("Check GMT+1 Calendar").isEqualTo(gmt1Calendar);
        Assertions.assertThat(utcCalendar2).as("Check UTC Calendar").isEqualTo(utcCalendar);
    }

}