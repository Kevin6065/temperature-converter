import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Coffee;
import model.CoffeeDao;
import model.User;



@Path("/coffees")
public class CoffeeController {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	 public List<Coffee> getCoffees() {
//		   EntityManagerFactory factory=Persistence.createEntityManagerFactory("mvrestjpa0701");
//		   EntityManager mgr=factory.createEntityManager();
//		   TypedQuery<Coffee> query=mgr.createNamedQuery("Coffee.findAll", Coffee.class);
//		   List<Coffee> cofs= query.getResultList();
		CoffeeDao dao = new CoffeeDao();
		   return dao.getAllCoffees();
		
	   }
	 @GET
	   @Path("/{cofName}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public Response getCoffee(@PathParam("cofName") String cofName) {
		   CoffeeDao dao = new CoffeeDao();
		   Coffee cof = dao.findByName(cofName);
		   if(cof==null) {
			   return Response.status(Response.Status.NOT_FOUND).build();
		   }
		   return Response.ok(cof).build();
	   }
	
	
	
}
