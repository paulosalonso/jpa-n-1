# JPA N+1

Projeto criado com SpringBoot. Usa os starters do Spring Web e Spring Data JPA.

## Objetivo

Demonstrar o que é problema do N+1 e apresentar possíveis soluções.

## Inicialização

Pela IDE de sua preferência (Eclipse, STS, IntelliJ, etc)

Via maven
> mvn spring-boot:run

Via Java
> mvn clean package \
> java -jar target/jpqlleftjoin-0.0.1-SNAPSHOT.jar 

## Banco de dados

A aplicação utiliza o banco H2 em memória. Ao inicializar é criada a tabela category, a qual é populada com 5 registros. Por ser um banco em memória, ao encerrar a aplicação os dados são perdidos.

## Vídeo

Gravei um vídeo demonstrando as causas e possibilidades. O projeto está igual ao exemplo final.

https://www.loom.com/share/d8efa81ecdfd41d793a8e737ea08c334

