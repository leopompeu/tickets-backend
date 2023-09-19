CREATE TABLE users(
    id VARCHAR PRIMARY KEY UNIQUE NOT NULL,
    role VARCHAR NOT NULL,
    username VARCHAR(20) UNIQUE NOT NULL,
    password VARCHAR UNIQUE NOT NULL,
    email VARCHAR(320) UNIQUE NOT NULL,
    address VARCHAR(100),
    city VARCHAR(85),
    state VARCHAR(85),
    country VARCHAR(56),
    postal_code VARCHAR(10),
    register_date DATE NOT NULL,
    birth_date DATE NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL
);