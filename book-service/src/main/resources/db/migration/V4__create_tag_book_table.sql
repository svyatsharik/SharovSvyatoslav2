create table tag_book(
	book_id BIGINT REFERENCES book (id) NOT NULL,
    tag_id   BIGINT REFERENCES tag (id) NOT NULL,
    PRIMARY KEY (tag_id, book_id)
);
