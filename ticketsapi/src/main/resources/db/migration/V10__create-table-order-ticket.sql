CREATE TABLE order_tickets(
    id SERIAL PRIMARY KEY NOT NULL,
    orderId VARCHAR NOT NULL,
    ticketId INTEGER NOT NULL
);