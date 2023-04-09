package com.portfolio.financial_ledger.setting.dto;

import com.portfolio.financial_ledger.util.CommonUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@ToString
public class ChangePasswordDto {

    String setting_key;

    String password;
    String newPassword;

    public Map<String, String> passwordValidationCheck() {
        Map<String, String> resultMap = new HashMap<>();

        if(CommonUtil.isNullOrEmpty(this.setting_key)) {
            resultMap.put("code", "1100");
            resultMap.put("msg", "Setting Key is null");

        } else if(!this.setting_key.equals("password")) {
            resultMap.put("code", "1100");
            resultMap.put("msg", "Setting key is not password");

        } else if(CommonUtil.isNullOrEmpty(this.password)) {
            resultMap.put("code", "1100");
            resultMap.put("msg", "Input current password");

        } else if(CommonUtil.isNullOrEmpty(newPassword)) {
            resultMap.put("code", "1100");
            resultMap.put("msg", "Input new password");

        } else {
            resultMap.put("code", "00");
            resultMap.put("msg", "valid");
        }

        return resultMap;
    }

    public void encryptPassword() {
        if(this.setting_key.equals("password")) {
//            this.password = new BCryptPasswordEncoder().encode(this.password);
            this.newPassword = new BCryptPasswordEncoder().encode(this.newPassword);
        }
    }


}
