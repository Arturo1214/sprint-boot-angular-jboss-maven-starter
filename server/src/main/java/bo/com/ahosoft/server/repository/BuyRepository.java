package bo.com.ahosoft.server.repository;

import bo.com.ahosoft.server.domain.Buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 17-04-18 - 03:09 PM
 * Project       : sprint-boot-angular-jboss-maven-starter
 * Package       : bo.com.ahosoft.server.repository
 **/
@SuppressWarnings("unused")
@Repository
public interface BuyRepository extends JpaRepository<Buy, Long> {
}
