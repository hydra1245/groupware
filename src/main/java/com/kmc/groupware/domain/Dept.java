package com.kmc.groupware.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="tbl_Dept")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Dept {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name="DeptCode", unique = true, nullable = false)
    private String deptCode;

    @Column(name="DeptName", nullable = false)
    private String deptName;

    @Column(name="Mark")
    private String mark;

    @Column(name="CreateDate")
    private LocalDateTime createDate;

    @Column(name="UpdateDate")
    private LocalDateTime updateDate;

    @Column(name="OnOff")
    private String onOff;

    public Dept(String deptCode, String deptName, String mark, LocalDateTime createDate, LocalDateTime updateDate, String onOff) {
        this.deptCode = deptCode;
        this.deptName = deptName;
        this.mark = mark;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.onOff = onOff;
    }
}
