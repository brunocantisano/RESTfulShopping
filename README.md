# RestfullShopping
* Descrição:
Um Shopping Center tem a necessidade de registrar as lojas que possui. Deve ser feito um sistema para permitir o cadastro e manutenção dos dados de uma loja, assim como informar quando ela deixou de fazer parte do shopping. A loja pode possuir um ou mais segmentos (ex: Moda Masculina, Moda Feminina, Surfwear, Calçados, etc) e seus atributos devem incluir minimamente o CNPJ, o piso e número da loja.

Exemplos reais de uso destes serviços são:

- O site do shopping listar as lojas para o cliente final. Exemplos: barrashopping.com.br, viaparqueshopping.com.br, norteshopping.com.br, podendo entrar no detalhe de cada uma.
- O shopping, através de interface administrativa, incluir novas lojas, marcar lojas que saíram do shopping, editar dados

Regras:
- Aplicação não possuirão telas, todo o serviço deverão ser REST. Necessário uso de jax-rs.
- Aplicação deve possuir testes unitários com JUnit
- Usar Maven
- Usar EJB3
- Desejável o uso de JPA para persistência
- Todos os serviços serão testados via POSTMAN e deverão possuir no mínimo as ações de inclusão/edição, consulta de um registro específico, e listagem/busca.

Tecnologias Escolhidas:
- Servidor: Wildfly 10 (JEE7)

Banco de Dados:
- SQL Server (nome/senha: usuario/senha) - Backup (shopping_20181011.zip)
- Database name: shopping
* Versões:
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