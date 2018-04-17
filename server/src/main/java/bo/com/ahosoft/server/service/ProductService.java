package bo.com.ahosoft.server.service;

import bo.com.ahosoft.server.domain.Product;

import java.util.List;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 17-04-18 - 03:36 PM
 * Project       : sprint-boot-angular-jboss-maven-starter
 * Package       : bo.com.ahosoft.server.service
 **/
public interface ProductService {

    Product save(Product product);

    List<Product> findAll();

    Product findOne(Long id);

    void delete(Long id);
}
