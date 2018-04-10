package bo.com.ahosoft.server.web.rest;

import bo.com.ahosoft.server.domain.Company;
import bo.com.ahosoft.server.service.CompanyService;
import bo.com.ahosoft.server.web.rest.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 10-04-18 - 01:19 PM
 * Project       : sprint-boot-angular-jboss-maven-starter
 * Package       : bo.com.ahosoft.server.web.rest
 **/
@RestController
@RequestMapping("/api")
public class CompanyResource {

    private final Logger log = LoggerFactory.getLogger(CompanyResource.class);

    private static final String ENTITY_NAME = "company";

    private final CompanyService companyService;

    public CompanyResource(CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     * POST /companies a new company.
     *
     * @param company the company to create
     * @return the ResponseEntity with status 201 (Created) and with body the new company
     * @throws URISyntaxException if the Location URI syntax is incorrect
     * */
    @PostMapping("/companies")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) throws URISyntaxException {
        log.debug("REST request to save company : {}", company);
        if (company.getId() != null) {
            throw new URISyntaxException("A new company cannot already have an ID", String.format("%s id exists", ENTITY_NAME));
        }
        Company result = companyService.save(company);
        return ResponseEntity.created(new URI("/api/companies/" + result.getId()))
                .body(result);
    }

    /**
     * PUT /companies : Updates an existing company.
     *
     * @param company the company to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated company
     * @throws URISyntaxException if the Location URI sintax is incorrect
     * */
    @PutMapping("/companies")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company) throws URISyntaxException {
        log.debug("REST request to update Company : {}", company);
        if (company.getId() == null)
            return createCompany(company);
        Company result = companyService.save(company);
        return ResponseEntity.ok()
                .body(result);
    }

    /**
     * GET /companies : get all the companies.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of sales in body
     * */
    @GetMapping("/companies")
    public List<Company> getAllCompanies() {
        log.debug("REST request to get all Companies");
        return companyService.findAll();
    }

    /**
     * GET /companies/:id get the "id" company.
     *
     * @param id the id of the company to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the company, or with status 404 (Not Found)
     * */
    @GetMapping("/companies/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id) {
        log.debug("REST request to get Company : {}", id);
        Company result = companyService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(result));
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        log.debug("REST request to delete Company : {}", id);
        companyService.delete(id);
        return ResponseEntity.ok().build();
    }
}
