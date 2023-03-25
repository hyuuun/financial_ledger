package com.portfolio.financial_ledger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FinancialLedgerApplication {

	public static void main(String[] args) {
		String plainText = "admin";

		System.out.println(new BCryptPasswordEncoder().encode(plainText).toString());

		// $2a$10$zd5OZ9ehAFyVPfC8rXcUcerIqCtghU5ZIdzMAQ8xQgMDI9zK1y0f.
		// admin

		SpringApplication.run(FinancialLedgerApplication.class, args);
	}

}
