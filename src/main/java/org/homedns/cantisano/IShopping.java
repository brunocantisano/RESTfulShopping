/**
 * @author Bruno Cardoso Cantisano
 */
package org.homedns.cantisano;

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
	String login(String jsonData);
	String add(String jsonData);
	String edit(String jsonData);
	String delete(String jsonData);
	String list();
	String search(String jsonData);
	String details(String jsonData);
}