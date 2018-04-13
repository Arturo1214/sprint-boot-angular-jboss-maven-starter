package bo.com.ahosoft.server.service.impl;

import bo.com.ahosoft.server.domain.Company;
import bo.com.ahosoft.server.repository.CompanyRepository;
import bo.com.ahosoft.server.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 13-04-18 - 10:52 AM
 * Project       : sprint-boot-angular-jboss-maven-starter
 * Package       : bo.com.ahosoft.server.service.impl
 **/

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
    private final Logger log = LoggerFactory.getLogger(CompanyServiceImpl.class);

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    /**
     * Save a company.
     *
     * @param company the entity to save
     * @return the persisted entity
     * */
    public Company save(Company company) {
        log.debug("Request to save Company: {}", company);
        return companyRepository.save(company);
    }

    /**
     * Get all the companies.
     *
     * @return the list of entities
     * */
    @Transactional(readOnly = true)
    public List<Company> findAll() {
        log.debug("Request to get all Companies");
        return companyRepository.findAll();
    }

    /**
     * Get one company by id.
     *
     * @param id the id of the entity
     * @return the entity
     * */
    @Transactional(readOnly = true)
    public Company findOne(Long id) {
        log.debug("Request to get Company : {}", id);
        return companyRepository.findOne(id);
    }

    /**
     * Delete the company by id
     *
     * @param id the id of the entity
     * */
    public void delete(Long id) {
        log.debug("Request to delete Company : {}", id);
        companyRepository.delete(id);
    }
}
