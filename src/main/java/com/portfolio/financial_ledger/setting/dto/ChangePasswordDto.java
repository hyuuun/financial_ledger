package com.portfolio.financial_ledger.setting.dto;

import com.portfolio.financial_ledger.util.CommonUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@ToString
public class ChangePasswordDto {

    String setting_key;

    String password;
    String newPassword;

    String newPasswordCheck;


    public Map<String, String> initPasswordValidation() {
        Map<String, String> resultMap = new HashMap<>();

        if(CommonUtil.isNullOrEmpty(this.setting_key)) {
            resultMap.put("code", "1100");
            resultMap.put("msg", "Setting Key is null");

        } else if(!this.setting_key.equals("password")) {
            resultMap.put("code", "1100");
            resultMap.put("msg", "Setting key is not password");

        } else if(CommonUtil.isNullOrEmpty(this.newPassword)) {
            resultMap.put("code", "1100");
            resultMap.put("msg", "Input new password");

        } else if(CommonUtil.isNullOrEmpty(this.newPasswordCheck)) {
            resultMap.put("code", "1100");
            resultMap.put("msg", "Input new password check");

        } else if(!this.newPassword.equals(this.newPasswordCheck)) {
            resultMap.put("code", "1100");
            resultMap.put("msg", "New password and new password check not equal");

        } else {
            resultMap.put("code", "00");
            resultMap.put("msg", "valid");
        }


        return resultMap;
    }

    public Map<String, String> changePasswordValidation() {
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

    public void encryptPassword(PasswordEncoder passwordEncoder) {
        if(this.setting_key.equals("password")) {
            this.newPassword = passwordEncoder.encode(this.newPassword);
        }
    }


}
