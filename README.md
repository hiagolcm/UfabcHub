The Ufabc Hub
Projeto para a disciplina de programação para web 2018.2

Para executar o projeto:
1) Clone o repositorio

2) Crie um arquivo chamado application.properties no diretorio: src/main/resources/

3) Adicione no arquivo as seguintes configurações:

=======================================================================
spring.jpa.show-sql=true

spring.jpa.hibernate.ddl-auto=update

spring.datasource.driverClassName=org.postgresql.Driver

spring.datasource.url=jdbc:postgresql://localhost:5432/<database>

spring.datasource.username=<usuario>

spring.datasource.password=<senha>

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
========================================================================

4) Rode o projeto com o comando: gradle bootRun

5) Caso queira importar para o eclipse, utilize o comando: gradle eclipse
