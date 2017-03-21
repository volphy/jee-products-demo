package pl.krzysztofwilk.demo.products.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "product")
@NoArgsConstructor
@ToString
@Getter
public class Product extends AbstractProduct {

    @Column(name = "category_id")
    @JsonProperty("category_id")
    private long categoryId;
}
