/**
 * @author Bruno Cardoso Cantisano
 */
package org.homedns.cantisano;

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
	String login(String jsonData);
	String add(String jsonData);
	String edit(String jsonData);
	String delete(String jsonData);
	String list();
	String search(String jsonData);
	String details(String jsonData);
}