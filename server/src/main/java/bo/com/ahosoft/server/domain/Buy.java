package bo.com.ahosoft.server.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 17-04-18 - 01:44 PM
 * Project       : sprint-boot-angular-jboss-maven-starter
 * Package       : bo.com.ahosoft.server.domain
 **/
@Entity
@Getter
@Setter
@ToString(exclude = {"customer", "buyProducts"})
public class Buy implements Serializable {
    @Id
    @Column(unique = true, nullable = false, precision = 22)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    private BigDecimal totalPrice;

    @OneToMany(mappedBy = "buy", cascade = CascadeType.REMOVE)
    private Set<BuyProduct> buyProducts = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buy buy = (Buy) o;
        return Objects.equals(getId(), buy.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
