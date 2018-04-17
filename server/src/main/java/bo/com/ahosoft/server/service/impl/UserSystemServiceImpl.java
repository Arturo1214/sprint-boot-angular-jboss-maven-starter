package bo.com.ahosoft.server.service.impl;

import bo.com.ahosoft.server.domain.UserSystem;
import bo.com.ahosoft.server.repository.UserSystemRepository;
import bo.com.ahosoft.server.service.UserSystemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 13-04-18 - 04:59 PM
 * Project       : sprint-boot-angular-jboss-maven-starter
 * Package       : bo.com.ahosoft.server.service.impl
 **/
@Service
@Transactional
public class UserSystemServiceImpl implements UserSystemService {

    private final UserSystemRepository userSystemRepository;

    public UserSystemServiceImpl(UserSystemRepository userSystemRepository) {
        this.userSystemRepository = userSystemRepository;
    }

    @Override
    public UserSystem save(UserSystem userSystem) {

        return userSystemRepository.save(userSystem);
    }

    @Override
    public UserSystem findByUsername(String username) {
        return userSystemRepository.findByUsername(username);
    }

    @Override
    public List<UserSystem> findAll() {
        return userSystemRepository.findAll();
    }
}
