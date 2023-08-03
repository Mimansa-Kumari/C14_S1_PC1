package com.example.ecommerce;

import com.example.ecommerce.filter.E_CommerceFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean filterRegister()
	{
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new E_CommerceFilter());
		filterRegistrationBean.addUrlPatterns("/api/v1/getCustomers","/api/v1/admin/getAllCustomers");
		return filterRegistrationBean;
	}
}
