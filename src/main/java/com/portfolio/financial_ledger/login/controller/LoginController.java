package com.portfolio.financial_ledger.login.controller;

import com.portfolio.financial_ledger.login.service.LoginService;
import com.portfolio.financial_ledger.setting.dto.ChangePasswordDto;
import com.portfolio.financial_ledger.setting.dto.SettingDto;
import com.portfolio.financial_ledger.util.CommonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

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

        return "login/login";
    }

    @GetMapping("login/password")
    public String loginPassword() {
        return "login/password";
    }

//    @PostMapping("/login/password")
//    public String changeLoginInfo(SettingDto settingDto) {
//        boolean result = loginService.changePassword(settingDto);
//
//        if(result) {
//            return "login/login";
//        } else {
//            return "login/password";
//        }
//    }

    @PostMapping("/login/password")
    public String changeLoginInfo(Model model, ChangePasswordDto changePasswordDto) {

        //유효성 검사
        Map<String, String> resultMap = changePasswordDto.passwordValidationCheck();
        String validationResultCode = resultMap.get("code");

        // 비밀번호 변경
        if(!CommonUtil.isNullOrEmpty(validationResultCode) && validationResultCode.equals("00")) {
            resultMap = loginService.changePassword(changePasswordDto);

        }


        String changePasswordResult = resultMap.get("code");

        // 비밀번호 처리 결과에 따라 표현
        if(!CommonUtil.isNullOrEmpty(changePasswordResult) && changePasswordResult.equals("00")) {
            return "login/login";
        } else {
            model.addAttribute("resultMap", resultMap);

            return "login/password";
        }

    }


    @GetMapping("/logout")
    public String logout() {
        return "login/login";
    }



}
