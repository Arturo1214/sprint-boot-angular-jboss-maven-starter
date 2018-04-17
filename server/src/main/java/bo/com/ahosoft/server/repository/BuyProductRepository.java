package bo.com.ahosoft.server.repository;

import bo.com.ahosoft.server.domain.BuyProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 17-04-18 - 03:11 PM
 * Project       : sprint-boot-angular-jboss-maven-starter
 * Package       : bo.com.ahosoft.server.repository
 **/
@SuppressWarnings("unused")
@Repository
public interface BuyProductRepository extends JpaRepository<BuyProduct, Long> {
}
