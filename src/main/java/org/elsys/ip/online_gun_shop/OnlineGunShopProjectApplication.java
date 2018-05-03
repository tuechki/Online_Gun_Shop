package org.elsys.ip.online_gun_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EntityScan(basePackages = "org.elsys.ip.online_gun_shop.model")
@EnableJpaRepositories(basePackages = "org.elsys.ip.online_gun_shop.repository")
@CrossOrigin(origins = "192.168.43.165:4202")
public class OnlineGunShopProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineGunShopProjectApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/weapons").allowedOrigins("http://192.168.43.165:4202");
			}
		};
	}
}
