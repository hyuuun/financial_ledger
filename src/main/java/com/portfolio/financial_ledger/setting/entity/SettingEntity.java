package com.portfolio.financial_ledger.setting.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "setting")
@Getter
public class SettingEntity {

    @Id
    @Column(length = 20)
    String setting_key;

    @Column(nullable = false, length = 20)
    String setting_value;

}
