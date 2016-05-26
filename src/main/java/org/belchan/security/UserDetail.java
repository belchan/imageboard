package org.belchan.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@SuppressWarnings("serial")
public class UserDetail extends User {

  public UserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities) {
    super(username, password, authorities);
  }

  public UserDetail(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
    super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
  }

  public final boolean hasRole(String role) {
    boolean hasRole = false;
    boolean hasAdmin = false;
    for (GrantedAuthority grantedAuthority : getAuthorities()) {
      hasRole = grantedAuthority.getAuthority().equals(role);
      hasAdmin = grantedAuthority.getAuthority().equals("ROLE_ADMIN");
      if (hasRole || hasAdmin)
        break;
    }
    return hasRole || hasAdmin;
  }
}
