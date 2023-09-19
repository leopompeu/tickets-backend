CREATE TABLE tickets(
    id SERIAL PRIMARY KEY,
    title TEXT NOT NULL,
    price FLOAT NOT NULL,
    image TEXT
);