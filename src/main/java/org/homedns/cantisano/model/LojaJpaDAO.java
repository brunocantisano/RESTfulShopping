/**
 * @author Bruno Cardoso Cantisano
 */
package org.homedns.cantisano.model;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.homedns.cantisano.Loja;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * <p>
 * Classe que manipula o domínio da tabela loja.
 * <p>
 */
public class LojaJpaDAO {
	//create ObjectMapper instance
	private static final ObjectMapper objectMapper = new ObjectMapper();
	private static LojaJpaDAO instance;
	protected EntityManager entityManager;

	public static LojaJpaDAO getInstance(){
		if (instance == null){
			instance = new LojaJpaDAO();
		}

		return instance;
	}

	private LojaJpaDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Loja getById(final int id) {
		return entityManager.find(Loja.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Loja> findAll() {
		return entityManager.createQuery("FROM " + Loja.class.getName()).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Loja> findById(String jsonData) {
		try {
			Loja loja = objectMapper.readValue(jsonData, Loja.class);
			final int id = loja.getCnpj();
			Loja lojaBuscada = getById(id);
			return entityManager.createQuery("FROM " + lojaBuscada.getNome()).getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;		
	}

	public String[] findDetails(String jsonData) {
		try {
			Loja loja = objectMapper.readValue(jsonData, Loja.class);
			Loja lojaEncontrada = getById(loja.getCnpj());
			return lojaEncontrada.getSegmentos();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;		
	}
	public boolean persist(String jsonData) {
		try {
			Loja loja = objectMapper.readValue(jsonData, Loja.class);
			entityManager.getTransaction().begin();
			entityManager.persist(loja);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return false;
	}

	public boolean merge(String jsonData) {
		try {
			Loja loja = objectMapper.readValue(jsonData, Loja.class);
			entityManager.getTransaction().begin();
			entityManager.merge(loja);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return false;
	}

	public boolean remove(String jsonData) {
		try {
			Loja loja = objectMapper.readValue(jsonData, Loja.class);
			entityManager.getTransaction().begin();
			loja = entityManager.find(Loja.class, loja.getCnpj());
			entityManager.remove(loja);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return false;
	}

	public boolean removeById(final int id) {
		try {
			Loja loja = getById(id);
			String jsonData = objectMapper.writeValueAsString(loja);
			remove(jsonData);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
}