package bo.com.ahosoft.server.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 17-04-18 - 01:51 PM
 * Project       : sprint-boot-angular-jboss-maven-starter
 * Package       : bo.com.ahosoft.server.domain
 **/
@Entity
@Table(name = "buy_product")
@Getter
@Setter
public class BuyProduct implements Serializable {
    @Id
    @Column(unique = true, nullable = false, precision = 22)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "id_product")
    private Product product;
    @OneToOne
    @JoinColumn(name = "id_buy")
    private Buy buy;
    private Integer amount;
    private BigDecimal totalPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyProduct that = (BuyProduct) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
