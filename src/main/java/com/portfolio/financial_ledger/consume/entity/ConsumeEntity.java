package com.portfolio.financial_ledger.consume.entity;

import jakarta.persistence.*;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;

@Entity
@Document(indexName = "consume")
public class ConsumeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int money;

    @Column(nullable = false)
    private LocalDateTime regist_date;

    @Column(nullable = false)
    private int category;

    private String text;

    @Column(nullable = false)
    private int bank_seq;



}
