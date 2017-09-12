CREATE TABLE IF NOT EXISTS Author (
  author_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  address_line1 VARCHAR (50),
  address_line2 VARCHAR (25),
  city VARCHAR (50),
  state VARCHAR (50),
  country VARCHAR (25),
  zipcode INT(9) NULL
  );
CREATE TABLE IF NOT EXISTS Book (
  bookid BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  bookname VARCHAR(100),
  author_id BIGINT, KEY fk_book_authorid_idx (author_id), INDEX aut_ind (author_id),
  CONSTRAINT fk_book_authorid  FOREIGN KEY (author_id)
        REFERENCES author(author_id)
        ON DELETE CASCADE ON UPDATE CASCADE
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;

