import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.User;

@Path("/hello")
public class Hello {
	@GET
	@Produces(MediaType.TEXT_PLAIN +";charset=UTF-8")
		public String sayhello()
		{
			return "hello , world  /大家好";
		}
	@GET
	@Path("/html")
	@Produces(MediaType.TEXT_HTML +";charset=UTF-8")
		public String sayhello2()
		{
			return "<h1 style='color:blue'>  大好晚上好   </h1>";
		}
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON +";charset=UTF-8")
		public User user(){
			User user =new User();
			user.setName("小名");
			user.setAge(18);	
			return user;
		}

}
