package com.hendisantika.springboottesttimezones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-test-timezones
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-08-04
 * Time: 05:30
 */
@Repository
public interface DemoRepository extends JpaRepository<DemoEntity, Integer> {

    @Query(value = "select d.utcCalendar from DemoEntity d where id=:id")
    Calendar getUtcCalendar(Integer id);

    @Query(value = "select d.gmt1Calendar from DemoEntity d where id = :id")
    Calendar getGmt1Calendar(Integer id);
}