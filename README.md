# Loja de Motos

Este projeto é um sistema simples para gerenciar uma loja de motos, desenvolvido em Java, utilizando JDBC para integração com banco de dados PostgreSQL.

## Estrutura do Projeto

- **src/**: Contém os arquivos fonte e compilados do projeto.
  - `Main.java` / `Main.class`: Classe principal que executa o sistema.
  - `Moto.java` / `Moto.class`: Classe que representa o modelo de uma moto.
  - `MotoDao.java` / `MotoDao.class`: Classe responsável pelo acesso ao banco de dados (Data Access Object).
- **lib/**: Biblioteca externa necessária para conexão com o PostgreSQL.
  - `postgresql-42.7.7.jar`: Driver JDBC do PostgreSQL.
- **sql/**: Scripts SQL para criação das tabelas no banco de dados.
  - `create_table_motos.sql`: Script para criar a tabela de motos.

## Banco de Dados

- O projeto utiliza PostgreSQL.
- Use o script `sql/create_table_motos.sql` para criar a tabela necessária.

## Dependências

- Java JDK
- PostgreSQL
- Driver JDBC do PostgreSQL (`lib/postgresql-42.7.7.jar`)

## Observações

- Certifique-se de que o banco de dados está rodando e acessível.
- Ajuste o classpath conforme o local das pastas.

---

