package bo.com.ahosoft.server.repository;

import bo.com.ahosoft.server.domain.UserSystem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 13-04-18 - 04:55 PM
 * Project       : sprint-boot-angular-jboss-maven-starter
 * Package       : bo.com.ahosoft.server.repository
 **/
public interface UserSystemRepository extends JpaRepository<UserSystem, Long> {

    UserSystem findByUsername(String username);
}
