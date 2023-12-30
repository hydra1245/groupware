package com.kmc.groupware;

import com.kmc.groupware.domain.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

@SpringBootTest
@Transactional
public class GroupwareTest {
    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void DeptTest() {
        Dept dept = new Dept("12345","테스트부서","테스트용", LocalDateTime.now(),
                LocalDateTime.now(),"Y");

        em.persist(dept);
        queryFactory = new JPAQueryFactory(em);
        QDept qDept = QDept.dept;

        Dept result = queryFactory.selectFrom(qDept).fetchOne();

        Assertions.assertThat(result).isEqualTo(dept);
        Assertions.assertThat(result.getId()).isEqualTo(dept.getId());

    }

    @Test
    public void JoinTest() {
        queryFactory = new JPAQueryFactory(em);
        //QMember qMember = QMember.member;
        //QDept qDept = QDept.dept;
        QPlace qPlace = QPlace.place;
        QMeetingReserve qMeetingReserve = QMeetingReserve.meetingReserve;

        queryFactory.select(qPlace, qMeetingReserve)
                .from(qPlace)
                .join(qMeetingReserve)
                .on(qPlace.placeName.eq(qMeetingReserve.placeName))
                .fetch();

    }

    @Test
    public void redisTest() {
        ValueOperations<String, String> valueOperations =
                redisTemplate.opsForValue();
        String key = "first";

        valueOperations.set(key,"HelloWorld");

        String value = valueOperations.get(key);
        Assertions.assertThat(value).isEqualTo("HelloWorld");
    }
}
