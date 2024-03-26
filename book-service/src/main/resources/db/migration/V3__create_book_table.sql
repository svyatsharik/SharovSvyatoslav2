create table book(
	id bigserial primary key,
 	title text not null,
	author_id BIGINT REFERENCES author (id)
);
