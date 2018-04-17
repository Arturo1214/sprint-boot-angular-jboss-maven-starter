package bo.com.ahosoft.server.web.rest;

import bo.com.ahosoft.server.domain.Customer;
import bo.com.ahosoft.server.service.CustomerService;
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
 * Date          : 17-04-18 - 03:17 PM
 * Project       : sprint-boot-angular-jboss-maven-starter
 * Package       : bo.com.ahosoft.server.web.rest
 **/
@RestController
@RequestMapping("/api")
public class CustomerResource {
    
    private final Logger log = LoggerFactory.getLogger(CompanyResource.class);
    
    private static final String ENTITY_NAME = "customer";
    
    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * POST  /customers : Create a new region.
     *
     * @param customer the customer to create
     * @return the ResponseEntity with status 201 (Created) and with body the new customer, or with status 400 (Bad Request) if the region has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/customers")
    
    public ResponseEntity<Customer> createRegion(@RequestBody Customer customer) throws URISyntaxException {
        log.debug("REST request to save Region : {}", customer);
        if (customer.getId() != null) {
            throw new URISyntaxException("A new region cannot already have an ID", ENTITY_NAME + " id exists");
        }
        Customer result = customerService.save(customer);
        return ResponseEntity.created(new URI("/api/customers/" + result.getId()))
                .body(result);
    }

    /**
     * PUT  /customers : Updates an existing region.
     *
     * @param customer the customer to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated customer,
     * or with status 400 (Bad Request) if the customer is not valid,
     * or with status 500 (Internal Server Error) if the customer couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/customers")
    
    public ResponseEntity<Customer> updateRegion(@RequestBody Customer customer) throws URISyntaxException {
        log.debug("REST request to update Region : {}", customer);
        if (customer.getId() == null) {
            return createRegion(customer);
        }
        Customer result = customerService.save(customer);
        return ResponseEntity.ok()
                .body(result);
    }

    /**
     * GET  /customers : get all the customers.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of customers in body
     */
    @GetMapping("/customers")
    
    public List<Customer> getAllRegions() {
        log.debug("REST request to get all Regions");
        return customerService.findAll();
    }

    /**
     * GET  /customers/:id : get the "id" region.
     *
     * @param id the id of the customer to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the customer, or with status 404 (Not Found)
     */
    @GetMapping("/customers/{id}")
    
    public ResponseEntity<Customer> getRegion(@PathVariable Long id) {
        log.debug("REST request to get Region : {}", id);
        Customer customer = customerService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(customer));
    }

    /**
     * DELETE  /customers/:id : delete the "id" region.
     *
     * @param id the id of the customer to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Long id) {
        log.debug("REST request to delete Region : {}", id);
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
