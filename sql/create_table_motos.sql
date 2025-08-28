-- Criar a tabela motos
CREATE TABLE motos (
    id SERIAL PRIMARY KEY,  -- Usando SERIAL para auto incremento no PostgreSQL
    nome VARCHAR(255),
    ano INT,
    preco DOUBLE PRECISION
);

