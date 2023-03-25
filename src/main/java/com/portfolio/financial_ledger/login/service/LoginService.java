package com.portfolio.financial_ledger.login.service;

import com.portfolio.financial_ledger.setting.entity.SettingEntity;
import com.portfolio.financial_ledger.setting.repository.SettingRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService implements UserDetailsService { //

    private final SettingRepository settingRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //비밀번호 조회
        SettingEntity passwordEntity = settingRepository.findBySettingKey("password");

        if(passwordEntity == null) {
            throw new UsernameNotFoundException("비밀번호가 올바르지 않습니다.");
        }


        return passwordEntity;
    }
}
