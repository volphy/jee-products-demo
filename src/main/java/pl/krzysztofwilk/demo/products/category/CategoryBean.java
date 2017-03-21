package pl.krzysztofwilk.demo.products.category;

import lombok.extern.slf4j.Slf4j;
import pl.krzysztofwilk.demo.products.category.Category;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import java.util.List;

@Slf4j
@Stateless
public class CategoryBean {

    @Resource(lookup = "java:global/ProductsDS")
    DataSource productsDS;

    @PersistenceContext(unitName = "ProductsPU")
    private EntityManager em;

    public List<Category> findAll() {
        TypedQuery<Category> query = em.createQuery("select c from category c", Category.class);

        return query.getResultList();
    }

    public Category find(Object id) {
        return em.find(Category.class, id);
    }

}
