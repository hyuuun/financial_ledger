package com.portfolio.financial_ledger.setting.dto;


import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Setter
@Getter
@ToString
public class SettingDto {

    String setting_key;
    String setting_value;

    public void encryptPassword() {
        if(this.setting_key.equals("password")) {
            this.setting_value = new BCryptPasswordEncoder().encode(this.setting_value);
        }
    }

}
