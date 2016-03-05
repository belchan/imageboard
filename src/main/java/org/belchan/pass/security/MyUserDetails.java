package org.belchan.pass.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

public class MyUserDetails implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        LocalDateTime time = LocalDateTime.now();
        String LOGIN = "user" + time.getDayOfMonth();
        String PASSWORD = "passh" + time.getHour() + "m" + time.getMonthValue();
        if (LOGIN.equals(login)) {
            boolean enabled = true;
            boolean credentialsNonExpired = true;
            boolean accountNonExpired = true;
            boolean accountNonLocked = true;

            Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

            authorities.add(new SimpleGrantedAuthority("ADMIN"));

            return new User(LOGIN, PASSWORD, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        } else {
            return new User("LOGIN", "PASSWORD", false, false, false, false, new ArrayList<GrantedAuthority>());
        }


    }

}