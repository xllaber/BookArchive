# drop database if exists book_archive;
# create database book_archive;
use book_archive;
create table if not exists sagas (
    id bigint auto_increment primary key,
    name varchar(100),
    publish_start int not null,
    publish_end int,
    created_at TIMESTAMP default current_timestamp,
    updated_at TIMESTAMP default current_timestamp
);

create table if not exists authors (
    id bigint auto_increment primary key,
    name varchar(100) not null,
    country varchar(100),
    birth_year int not null,
    death_year int,
    image varchar(100),
    created_at TIMESTAMP default current_timestamp,
    updated_at TIMESTAMP default current_timestamp
);

create table if not exists genres (
    id bigint primary key auto_increment,
    name varchar(100),
    created_at TIMESTAMP default current_timestamp,
    updated_at TIMESTAMP default current_timestamp
);

create table if not exists books (
    id bigint auto_increment primary key,
    title varchar(100) not null,
    pages int not null,
    saga_num double,
    fave boolean,
    publish_year int not null,
    image varchar(100),
    saga_id bigint,
    created_at TIMESTAMP default current_timestamp,
    updated_at TIMESTAMP default current_timestamp,
    foreign key books_sagaId_fk (saga_id) references sagas(id)
);

create table if not exists rereads (
    id bigint auto_increment primary key,
    impressions varchar(5000),
    start_date date,
    finish_date date,
    book_id bigint,
    created_at TIMESTAMP default current_timestamp,
    updated_at TIMESTAMP default current_timestamp,
    foreign key rereads_booksId_fk (book_id) references books(id)
);

create table if not exists authors_books (
    id bigint auto_increment primary key,
    pseudonym varchar(100),
    author_id bigint,
    book_id bigint,
    created_at TIMESTAMP default current_timestamp,
    updated_at TIMESTAMP default current_timestamp,
    foreign key authors_books__authorsId_fk (author_id) references authors(id),
    foreign key authors_books__booksId_fk (book_id) references books(id)
);

create table if not exists books_genres (
    id bigint auto_increment primary key,
    book_id bigint,
    genre_id bigint,
    created_at TIMESTAMP default current_timestamp,
    updated_at TIMESTAMP default current_timestamp,
    foreign key books_genres__booksId_fk (book_id) references books(id),
    foreign key books_genres__genreId_fk (genre_id) references genres(id)
);