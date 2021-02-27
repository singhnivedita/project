/*


package com.project.dmcapp.security;


import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.dmcapp.model.Role;
import com.project.dmcapp.model.User;
import com.project.dmcapp.repo.RoleRepo;
import com.project.dmcapp.repo.UserRepo;

@Service
public class AppUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		
		if(user == null)
			throw new UsernameNotFoundException(username);
		
		AppUser appUser = new AppUser(user);
		
		return appUser;
	}
	
	public boolean userExists(String username) {
		User user = userRepository.findByUsername(username);
		
		if(user == null)
			return false;
		
		return true;
	}
	
	public void createUser(UserDetails userDetails) {
		User user = new User(userDetails.getUsername(), userDetails.getPassword());
		
		user.setRoleList(userDetails.getAuthorities()
				.stream()
				.map(auth -> roleRepository.findByName(auth.getAuthority()) == null 
				? new Role(auth.getAuthority()) 
						: roleRepository.findByName(auth.getAuthority()))
				.collect(Collectors.toSet()));
		
		userRepository.save(user);	
	}
}
*/
