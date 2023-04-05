package com.portfolio.financial_ledger.consumeChallenge.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "consume_challenge")
@Getter
public class ConsumeChallengeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int challenge_seq;

    @Column(length = 50, nullable = false)
    private String challenge_name;

    @Column(nullable = false)
    private int challenge_type;

    @Column(nullable = false)
    private int goal_money;

    @Column(columnDefinition="TEXT")
    private String challenge_context;

    @Column(nullable = false)
    @CreationTimestamp
    private Date start_date;

    @Column(nullable = false)
    @UpdateTimestamp
    private Date end_date;

    @Column(nullable = false)
    private char challenge_flag; // 성공 : 'S', 실패 : 'F', 진행중 : 'P'


}
