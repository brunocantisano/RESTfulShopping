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
 * Classe que manipula dados de usu�rio admin do shopping.
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
	 * M�todo que retorna o nome do usu�rio admin da loja.
	 *
	 * @return string com o nome do usu�rio admin
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * M�todo que atribui o nome do usu�rio admin da loja.
	 *
	 * @param string com o nome do usu�rio admin da loja
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * M�todo que retorna a senha de admin da loja.
	 *
	 * @return string com a senha admin
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * M�todo que atribui a senha de admin da loja.
	 *
	 * @param string com a senha de admin
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}    
    /**
     * M�todo que retorna o id da tabela.
     *
     * @return inteiro com o id da tabela
     */
	public int getId() {
		return id;
	}
	/**
	 * M�todo que atribui o id da tabela.
	 *
	 * @param inteiro com o id da tabela
	 */
	public void setId(int id) {
		this.id = id;
	}    
}