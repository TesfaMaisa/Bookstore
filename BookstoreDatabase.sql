DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS application_user;

CREATE TABLE category (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100)
);

INSERT INTO category (name) 
VALUES 
('Kauhu'),
('Romantiikka'),
('Komedia'),
(null);

CREATE TABLE book (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    publication_year INT,
    isbn VARCHAR(17) NOT NULL,
    price INT,
    category_id BIGINT REFERENCES category(id)
);

INSERT INTO book (title, author, publicationYear, isbn, price, category_id) 
VALUES 
('The Let Them Theory', 'Mel Robbins', 2024, '978-14-019-7136-6', 11, 1),
('Sunrise on the Reaping', 'Suzanne Collins', 2025, '978-154-61-7146-1', 33, 3),
('Atomic Habits', 'James', 2018, '978-0735-21-129-2', 44, null);

CREATE TABLE application_user (
    id BIGSERIAL PRIMARY KEY,
    application_username VARCHAR(100) NOT NULL,
    application_password VARCHAR(100) NOT NULL,
    application_role VARCHAR(100) NOT NULL
);

INSERT INTO application_user (application_username, application_password, application_role) 
VALUES 
('Abus','$2a$10$3nJrqaGwEA7wE6ycSUiTMunJ8uVfrpEL58fc52beyOuXHeSePolyC', 'ADMIN'),
('Nugus','$2a$10$X5uyOh6r5mc3V3BqtDRI7eeEAwyeQtXeanIUAku0gWRP2VmoHFZIq', 'USER');
