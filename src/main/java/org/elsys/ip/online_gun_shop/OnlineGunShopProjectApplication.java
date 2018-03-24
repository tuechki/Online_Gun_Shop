package org.elsys.ip.online_gun_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EntityScan(basePackages = "org.elsys.ip.online_gun_shop.model")
@EnableJpaRepositories(basePackages = "org.elsys.ip.online_gun_shop.repository")
public class OnlineGunShopProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineGunShopProjectApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
