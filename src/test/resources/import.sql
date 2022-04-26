DROP TABLE books_categories;

INSERT INTO categories (name) VALUES('Romance');
INSERT INTO categories (name) VALUES('Action');
INSERT INTO categories (name) VALUES('Fantasy');

INSERT INTO books (uuid, title, synopsis, isbn, publication_year, price, quantity_in_stock, author_name) VALUES ('12d51c0a-a843-46fc-8447-5fda559ec69b','JavaScript', 'Aprenda JavaScript', '9788533302273', '2001-03-14', 50.00, 23, 'JN Papo');
INSERT INTO books (uuid, title, synopsis, isbn, publication_year, price, quantity_in_stock, author_name) VALUES ('df670f4b-5d4d-4f70-ae78-f2ddc9fa1f14','Angular JS', 'Aprenda a primeira versão do Angular', '9788533302273', '2000-04-15', 80.00, 4, 'Gu Gou');
INSERT INTO books (uuid, title, synopsis, isbn, publication_year, price, quantity_in_stock, author_name) VALUES ('27eaa649-e8fa-4889-bd5a-ea6825b71e61','Algoritmos', 'Entenda lógica de programação', '9788533302273', '2000-04-30', 100.00, 23, 'JN Papo');
INSERT INTO books (uuid, title, synopsis, isbn, publication_year, price, quantity_in_stock, author_name) VALUES ('27eaa649-e8fa-4889-bd5a-ea6825b71e62','Algoritmos', 'Entenda lógica de programação', '9788533302273', '2000-04-30', 100.00, 23, 'JN Papo');
INSERT INTO books (uuid, title, synopsis, isbn, publication_year, price, quantity_in_stock, author_name) VALUES ('df670f4b-5d4d-4f70-ae78-f2ddc9fa1f15','Angular JS', 'Aprenda a primeira versão do Angular', '9788533302273', '2000-04-15', 80.00, 0, 'Gu Gou');

CREATE TABLE books_categories(book_id uuid NOT NULL REFERENCES books(uuid),category_id BIGINT NOT NULL REFERENCES categories(id),PRIMARY KEY (book_id, category_id))

INSERT INTO books_categories (book_id, category_id) VALUES ('12d51c0a-a843-46fc-8447-5fda559ec69b',1);
INSERT INTO books_categories (book_id, category_id) VALUES ('12d51c0a-a843-46fc-8447-5fda559ec69b',2);
INSERT INTO books_categories (book_id, category_id) VALUES ('12d51c0a-a843-46fc-8447-5fda559ec69b',3);
INSERT INTO books_categories (book_id, category_id) VALUES ('df670f4b-5d4d-4f70-ae78-f2ddc9fa1f14',1);
INSERT INTO books_categories (book_id, category_id) VALUES ('df670f4b-5d4d-4f70-ae78-f2ddc9fa1f14',2);
INSERT INTO books_categories (book_id, category_id) VALUES ('df670f4b-5d4d-4f70-ae78-f2ddc9fa1f14',3);
INSERT INTO books_categories (book_id, category_id) VALUES ('27eaa649-e8fa-4889-bd5a-ea6825b71e61',1);
INSERT INTO books_categories (book_id, category_id) VALUES ('27eaa649-e8fa-4889-bd5a-ea6825b71e61',2);
INSERT INTO books_categories (book_id, category_id) VALUES ('27eaa649-e8fa-4889-bd5a-ea6825b71e61',3);
