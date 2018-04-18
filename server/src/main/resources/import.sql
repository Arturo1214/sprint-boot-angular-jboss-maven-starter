
-- Inicializamos la BD

INSERT INTO user_system (username, password) VALUES ('admin', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.');

INSERT INTO customer (name, nit) VALUES ('Arturo Herrera Ocana', 7840462);
INSERT INTO customer (name, nit) VALUES ('Carlos Marquina Ortiz', 12345678);

INSERT INTO product (active, description, name, price) VALUES (true, 'Coca Cola Descripcion', 'Coca Cola', 12.5);
INSERT INTO product (active, description, name, price) VALUES (true, 'Hamburguesa', 'Hamgurguesa', 18.5);