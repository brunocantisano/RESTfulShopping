/**
 * @author Bruno Cardoso Cantisano
 */
package org.homedns.cantisano;

import javax.ws.rs.core.Response;

/**
 * <p>
 * Interface que define as m�todos que ser�o implementados para manipula��o de lojas do shopping.
 * Cadastro 
 * Edi��o
 * Remo��o
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