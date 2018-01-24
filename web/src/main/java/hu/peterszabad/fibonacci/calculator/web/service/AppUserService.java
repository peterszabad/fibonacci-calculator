package hu.peterszabad.fibonacci.calculator.web.service;

import hu.peterszabad.fibonacci.calculator.web.dao.AppUserRepository;
import hu.peterszabad.fibonacci.calculator.web.model.AppRole;
import hu.peterszabad.fibonacci.calculator.web.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

/**
 * @author Péter Szabad
 */
@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepository
                .findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid username or password."));
        return new User(user.getName(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<AppRole> roles) {
        return roles.stream()
                .map(AppRole::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(toList());
    }
}
