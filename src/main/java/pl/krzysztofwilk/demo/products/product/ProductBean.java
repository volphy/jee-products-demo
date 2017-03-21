package pl.krzysztofwilk.demo.products.product;

import lombok.extern.slf4j.Slf4j;
import pl.krzysztofwilk.demo.products.product.Product;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import java.util.List;

@Slf4j
@Stateless
public class ProductBean {

    @Resource(lookup = "java:global/ProductsDS")
    DataSource productsDS;

    @PersistenceContext(unitName = "ProductsPU")
    private EntityManager em;

    public List<Product> findAll() {
        TypedQuery<Product> query = em.createQuery("select p from product p", Product.class);

        return query.getResultList();
    }

    public Product find(Object id) {
        return em.find(Product.class, id);
    }

}
