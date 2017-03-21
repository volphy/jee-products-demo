package pl.krzysztofwilk.demo.products.product;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import pl.krzysztofwilk.demo.products.category.Category;

import javax.persistence.Embedded;
import java.math.BigDecimal;

public class ProductWithCategory extends AbstractProduct {

    @Embedded
    @Getter
    private Category category;

    @JsonCreator
    public ProductWithCategory(long id,
                               String name,
                               BigDecimal price,
                               String currency,
                               Category category) {

        super.id = id;
        super.name = name;
        super.price = price;
        super.currency = currency;
        this.category = category;
    }
}
