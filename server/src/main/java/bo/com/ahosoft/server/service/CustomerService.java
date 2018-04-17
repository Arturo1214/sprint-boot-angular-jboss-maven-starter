package bo.com.ahosoft.server.service;

import bo.com.ahosoft.server.domain.Customer;

import java.util.List;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 17-04-18 - 03:17 PM
 * Project       : sprint-boot-angular-jboss-maven-starter
 * Package       : bo.com.ahosoft.server.service
 **/
public interface CustomerService {
    /**
     * Save a customer.
     *
     * @param customer the entity to save
     * @return the persisted entity
     * */
    Customer save(Customer customer);

    /**
     * Get all the customers.
     *
     * @return the list of customers
     * */
    List<Customer> findAll();

    /**
     * Get the "id" customer.
     *
     *  @param id the id of the entity
     *  @return the entity
     * */
    Customer findOne(Long id);

    /**
     * Get the "nit" customer
     *
     * @param nit the nit of the entity
     * @return the entity
     * */
    Customer findByNit(Integer nit);

    /**
     * Delete the "id" customer.
     *
     * @param id the id of the entity
     * */
    void delete(Long id);
}
