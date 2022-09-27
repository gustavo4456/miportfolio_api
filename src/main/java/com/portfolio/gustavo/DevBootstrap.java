package com.portfolio.gustavo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.portfolio.gustavo.models.Authority;
import com.portfolio.gustavo.services.AuthorityService;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	AuthorityService authorityService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		authorityService.guardarAutoridad(new Authority("ROLE_ADMIN"));
		authorityService.guardarAutoridad(new Authority("ROLE_USER"));
	}

}
