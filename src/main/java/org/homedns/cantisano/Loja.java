/**
 * @author Bruno Cardoso Cantisano
 */
package org.homedns.cantisano;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "Loja")
/**
 * <p>
 * Classe que manipula dados da loja no shopping.
 * <p>
 */
public class Loja {
	/**
	 * Um Shopping Center tem a necessidade de registrar as lojas 
	 * que possui. O sistema permite o cadastro e manutenção dos 
	 * dados de uma loja, assim como informa quando ela deixou de 
	 * fazer parte do shopping. 
	 * A loja pode possuir um ou mais segmentos (ex: Moda Masculina, 
	 * Moda Feminina, Surfwear, Calçados, etc) e seus atributos 
	 * devem possuem CNPJ, piso e número da loja.	
	 */
    @Id
    private int cnpj;
    
    @Column(name="nome")
    private String nome;
    
    @Column(name="piso")
    private int piso;

    @Column(name="numero")
    private int numero;

    @Column(name="dataSaida")
    @Temporal(TemporalType.DATE)
    private Date dataSaida;

    @Column(name="segmentos")
    private String[] segmentos;
    
    /**
     * Método que retorna o piso da loja.
     *
     * @return inteiro com o numero do piso
     */
    public int getPiso() {
        return piso;
    }
    /**
     * Método que atribui o piso da loja.
     *
     * @param inteiro com o numero do piso
     */
    public void setPiso(int piso) {
        this.piso = piso;
    }
    /**
     * Método que retorna o número da loja.
     *
     * @return inteiro com o numero da loja
     */
    public int getNumero() {
        return numero;
    }
    /**
     * Método que atribui o número da loja.
     *
     * @param inteiro com o numero da loja
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    /**
     * Método que retorna o nome da loja.
     *
     * @return string com o nome da loja
     */
    public String getNome() {
        return nome;
    }
    /**
     * Método que atribui o nome da loja.
     *
     * @param string com o nome da loja
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Método que retorna a data de saída do shopping.
     *
     * @return data de desvinculação da loja com o shopping
     */
    public Date getDataSaida() {
        return dataSaida;
    }
    /**
     * Método que atribui a data de saída do shopping.
     *
     * @param data de desvinculação da loja com o shopping
     */
    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }
    /**
     * Método que retorna o cnpj da loja.
     *
     * @return inteiro com 14 caracteres que possui o cnpj da loja
     */
    public int getCnpj() {
        return cnpj;
    }
    /**
     * Método que atribui o cnpj da loja.
     *
     * @param inteiro com 14 caracteres que possui o cnpj da loja
     */
    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }
    /**
     * Método que retorna os segmentos da loja.
     *
     * @return vetor de string com os segmentos
     */
    public String[] getSegmentos() {
        return segmentos;
    }
    /**
     * Método que atribui lista de segmentos da loja.
     *
     * @param vetor de string com os segmentos
     */
	public void setSegmentos(String[] segmentos) {
		this.segmentos = segmentos;
	}
}