package com.tejovat.starmart.configuration;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.tejovat.starmart.model.User;

public class AuditorAwareImpl implements AuditorAware<Long>{

	@Override
	public Optional<Long> getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication == null || !authentication.isAuthenticated()) {
			return Optional.empty();
		}
		try {
			User currentUser = (User) authentication.getPrincipal();
			return Optional.of(currentUser.getId());
		}catch(ClassCastException e) {
			return Optional.of(999L);
		}catch(Exception e) {
			return Optional.of(999L);
		}
	}
}
