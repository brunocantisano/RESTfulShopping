# RestfullShopping
* Descri��o:
Um Shopping Center tem a necessidade de registrar as lojas que possui. Deve ser feito um sistema para permitir o cadastro e manuten��o dos dados de uma loja, assim como informar quando ela deixou de fazer parte do shopping. A loja pode possuir um ou mais segmentos (ex: Moda Masculina, Moda Feminina, Surfwear, Cal�ados, etc) e seus atributos devem incluir minimamente o CNPJ, o piso e n�mero da loja.

Exemplos reais de uso destes servi�os s�o:

- O site do shopping listar as lojas para o cliente final. Exemplos: barrashopping.com.br, viaparqueshopping.com.br, norteshopping.com.br, podendo entrar no detalhe de cada uma.
- O shopping, atrav�s de interface administrativa, incluir novas lojas, marcar lojas que sa�ram do shopping, editar dados

Regras:
- Aplica��o n�o possuir�o telas, todo o servi�o dever�o ser REST. Necess�rio uso de jax-rs.
- Aplica��o deve possuir testes unit�rios com JUnit
- Usar Maven
- Usar EJB3
- Desej�vel o uso de JPA para persist�ncia
- Todos os servi�os ser�o testados via POSTMAN e dever�o possuir no m�nimo as a��es de inclus�o/edi��o, consulta de um registro espec�fico, e listagem/busca.

Tecnologias Escolhidas:
- Servidor: Wildfly 10 (JEE7)

Banco de Dados:
- SQL Server (nome/senha: usuario/senha) - Backup (shopping_20181011.zip)

* Vers�es:
- wildfly-10.0.0.Final
- eclipse: Version: Neon.3 Release (4.6.3) Build id: 20170314-1500
- SQL Server 2016

* Criando o projeto com maven:

Standard Web Project
Create a standard Maven web project structure.
```
mvn archetype:generate -DgroupId=org.homedns.cantisano -DartifactId=RESTfulShopping -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
```

Note
To support Eclipse, use Maven command:
```
mvn eclipse:eclipse -Dwtpversion=2.0
```