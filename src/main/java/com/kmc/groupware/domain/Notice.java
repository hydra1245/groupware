package com.kmc.groupware.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="tbl_Notice")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name="Title", nullable = false)
    private String title;

    @Column(name="Content", nullable = false)
    private String content;

    @Column(name="ViewCount", nullable = false)
    private int viewCount;

    @Column(name="MemberId", nullable = false)
    private String memberId;

    @Column(name="CreateDate")
    private LocalDateTime createDate;

    @Column(name="UpdateDate")
    private LocalDateTime updateDate;

    @Column(name="OnOff")
    private String onOff;

    public Notice(String title, String content, int viewCount, String memberId, LocalDateTime createDate, LocalDateTime updateDate, String onOff) {
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.memberId = memberId;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.onOff = onOff;
    }
}
