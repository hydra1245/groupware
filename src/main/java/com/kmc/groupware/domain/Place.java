package com.kmc.groupware.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="tbl_Place")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name="PlaceName", unique = true, nullable = false)
    private String placeName;

    @Column(name="IsConference", nullable = false)
    private String isConference;

    @Column(name="CreateDate")
    private LocalDateTime createDate;

    @Column(name="UpdateDate")
    private LocalDateTime updateDate;

    @Column(name="OnOff")
    private String onOff;

    public Place(String placeName, String isConference, LocalDateTime createDate, LocalDateTime updateDate, String onOff) {
        this.placeName = placeName;
        this.isConference = isConference;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.onOff = onOff;
    }
}
