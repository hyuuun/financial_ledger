package com.portfolio.financial_ledger.login.service;

import com.portfolio.financial_ledger.setting.dto.ChangePasswordDto;
import com.portfolio.financial_ledger.setting.dto.SettingDto;
import com.portfolio.financial_ledger.setting.entity.SettingEntity;
import com.portfolio.financial_ledger.setting.repository.SettingRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class LoginService implements UserDetailsService { //

    private final SettingRepository settingRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SettingEntity passwordEntity = settingRepository.findBySettingKey("password");

        if(passwordEntity == null) {
            throw new UsernameNotFoundException("비밀번호가 올바르지 않습니다.");
        }

        return User.builder()
                .username("hyun")
                .password(passwordEntity.getSettingValue())
                .roles("ADMIN")
                .build();

    }

//    public boolean changePassword(SettingDto settingDto) {
//
//        SettingEntity settingEntity = settingRepository.findBySettingKey(settingDto.getSetting_key());
//
//        if(settingEntity != null) {
//            settingDto.encryptPassword();
//            settingEntity.toEntity(settingDto);
//
//            settingRepository.save(settingEntity);
//
//            return true;
//        }
//
//        return false;
//    }

    public Map<String, String> changePassword(ChangePasswordDto changePasswordDto) {
        Map<String, String> resultMap = new HashMap<>();

         SettingEntity settingEntity = settingRepository.findBySettingKey(changePasswordDto.getSetting_key());

        System.out.println("check input pw : " + changePasswordDto.getPassword());
        System.out.println(new BCryptPasswordEncoder().matches(changePasswordDto.getPassword(), settingEntity.getPassword()));

        if(settingEntity == null) {
            resultMap.put("code", "1200");
            resultMap.put("msg", "Password Data is not exists");

        } else if(!new BCryptPasswordEncoder().matches(changePasswordDto.getPassword(), settingEntity.getPassword())) {
            resultMap.put("code", "1200");
            resultMap.put("msg", "Current password is not correct");

        } else {
            changePasswordDto.encryptPassword();
            settingEntity.toEntity(changePasswordDto);
            settingRepository.save(settingEntity);

            resultMap.put("code", "00");
            resultMap.put("msg", "success");
        }

        return resultMap;

    }


//    public boolean changePassword(ChangePasswordDto changePasswordDto) {
//
//        SettingEntity settingEntity = settingRepository.findBySettingKey(changePasswordDto.getSetting_key());
//
//        if(settingEntity != null) {
//            changePasswordDto.encryptPassword();
//            settingEntity.toEntity(changePasswordDto);
//
//            settingRepository.save(settingEntity);
//
//            return true;
//        }
//
//        return false;
//    }
}
