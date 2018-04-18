package bo.com.ahosoft.server.service.impl;

import bo.com.ahosoft.server.domain.Buy;
import bo.com.ahosoft.server.repository.BuyProductRepository;
import bo.com.ahosoft.server.repository.BuyRepository;
import bo.com.ahosoft.server.service.BuyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 18-04-18 - 01:24 PM
 * Project       : sprint-boot-angular-jboss-maven-starter
 * Package       : bo.com.ahosoft.server.service.impl
 **/
@Service
@Transactional
public class BuyServiceImpl implements BuyService {

    private final Logger log = LoggerFactory.getLogger(BuyServiceImpl.class);

    private final BuyRepository buyRepository;

    private final BuyProductRepository buyProductRepository;

    public BuyServiceImpl(BuyRepository buyRepository, BuyProductRepository buyProductRepository) {
        this.buyRepository = buyRepository;
        this.buyProductRepository = buyProductRepository;
    }

    @Override
    public Buy save(Buy buy) {
        log.debug("Request to save Buy :{}", buy);
        Buy result = buyRepository.save(buy);
        result.getBuyProducts().forEach(x -> {
            x.setBuy(buy);
            buyProductRepository.save(x);
        });
        return buyRepository.save(buy);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Buy> findAll(Pageable pageable) {
        log.debug("Request to get all Buys");
        return buyRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Buy findOne(Long id) {
        log.debug("Request to get Buy : {}", id);
        return buyRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Buy : {}", id);
        buyRepository.delete(id);
    }
}
