package bo.com.ahosoft.server.service;

import bo.com.ahosoft.server.domain.Company;
import bo.com.ahosoft.server.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 10-04-18 - 11:54 AM
 * Project       : sprint-boot-angular-jboss-maven-starter
 * Package       : bo.com.ahosoft.server.service.impl
 **/

public interface CompanyService {

    Company save(Company company);

    List<Company> findAll();

    Company findOne(Long id);

    void delete(Long id);
}
