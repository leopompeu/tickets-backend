CREATE TABLE tickets(
    id SERIAL PRIMARY KEY NOT NULL,
    title VARCHAR(150) NOT NULL,
    price FLOAT(12) NOT NULL,
    image VARCHAR(1275)
);