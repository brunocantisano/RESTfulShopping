/**
 * @author Bruno Cardoso Cantisano
 */
package org.homedns.cantisano;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.homedns.cantisano.model.LojaJpaDAO;
import org.homedns.cantisano.model.UsuarioJpaDAO;

/**
 * @author Bruno Cardoso Cantisano
 * url: "localhost:8080/RestfullShopping/rest/shop/"
 * will match to “ShoppingService“, via @Path("/shop"). 
 * And the “{any values}” from:
 * “localhost:8080/RestfullShopping/rest/shop/{any values}”
 * will match to parameter annotated with @PathParam.
 */

@Path("/shop")
public class ShoppingService implements IShopping {
	UsuarioJpaDAO usuarioDAO = UsuarioJpaDAO.getInstance();
	LojaJpaDAO lojaDAO = LojaJpaDAO.getInstance();
	
	@POST
	@Path("/admin")
	@Produces({MediaType.APPLICATION_JSON})
	public String login(String jsonData) {
		if(usuarioDAO.checkLogin(jsonData)) {
			Response.status(200);
			return "Login realizado com sucesso";
		}
		else {
			Response.status(400);
			return "Login inválido";
		}
	}
	
	@POST
	@Path("/loja")
	@Produces({MediaType.APPLICATION_JSON})
	public String add(String jsonData) {		
		if(lojaDAO.persist(jsonData)) {
			Response.status(200); 
			return "Loja adicionada com sucesso!";			
		}
		Response.status(400); 
		return "Loja adicionada com erro!";	
	}

	@PUT
	@Path("/loja/{cnpj}")
	@Produces({MediaType.APPLICATION_JSON})
	public String edit(@PathParam("cnpj") String jsonData) {
		if(lojaDAO.merge(jsonData)) {
			Response.status(200); 
			return "Loja editada com sucesso!";			
		}
		Response.status(400); 
		return "Loja editada com erro!";	
	}

	@DELETE
	@Path("/loja/{cnpj}")
	@Produces({MediaType.APPLICATION_JSON})
	public String delete(@PathParam("cnpj") String jsonData) {
		if(lojaDAO.remove(jsonData)) {
			Response.status(200); 
			return "Loja removida com sucesso!";			
		}
		Response.status(400); 
		return "Loja removida com erro!";	
	}

	@GET
	@Path("/loja")
	@Produces({MediaType.APPLICATION_JSON})
	public String list() {
		List<Loja> lst = lojaDAO.findAll();
		if (lst != null) {
			Response.status(200);	
		}
		else{
			Response.status(400);
		}
		return lst.toString();
	}

	@GET
	@Path("/loja/{cnpj}")
	@Produces({MediaType.APPLICATION_JSON})
	public String search(@PathParam("cnpj") String jsonData) {
		List<Loja> lstLojas = lojaDAO.findById(jsonData);
		if (lstLojas != null) {
			Response.status(200);
			return lstLojas.toString();
		}
		else{
			Response.status(400);
		}
		return "Não foi possível encontrar loja com este cnpj";
	}

	@GET
	@Path("/loja/{cnpj}/details")
	@Produces({MediaType.APPLICATION_JSON})
	public String details(@PathParam("cnpj") String jsonData) {
		String[] segmentos = lojaDAO.findDetails(jsonData);
		if (segmentos != null) {
			Response.status(200);
			return segmentos.toString();
		}
		else{
			Response.status(400);
		}
		return "Não foi possível encontrar os detalhes de segmentos da loja";
	} 
}