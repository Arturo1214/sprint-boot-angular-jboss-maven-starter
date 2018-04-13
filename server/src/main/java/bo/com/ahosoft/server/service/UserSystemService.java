package bo.com.ahosoft.server.service;

import bo.com.ahosoft.server.domain.UserSystem;

import java.util.List;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 13-04-18 - 04:57 PM
 * Project       : sprint-boot-angular-jboss-maven-starter
 * Package       : bo.com.ahosoft.server.service
 **/
public interface UserSystemService {

    UserSystem save(UserSystem userSystem);

    UserSystem findByUsername(String username);

    List<UserSystem> findAll();
}
