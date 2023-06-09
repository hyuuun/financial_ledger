package com.portfolio.financial_ledger.setting.entity;

import com.portfolio.financial_ledger.setting.dto.ChangePasswordDto;
import com.portfolio.financial_ledger.setting.dto.SettingDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Table(name = "setting")
@Getter
@NoArgsConstructor
public class SettingEntity implements UserDetails {

    @Id
    @Column(name = "setting_key", length = 20)
    private String settingKey;

    @Column(name = "setting_value",  nullable = false, length = 60)
    private String settingValue;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.settingValue;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public SettingEntity toEntity(SettingDto settingDto) {
        this.settingKey = settingDto.getSetting_key();
        this.settingValue = settingDto.getSetting_value();

        return this;
    }

    public SettingEntity toEntity(ChangePasswordDto changePasswordDto) {
        this.settingKey = changePasswordDto.getSetting_key();
        this.settingValue = changePasswordDto.getNewPassword();

        return this;
    }
}
