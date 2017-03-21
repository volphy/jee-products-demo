package pl.krzysztofwilk.demo.products.category;

import pl.krzysztofwilk.demo.products.category.Category;
import pl.krzysztofwilk.demo.products.category.CategoryBean;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("categories")
public class CategoryEndpoint {

    @EJB
    private CategoryBean categoryBean;

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allCategories() {

        List<Category> categories = categoryBean.findAll();

        return Response.ok(categories).build();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCategory(@PathParam("id") long id) {

        Category category = categoryBean.find(id);

        return Response.ok(category).build();
    }
}
