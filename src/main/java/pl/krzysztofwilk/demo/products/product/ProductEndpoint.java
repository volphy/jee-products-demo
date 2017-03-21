package pl.krzysztofwilk.demo.products.product;

import lombok.extern.slf4j.Slf4j;
import pl.krzysztofwilk.demo.products.category.Category;
import pl.krzysztofwilk.demo.products.category.CategoryBean;

import javax.ejb.EJB;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Slf4j
@Path("products")
public class ProductEndpoint {

    @EJB
    private ProductBean productBean;

    @EJB
    private CategoryBean categoryBean;

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allProducts() {
        List<Product> products = productBean.findAll();

        return Response.ok(products).build();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findProduct(@PathParam("id") long id,
                                @QueryParam("expand") @DefaultValue("false") boolean expand) {

        if (expand) {
            ProductWithCategory productWithCategory = getProductWithCategory(getProduct(id));
            return Response.ok(productWithCategory).build();
        } else {
            return Response.ok(getProduct(id)).build();
        }
    }

    private Product getProduct(long id) {
        return productBean.find(id);
    }

    private ProductWithCategory getProductWithCategory(Product product) {
        Category category = categoryBean.find(product.getCategoryId());

        return new ProductWithCategory(product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCurrency(),
                category);
    }
}
