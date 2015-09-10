package com.test.mmm.service;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.test.mmm.entity.User;
import com.test.mmm.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Marian_Mykhalchuk on 9/9/2015.
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService, Serializable {

	@Autowired
	private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    final User user = userRepository.findByFirstName(username).get(0);
	    if (user == null) {
		    return null;
	    } else {
			return new UserDetails() {
				public Collection<? extends GrantedAuthority> getAuthorities() {
					return Arrays.asList(new SimpleGrantedAuthority(user.getUserRole().toString()));
				}

				public String getPassword() {
					// TODO: has to be stored in database, hashed!!!
					return "pass";
				}

				public String getUsername() {
					return user.getFirstName();
				}

				public boolean isAccountNonExpired() {
					return true;
				}

				public boolean isAccountNonLocked() {
					return true;
				}

				public boolean isCredentialsNonExpired() {
					return true;
				}

				public boolean isEnabled() {
					return true;
				}
			};
	    }
    }
}
