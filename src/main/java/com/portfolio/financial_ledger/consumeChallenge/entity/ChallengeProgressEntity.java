package com.portfolio.financial_ledger.consumeChallenge.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Table(name = "challenge_progress")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChallengeProgressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

//    @Column(nullable = false)
//    private int challenge_seq;

    @ColumnDefault(value = "0")
    private int spent_money;

    @Column(nullable = false)
    private Date spent_date;

    @ManyToOne
    @JoinColumn(name="challenge_seq")
    ChallengeProgressEntity challengeProgressEntity;

}
