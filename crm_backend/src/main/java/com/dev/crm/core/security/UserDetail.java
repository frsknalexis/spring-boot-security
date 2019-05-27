package com.dev.crm.core.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component("userDetail")
public class UserDetail {

	public UserDetails findLoggedInUser() {
		
		Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
		if(userDetails instanceof UserDetails) {
			System.out.print(((UserDetails) userDetails).getUsername());
			return (UserDetails) userDetails;
		}
		return null;
	}
}
