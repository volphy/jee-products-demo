package pl.krzysztofwilk.demo.products.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "category")
@Embeddable
@NoArgsConstructor
@Getter
@ToString
public class Category {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String name;

    private String description;
}
