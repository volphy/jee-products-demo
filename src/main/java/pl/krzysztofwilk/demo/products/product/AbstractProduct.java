package pl.krzysztofwilk.demo.products.product;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@MappedSuperclass
@Getter
public abstract class AbstractProduct {

    @Id
    @GeneratedValue
    protected long id;

    @NotNull
    protected String name;

    @NotNull
    protected BigDecimal price;

    @NotNull
    protected String currency;
}
