ALTER TABLE tickets
    ADD COLUMN event_date DATE NOT NULL,
    ADD COLUMN add_date DATE NOT NULL,
    ADD COLUMN selling_date DATE NOT NULL;