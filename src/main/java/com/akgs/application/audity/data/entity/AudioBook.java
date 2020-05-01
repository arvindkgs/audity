package com.akgs.application.audity.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class AudioBook {
    enum BOOKTYPE{
        MP3, AUDIOBOOK, AUDIBLE
    }
    enum GENRE{
        ACTION_ADVENTURE,
        ART,
        BIOGRAPHICAL,
        BUSINESS,
        COMPUTER_INTERNET,
        CRAFTS,
        CRIME_THRILLER,
        FANTASY,
        FOOD,
        GENERAL_FICTION,
        GENERAL_NON_FIC,
        HISTORICAL_FICTION,
        HISTORY,
        HOME_GARDEN,
        HORROR,
        HUMOR,
        INSTRUCTIONAL,
        JUVENILE,
        LANGUAGE,
        LITERARY_CLASSICS,
        MATH_SCIENCE_TECH,
        MEDICAL,
        MYSTERY,
        NATURE,
        PHILOSOPHY,
        POL_SOC_RELIG,
        RECREATION,
        ROMANCE,
        SCIENCE_FICTION,
        SELF_HELP,
        TRAVEL_ADVENTURE,
        TRUE_CRIME,
        URBAN_FANTASY,
        WESTERN,
        YOUNG_ADULT
    }
    enum DOWNLOAD{
        IN_PROGRESS, DONE
    }
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private long id;
    @Getter
    @NonNull
    @Column(unique = true, nullable = false)
    private String author;
    @Getter
    @NonNull
    @Column(unique = true, nullable = false)
    private String title;
    @Getter
    @Column(nullable = false, name = "DOWNLOAD_STATUS", columnDefinition = "VARCHAR(20) DEFAULT 'IN_PROGRESS'")
    @Enumerated(EnumType.STRING)
    private DOWNLOAD downloadStatus = DOWNLOAD.IN_PROGRESS;
    @Getter
    @Column(columnDefinition="CLOB NOT NULL")
    @Lob
    private String description;
    @Getter
    private String narrator;
    @Getter
    @ElementCollection
    private List<GENRE> category;
    @Getter
    @Column(nullable = false)
    @ColumnDefault("FALSE")
    private boolean read;
    @Getter
    private Date downloaded;
    @Getter
    private Date readOn;
    @Getter
    private String directory;
    @Getter
    private String series;
    @Getter
    private int bookInSeries;
    @Getter
    @Enumerated(EnumType.STRING)
    private BOOKTYPE type;
    @Getter
    private long duration;
    @Getter
    private long size;
}
