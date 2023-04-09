package com.portfolio.financial_ledger.consume.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bank")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BankEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bank_seq;

    @Column(length = 50, nullable = false)
    private String bank_name;
}
