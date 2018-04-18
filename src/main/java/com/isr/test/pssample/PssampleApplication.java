package com.isr.test.pssample;

import org.apache.commons.lang.NumberUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.isr.test.pssample.model.Account;
import com.isr.test.pssample.model.Login;
import com.isr.test.pssample.repository.AccountRepository;
import com.isr.test.pssample.repository.LoginDataRepository;
import com.isr.test.pssample.utils.PSUtil;

@SpringBootApplication
public class PssampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PssampleApplication.class, args);
	}

	@Bean
	CommandLineRunner setupLoginTable(final LoginDataRepository loginDataRepository) {
		return new CommandLineRunner() {

			@Value("${pssample.db.data.login.initial.load.record.count}")
			private int loginRecordCount;

			@Override
			public void run(String... arg0) throws Exception {
				//System.out.println("adfadf");
				if (arg0.length > 0 && arg0[0] != null && NumberUtils.isNumber(arg0[0])) {
					this.loginRecordCount = Integer.parseInt(arg0[0]);
				}
				//System.out.println("===================== LOADING INTIAL LOGIN DATA " + this.loginRecordCount
						//+ " ===========================");
				for (int i = 0; i < this.loginRecordCount; i++) {
					Login login = new Login(PSUtil.getRandomAttribute("User", 100), PSUtil.getRandomLoginDate(),
							PSUtil.getRandomAttribute("AA"), PSUtil.getRandomAttribute("BB"),
							PSUtil.getRandomAttribute("CC"), PSUtil.getRandomAttribute("DD"));
					//System.out.println("Record " + i + " -- " + login);
					loginDataRepository.save(login);
				}
				//System.out.println("===================== FINISHED INTIAL LOGIN DATA LOAD ===========================");

			}

			public int getLoginRecordCount() {
				return loginRecordCount;
			}

			public void setLoginRecordCount(int loginRecordCount) {
				this.loginRecordCount = loginRecordCount;
			}

		};

	}

	@Bean
	CommandLineRunner setupAccountSecurityTable(final AccountRepository accountRepository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... arg0) throws Exception {
				//System.out.println("===================== SETTING UP SECURITY ACCOUNT ===========================");
				accountRepository.save(new Account("pradeep", "password"));
				accountRepository.save(new Account("isr", "isr"));

			}

		};

	}

}
