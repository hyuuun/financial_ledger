package com.portfolio.financial_ledger.util;

public class CommonUtil {

    public static boolean isNullOrEmpty(String str) {
        if(str == null || str.length() !=0) {
            return true;
        }
        return false;
    }

}
