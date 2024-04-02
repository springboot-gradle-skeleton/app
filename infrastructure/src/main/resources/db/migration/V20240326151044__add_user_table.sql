CREATE TABLE users (
	id BIGINT auto_increment NOT NULL,
	user_name varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	CONSTRAINT users_pk PRIMARY KEY (id)
);