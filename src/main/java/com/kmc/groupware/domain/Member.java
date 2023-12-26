package com.kmc.groupware.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name="tbl_Member")
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="MemberId", unique = true, nullable = false)
    private String memberId;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="DeptCode", nullable = false)
    private String deptCode;

    @Column(name="RankCode", nullable = false)
    private String rankCode;

    @Column(name="name")
    private String name;

    @Column(name="PlaceName", nullable = false)
    private String placeName;

    @Column(name ="CreateDate",nullable = false)
    private LocalDateTime createDate;

    @Column(name = "UpdateDate", nullable = false)
    private LocalDateTime updateDate;

    @Column(name="OnOff", nullable = false)
    private String onOff;

    public void setPassword(String password) {
        this.password = password;
    }
    public void setCreateDate(LocalDateTime datetime) {
        this.createDate = datetime;
    }
}
