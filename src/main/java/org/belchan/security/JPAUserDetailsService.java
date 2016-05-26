package org.belchan.security;

import org.belchan.entity.Staff;
import org.belchan.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class JPAUserDetailsService implements UserDetailsService {

  @Autowired
  private StaffService  staffService;


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Staff user = staffService.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException(username + " is an unknown username");
    }
//    Set<Authority> authorities = authRepo.findAllForUserAndGroups(user.getUsername());
//
//    Set<GrantedAuthority> grantedAuthories = new HashSet<>();
//    for (Authority authority : authorities) {
//      SimpleGrantedAuthority sga = new SimpleGrantedAuthority(authority.getCode());
//      grantedAuthories.add(sga);
//    }

//    return new UserDetail(user.getUsername(), user.getPassword(), user.getEnabled(),
//        (user.getAccountExpiration() == null || user.getAccountExpiration().isAfterNow()),
//        (user.getCredentialsExpiration() == null || user.getCredentialsExpiration().isAfterNow()),
//        !user.getLocked(), grantedAuthories);
    return new UserDetail(user.getUsername(),user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")));
  }
}
