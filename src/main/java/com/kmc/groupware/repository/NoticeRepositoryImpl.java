package com.kmc.groupware.repository;

import com.kmc.groupware.domain.QMember;
import com.kmc.groupware.domain.QNotice;
import com.kmc.groupware.dto.NoticeDetailDto;
import com.kmc.groupware.dto.NoticeListDto;
import com.kmc.groupware.dto.QNoticeDetailDto;
import com.kmc.groupware.dto.QNoticeListDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

import static com.kmc.groupware.domain.QMember.member;
import static com.kmc.groupware.domain.QNotice.notice;

public class NoticeRepositoryImpl implements NoticeRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public NoticeRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<NoticeListDto> getList() {
        return queryFactory
                .select(new QNoticeListDto(notice.id, notice.title, notice.content, notice.memberId,notice.viewCount, member.name))
                .from(notice)
                .join(member)
                .on(notice.memberId.eq(member.memberId))
                .where(notice.onOff.eq("Y"))
                .orderBy(notice.id.desc())
                .fetch();
    }
    @Override
    @Transactional
    public long viewCountUpdate(long id) {
        return queryFactory
                .update(notice)
                .set(notice.viewCount, notice.viewCount.add(1))
                .where(notice.id.eq(id))
                .execute();
    }

    @Override
    public NoticeDetailDto getDetail(long id) {
        return queryFactory
                .select(new QNoticeDetailDto(notice.title,
                        notice.content,notice.viewCount,member.name,notice.createDate, notice.updateDate,
                        member.memberId, notice.id))
                .from(notice)
                .join(member)
                .on(notice.memberId.eq(member.memberId))
                .where(notice.id.eq(id).and(notice.onOff.eq("Y")))
                .fetchOne();

    }

    @Override
    @Transactional
    public long noticeDelete(long id) {
        return queryFactory
                .update(notice)
                .set(notice.onOff,"N")
                .where(notice.id.eq(id))
                .execute();

    }

    @Override
    @Transactional
    public long noticeUpdate(long id, String title, String content) {
        return queryFactory
                .update(notice)
                .set(notice.title, title)
                .set(notice.content, content)
                .set(notice.updateDate, LocalDateTime.now())
                .where(notice.id.eq(id).and(notice.onOff.eq("Y")))
                .execute();

    }
}
