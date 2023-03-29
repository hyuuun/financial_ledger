package com.portfolio.financial_ledger.setting.dto;

import lombok.Getter;
import org.springframework.data.elasticsearch.annotations.Setting;

@Setting
@Getter
public class SettingDto {
    private String setting_key;
    private String setting_value;


}
