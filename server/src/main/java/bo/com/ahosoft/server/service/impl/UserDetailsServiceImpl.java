package bo.com.ahosoft.server.service.impl;

import bo.com.ahosoft.server.domain.UserSystem;
import org.springframework.security.core.userdetails.User;
import bo.com.ahosoft.server.repository.UserSystemRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import static java.util.Collections.emptyList;

/**
 * Created by: Arturo Herrera
 * Date : 15-04-18 - 09:10 AM
 * Project: sprint-boot-angular-jboss-maven-starter
 * Package: bo.com.ahosoft.server.service.impl
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserSystemRepository userSystemRepository;

    public UserDetailsServiceImpl(UserSystemRepository userSystemRepository) {
        this.userSystemRepository = userSystemRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserSystem applicationUser = userSystemRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }
}
