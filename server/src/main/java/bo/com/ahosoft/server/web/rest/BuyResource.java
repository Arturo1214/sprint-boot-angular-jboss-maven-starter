package bo.com.ahosoft.server.web.rest;

import bo.com.ahosoft.server.domain.Buy;
import bo.com.ahosoft.server.service.BuyService;
import bo.com.ahosoft.server.web.rest.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 18-04-18 - 01:59 PM
 * Project       : sprint-boot-angular-jboss-maven-starter
 * Package       : bo.com.ahosoft.server.web.rest
 **/
@RestController
@RequestMapping("/api")
public class BuyResource {

    private final Logger log = LoggerFactory.getLogger(BuyResource.class);

    private static final String ENTITY_NAME = "buy";

    private final BuyService buyService;

    public BuyResource(BuyService buyService) {
        this.buyService = buyService;
    }

    @PostMapping("/buys")
    public ResponseEntity<Buy> createBuy(@RequestBody Buy buy) throws URISyntaxException {
        log.debug("REST request to save Buy : {}", buy);
        if (buy.getId() != null) {
            throw new URISyntaxException("A new buy cannot already have an ID", ENTITY_NAME + " id exists");
        }
        Buy result = buyService.save(buy);
        return ResponseEntity.created(new URI("/api/buys/" + result.getId()))
                .body(result);
    }

    @PutMapping("/buys")
    public ResponseEntity<Buy> updateBuy(@RequestBody Buy buy) throws URISyntaxException {
        log.debug("REST request to update Buy : {}", buy);
        if (buy.getId() == null) {
            return  createBuy(buy);
        }
        Buy result = buyService.save(buy);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/buys")
    public ResponseEntity<List<Buy>> getAllBuys(Pageable pageable) {
        final Page<Buy> page = buyService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/buys");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);

    }

    @DeleteMapping("/buys/{id}")
    public ResponseEntity<Void> deleteBuy(@PathVariable Long id) {
        log.debug("REST request to delete Buy : {}", id);
        buyService.delete(id);
        return ResponseEntity.ok().build();
    }
}
