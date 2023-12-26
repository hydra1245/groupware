package com.kmc.groupware.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="tbl_Employee_Rank")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class EmployeeRank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name="RankCode", unique = true, nullable = false)
    private String rankCode;

    @Column(name="RankTitle", nullable = false)
    private String rankTitle;

    @Column(name="CreateDate")
    private LocalDateTime createDate;

    @Column(name="UpdateDate")
    private LocalDateTime updateDate;

    @Column(name="OnOff")
    private String onOff;

    public EmployeeRank(String rankCode, String rankTitle, LocalDateTime createDate, LocalDateTime updateDate, String onOff) {
        this.rankCode = rankCode;
        this.rankTitle = rankTitle;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.onOff = onOff;
    }
}
