package com.kmc.groupware.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="tbl_Meeting_Reserve_Member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class MeetingReserveMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name="ReserveId", nullable = false)
    private long reserveId;

    @Column(name="MemberId", nullable = false)
    private long memberId;
}
