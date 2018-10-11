/**
 * @author Bruno Cardoso Cantisano
 */
package org.homedns.cantisano;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
/**
 * <p>
 * Classe que manipula dados de usuário admin do shopping.
 * <p>
 */
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="nome")
	private String nome;

	@Column(name="senha")
	private String senha;
	/**
	 * Método que retorna o nome do usuário admin da loja.
	 *
	 * @return string com o nome do usuário admin
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Método que atribui o nome do usuário admin da loja.
	 *
	 * @param string com o nome do usuário admin da loja
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Método que retorna a senha de admin da loja.
	 *
	 * @return string com a senha admin
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * Método que atribui a senha de admin da loja.
	 *
	 * @param string com a senha de admin
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}    
    /**
     * Método que retorna o id da tabela.
     *
     * @return inteiro com o id da tabela
     */
	public int getId() {
		return id;
	}
	/**
	 * Método que atribui o id da tabela.
	 *
	 * @param inteiro com o id da tabela
	 */
	public void setId(int id) {
		this.id = id;
	}    
}