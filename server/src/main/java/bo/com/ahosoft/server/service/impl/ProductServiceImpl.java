package bo.com.ahosoft.server.service.impl;

import bo.com.ahosoft.server.domain.Product;
import bo.com.ahosoft.server.repository.ProductRepository;
import bo.com.ahosoft.server.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 17-04-18 - 03:39 PM
 * Project       : sprint-boot-angular-jboss-maven-starter
 * Package       : bo.com.ahosoft.server.service.impl
 **/
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        log.debug("Request to save Product : {}", product);
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        log.debug("Request to gel all Products");
        return productRepository.findAll();
    }

    @Override
    public Product findOne(Long id) {
        log.debug("Request to get Product : {}", id);
        return productRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Product : {}", id);
        productRepository.delete(id);
    }
}
