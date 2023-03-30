package com.portfolio.financial_ledger.login.controller;

import com.portfolio.financial_ledger.login.service.LoginService;
import com.portfolio.financial_ledger.setting.dto.SettingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller()
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginPage() {
        return "login/login";
    }

    @GetMapping("/login/error")
    public String loginFail(Model model) {
        model.addAttribute("err_msg", "비밀번호를 확인해주세요.");

        return "/login/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "login/login";
    }

}
