package com.hendisantika.springboottesttimezones;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-test-timezones
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-08-04
 * Time: 05:29
 */
@Entity
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class DemoEntity {

    @Id
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar utcCalendar;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar gmt1Calendar;
}