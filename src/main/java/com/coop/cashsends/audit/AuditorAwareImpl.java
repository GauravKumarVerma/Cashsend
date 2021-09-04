package com.coop.cashsends.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


public class AuditorAwareImpl implements AuditorAware<String> {

	
	@Override
	public Optional<String> getCurrentAuditor() {
		 SecurityContext securityContext = SecurityContextHolder.getContext();
	        Authentication authentication = securityContext.getAuthentication();
	        String id = null;
	        if (authentication != null)
	            if (authentication.getPrincipal() instanceof UserDetails)
	                id = ((UserDetails) authentication.getPrincipal()).getUsername();
	            else if (authentication.getPrincipal() instanceof String)
	                id = (String) authentication.getPrincipal();
	        
	        try {
	            return Optional.of(String.valueOf(id != null ? id : null)); //anonymoususer
	        } catch (NumberFormatException e) {
	        	e.printStackTrace();
	        	return Optional.of("1");
	        }
		// Use below commented code when will use Spring Security.
	}
}


// ------------------ Use below code for spring security --------------------------
/*
class SpringSecurityAuditorAware implements AuditorAware<String> {

	public Optional<String> getCurrentAuditor() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null || !authentication.isAuthenticated()) {
			return null;
		}

		return  Optional.of("1");
	}*/

/*class SpringSecurityAuditorAware implements AuditorAware<User> {

	 public Optional<User> getCurrentAuditor() {

	  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	  if (authentication == null || !authentication.isAuthenticated()) {
	   return null;
	  }

	  return ((UserDetails) authentication.getPrincipal()).getUser();
	 }
	}*/