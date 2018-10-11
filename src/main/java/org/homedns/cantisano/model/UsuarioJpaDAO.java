/**
 * @author Bruno Cardoso Cantisano
 */
package org.homedns.cantisano.model;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.homedns.cantisano.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * <p>
 * Classe que manipula o domínio da tabela usuário.
 * <p>
 */
public class UsuarioJpaDAO {
	//create ObjectMapper instance
	private static final ObjectMapper objectMapper = new ObjectMapper();
	private static UsuarioJpaDAO instance;
	protected EntityManager entityManager;

	public static UsuarioJpaDAO getInstance(){
		if (instance == null){
			instance = new UsuarioJpaDAO();
		}

		return instance;
	}

	private UsuarioJpaDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Usuario getById(final int id) {
		return entityManager.find(Usuario.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {
		return entityManager.createQuery("FROM " + Usuario.class.getName()).getResultList();
	}

	public void persist(String jsonData) {		
		try {
			Usuario usuario = objectMapper.readValue(jsonData, Usuario.class);
			entityManager.getTransaction().begin();
			entityManager.persist(usuario);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(String jsonData) {
		try {
			Usuario usuario = objectMapper.readValue(jsonData, Usuario.class);
			entityManager.getTransaction().begin();
			entityManager.merge(usuario);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(String jsonData) {
		try {
			Usuario usuario = objectMapper.readValue(jsonData, Usuario.class);
			entityManager.getTransaction().begin();
			usuario = entityManager.find(Usuario.class, usuario.getId());
			entityManager.remove(usuario);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) {
		try {
			Usuario usuario = getById(id);
			String jsonData = objectMapper.writeValueAsString(usuario);
			remove(jsonData);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean checkLogin(String jsonData) {
		
		try {
			List<Usuario> meusUsuarios = Arrays.asList(objectMapper.readValue(jsonData, Usuario[].class));
			Usuario u1 = meusUsuarios.get(0);
			Usuario u2 = meusUsuarios.get(1);

			if (u1.getSenha().equals(u2.getSenha()) && u1.getNome().equals(u2.getNome())) return true;
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return false;
	}
}