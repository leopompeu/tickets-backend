ALTER TABLE orders
        ADD CONSTRAINT FK_orders_tickets FOREIGN KEY (ticket_id)
            REFERENCES tickets (id);
ALTER TABLE orders
        ADD CONSTRAINT FK_orders_users FOREIGN KEY (user_id)
            REFERENCES users (id);
ALTER TABLE users
        ADD COLUMN is_enabled BOOLEAN,
        ADD COLUMN is_non_expired BOOLEAN,
        ADD COLUMN is_non_locked BOOLEAN;
