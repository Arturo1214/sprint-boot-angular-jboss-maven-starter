package bo.com.ahosoft.server.repository;

import bo.com.ahosoft.server.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 10-04-18 - 11:15 AM
 * Project       : sprint-boot-angular-jboss-maven-starter
 * Package       : bo.com.ahosoft.server.repository
 **/
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
