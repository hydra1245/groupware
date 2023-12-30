package com.kmc.groupware.repository;

import com.kmc.groupware.dto.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

import static com.kmc.groupware.domain.QFreeBoard.freeBoard;
import static com.kmc.groupware.domain.QMember.member;
import static com.kmc.groupware.domain.QNotice.notice;

public class FreeBoardRepositoryImpl implements FreeBoardRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public FreeBoardRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public List<FreeBoardListDto> getList() {
        return queryFactory
                .select(new QFreeBoardListDto(freeBoard.id, freeBoard.title, freeBoard.content,
                        freeBoard.memberId,freeBoard.viewCount, member.name))
                .from(freeBoard)
                .join(member)
                .on(freeBoard.memberId.eq(member.memberId))
                .where(freeBoard.onOff.eq("Y"))
                .orderBy(freeBoard.id.desc())
                .fetch();
    }

    @Override
    @Transactional
    public long viewCountUpdate(long id) {
        return queryFactory
                .update(freeBoard)
                .set(freeBoard.viewCount, freeBoard.viewCount.add(1))
                .where(freeBoard.id.eq(id))
                .execute();
    }

    @Override
    public FreeBoardDetailDto getDetail(long id) {
        return queryFactory
                .select(new QFreeBoardDetailDto(freeBoard.title,
                        freeBoard.content,freeBoard.viewCount,member.name,freeBoard.createDate,
                        freeBoard.updateDate,
                        member.memberId, freeBoard.id))
                .from(freeBoard)
                .join(member)
                .on(freeBoard.memberId.eq(member.memberId))
                .where(freeBoard.id.eq(id).and(freeBoard.onOff.eq("Y")))
                .fetchOne();
    }

    @Override
    public long freeBoardDelete(long id) {
        return queryFactory
                .update(freeBoard)
                .set(freeBoard.onOff,"N")
                .where(freeBoard.id.eq(id))
                .execute();
    }

    @Override
    public long freeBoardUpdate(long id, String title, String content) {
        return queryFactory
                .update(freeBoard)
                .set(freeBoard.title, title)
                .set(freeBoard.content, content)
                .set(freeBoard.updateDate, LocalDateTime.now())
                .where(freeBoard.id.eq(id).and(freeBoard.onOff.eq("Y")))
                .execute();
    }
}
