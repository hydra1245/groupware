package com.kmc.groupware.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="tbl_Meeting_Reserve")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class MeetingReserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name="PlaceName", nullable = false)
    private String placeName;

    @Column(name="MeetingTitle", nullable = false)
    private String meetingTitle;

    @Column(name="Content", nullable = false)
    private String content;

    @Column(name="MemberId", nullable = false)
    private String memberId;

    @Column(name="StartDate", nullable = false)
    private LocalDateTime startDate;

    @Column(name="EndDate", nullable = false)
    private LocalDateTime endDate;

    @Column(name="CreateDate")
    private LocalDateTime createDate;

    @Column(name="UpdateDate")
    private LocalDateTime updateDate;

    @Column(name="OnOff")
    private String onOff;

    public MeetingReserve(String placeName, String meetingTitle, String content, String memberId, LocalDateTime startDate, LocalDateTime endDate, LocalDateTime createDate, LocalDateTime updateDate, String onOff) {
        this.placeName = placeName;
        this.meetingTitle = meetingTitle;
        this.content = content;
        this.memberId = memberId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.onOff = onOff;
    }
}
