package bo.com.ahosoft.server.web.rest;

import bo.com.ahosoft.server.domain.Product;
import bo.com.ahosoft.server.service.ProductService;
import bo.com.ahosoft.server.web.rest.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.URIException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 17-04-18 - 03:52 PM
 * Project       : sprint-boot-angular-jboss-maven-starter
 * Package       : bo.com.ahosoft.server.web.rest
 **/
@RestController
@RequestMapping("/api")
public class ProductResource {
    private final Logger log = LoggerFactory.getLogger(ProductResource.class);

    private static final String ENTITY_NAME = "product";

    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) throws URISyntaxException {
        if (product.getId() != null) {
            throw new URISyntaxException("A new product cannot already have and ID", ENTITY_NAME +  " id exists");
        }
        Product result = productService.save(product);
        return ResponseEntity.created(new URI("/api/products/" + result.getId()))
                .body(result);
    }

    @PutMapping("/products")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws URISyntaxException {
        if (product.getId() == null) {
            return createProduct(product);
        }
        Product result = productService.save(product);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/products")
    public List<Product> getAllProduct() {
        log.debug("REST request to gel all Products");
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        log.debug("REST request to get Product : {}", id);
        Product result = productService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(result));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        log.debug("REST request to delete Company : {}", id);
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
}
