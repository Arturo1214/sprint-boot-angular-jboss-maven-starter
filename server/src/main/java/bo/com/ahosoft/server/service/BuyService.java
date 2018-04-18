package bo.com.ahosoft.server.service;

import bo.com.ahosoft.server.domain.Buy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 18-04-18 - 01:24 PM
 * Project       : sprint-boot-angular-jboss-maven-starter
 * Package       : bo.com.ahosoft.server.service
 **/
public interface BuyService {
    Buy save(Buy buy);

    Page<Buy> findAll(Pageable pageable);

    Buy findOne(Long id);

    void delete(Long id);
}
