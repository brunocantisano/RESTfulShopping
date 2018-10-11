/**
 * @author Bruno Cardoso Cantisano
 */
package org.homedns.cantisano;

import javax.ws.rs.core.Response;

/**
 * <p>
 * Interface que define as métodos que serão implementados para manipulação de lojas do shopping.
 * Cadastro 
 * Edição
 * Remoção
 * Listagem
 * Busca
 * Listagem detalhada	
 * <p>
 */
public interface IShopping {
	Response login(String jsonData);
	Response add(String jsonData);
	Response edit(String jsonData);
	Response delete(String jsonData);
	Response list();
	Response search(String jsonData);
	Response details(String jsonData);
}