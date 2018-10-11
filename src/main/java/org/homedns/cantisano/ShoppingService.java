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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.homedns.cantisano.ResponseMessage;

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
	private static final ObjectMapper objectMapper = new ObjectMapper();

	@POST
	@Path("/admin")
	@Produces({MediaType.APPLICATION_JSON})
	public Response login(String jsonData) {	
		ResponseMessage ResponseRet = new ResponseMessage(); 
		ResponseRet.setMsg("Não foi possível logar como admin!");
		try {
			if (usuarioDAO.checkLogin(jsonData)) {
				ResponseRet.setCodErro(ResponseMessage.RET_OK);	
			}
			else{
				ResponseRet.setCodErro(ResponseMessage.RET_ERROR);
			}			
			ResponseRet.setMsg(jsonData);
			ResponseRet.setErrorMessage("Usuário logado com sucesso!");
			jsonData = objectMapper.writeValueAsString(ResponseRet);
		} catch (JsonProcessingException e) {
			ResponseRet.setErrorMessage(e.getMessage());
		}		
		return Response.status(ResponseRet.getCodErro()).entity(jsonData).build();
	}

	@POST
	@Path("/loja")
	@Produces({MediaType.APPLICATION_JSON})
	public Response add(String jsonData) {	
		ResponseMessage ResponseRet = new ResponseMessage(); 
		ResponseRet.setMsg("Não foi possível adicionar a loja!");
		try {
			if (lojaDAO.persist(jsonData)) {
				ResponseRet.setCodErro(ResponseMessage.RET_OK);	
			}
			else{
				ResponseRet.setCodErro(ResponseMessage.RET_ERROR);
			}			
			ResponseRet.setMsg(jsonData);
			ResponseRet.setErrorMessage("Loja adicionada com sucesso!");
			jsonData = objectMapper.writeValueAsString(ResponseRet);
		} catch (JsonProcessingException e) {
			ResponseRet.setErrorMessage(e.getMessage());
		}		
		return Response.status(ResponseRet.getCodErro()).entity(jsonData).build();
	}

	@PUT
	@Path("/loja/{cnpj}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response edit(@PathParam("cnpj") String jsonData) {	
		ResponseMessage ResponseRet = new ResponseMessage(); 
		ResponseRet.setMsg("Não foi possível editar a loja!");
		try {
			if (lojaDAO.merge(jsonData)) {
				ResponseRet.setCodErro(ResponseMessage.RET_OK);	
			}
			else{
				ResponseRet.setCodErro(ResponseMessage.RET_ERROR);
			}			
			ResponseRet.setMsg(jsonData);
			ResponseRet.setErrorMessage("Loja editada com sucesso!");
			jsonData = objectMapper.writeValueAsString(ResponseRet);
		} catch (JsonProcessingException e) {
			ResponseRet.setErrorMessage(e.getMessage());
		}		
		return Response.status(ResponseRet.getCodErro()).entity(jsonData).build();
	}

	@DELETE
	@Path("/loja/{cnpj}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response delete(@PathParam("cnpj") String jsonData) {		
		ResponseMessage ResponseRet = new ResponseMessage(); 
		ResponseRet.setMsg("Não foi possível remover a loja!");
		try {
			if (lojaDAO.remove(jsonData)) {
				ResponseRet.setCodErro(ResponseMessage.RET_OK);	
			}
			else{
				ResponseRet.setCodErro(ResponseMessage.RET_ERROR);
			}			
			ResponseRet.setMsg(jsonData);
			ResponseRet.setErrorMessage("Loja removida com sucesso!");
			jsonData = objectMapper.writeValueAsString(ResponseRet);
		} catch (JsonProcessingException e) {
			ResponseRet.setErrorMessage(e.getMessage());
		}		
		return Response.status(ResponseRet.getCodErro()).entity(jsonData).build();
	}

	@GET
	@Path("/loja")
	@Produces({MediaType.APPLICATION_JSON})
	public Response list() {
		ResponseMessage ResponseRet = new ResponseMessage(); 
		ResponseRet.setMsg("Não foi possível listar as lojas!");
		String jsonData = "";
		try {
			List<Loja> lst = lojaDAO.findAll();
			if (lst != null) {
				ResponseRet.setCodErro(ResponseMessage.RET_OK);	
			}
			else{
				ResponseRet.setCodErro(ResponseMessage.RET_ERROR);
			}			
			String jsonList = objectMapper.writeValueAsString(lst);				
			ResponseRet.setMsg(jsonList);
			ResponseRet.setErrorMessage("Lojas listadas com sucesso!");
			jsonData = objectMapper.writeValueAsString(ResponseRet);
		} catch (JsonProcessingException e) {
			ResponseRet.setErrorMessage(e.getMessage());
		}		
		return Response.status(ResponseRet.getCodErro()).entity(jsonData).build();
	}

	@GET
	@Path("/loja/{cnpj}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response search(@PathParam("cnpj") String jsonData) {		
		ResponseMessage ResponseRet = new ResponseMessage(); 
		ResponseRet.setMsg("Não foi possível listar a loja pelo cnpj!");
		try {
			List<Loja> lst = lojaDAO.findById(jsonData);
			if (lst != null) {
				ResponseRet.setCodErro(ResponseMessage.RET_OK);	
			}
			else{
				ResponseRet.setCodErro(ResponseMessage.RET_ERROR);
			}			
			String jsonList = objectMapper.writeValueAsString(lst);				
			ResponseRet.setMsg(jsonList);
			ResponseRet.setErrorMessage("Loja listada com sucesso!");
			jsonData = objectMapper.writeValueAsString(ResponseRet);
		} catch (JsonProcessingException e) {
			ResponseRet.setErrorMessage(e.getMessage());
		}		
		return Response.status(ResponseRet.getCodErro()).entity(jsonData).build();
	}

	@GET
	@Path("/loja/{cnpj}/details")
	@Produces({MediaType.APPLICATION_JSON})
	public Response details(@PathParam("cnpj") String jsonData) {
		String[] segmentos = lojaDAO.findDetails(jsonData);
		ResponseMessage ResponseRet = new ResponseMessage(); 
		ResponseRet.setMsg("Não foi possível detalhar os segmentos da loja pelo cnpj!");
		if (segmentos != null) {
			ResponseRet.setCodErro(ResponseMessage.RET_OK);
			String jsonSegmentos;
			try {
				jsonSegmentos = objectMapper.writeValueAsString(segmentos);
				ResponseRet.setMsg(jsonSegmentos);
				ResponseRet.setErrorMessage("Loja detalhada com sucesso!");
				jsonData = objectMapper.writeValueAsString(ResponseRet);				
			} catch (JsonProcessingException e) {
				ResponseRet.setErrorMessage(e.getMessage());
			}												
		}
		else{
			ResponseRet.setCodErro(ResponseMessage.RET_ERROR);
			ResponseRet.setMsg("Não foi possível encontrar os detalhes de segmentos da loja");
			ResponseRet.setErrorMessage("Erro no detalhamento da loja");
		}		
		return Response.status(ResponseRet.getCodErro()).entity(jsonData).build();
	} 
}