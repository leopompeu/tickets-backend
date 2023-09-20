CREATE TABLE orders(
    id SERIAL PRIMARY KEY NOT NULL,
    date_order DATE NOT NULL,
    ticket_id INTEGER NOT NULL,
    status INTEGER NOT NULL,
    user_id VARCHAR NOT NULL
);