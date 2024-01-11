drop database if exists book_archive;
create database book_archive;

create table saga (
    id bigint auto_increment primary key,
    name varchar(100),
    publish_start date not null,
    publish_end date
);

create table authors (
    id bigint auto_increment primary key,
    name varchar(100) not null,
    country varchar(100),
    birth_year date not null,
    death_year date,
    image varchar(100)
);

create table authors_books (
    id bigint auto_increment primary key,
    pseudonym varchar(100),
    author_id bigint not null,
    book_id bigint not null
);
alter table authors_books add constraint authors_books__authors___fk foreign key (author_id) references authors(id)
    on delete set null;
alter table authors_books add constraint authors_books__books___fk foreign key (book_id) references books(id)
    on delete cascade;

create table rereads (
    id bigint auto_increment primary key,
    impression text not null,
    start_date date,
    finish_date date,
    book_id bigint not null
);
alter table rereads add constraint rereads_book_fk foreign key (book_id) references books(id)
    on delete cascade;

create table genres (
    id bigint auto_increment primary key,
    name varchar(100)
);

create table books_genres (
    id bigint auto_increment primary key,
    book_id bigint not null,
    genre_id bigint not null
);
alter table books_genres add constraint books_genres__genres___fk foreign key (genre_id) references genres(id)
    on delete cascade;
alter table books_genres add constraint books_genres__books___fk foreign key (book_id) references books(id)
    on delete cascade;

create table books (
    id bigint auto_increment primary key,
    title varchar(100) not null,
    pages int not null,
    saga_num int,
    fave boolean,
    publish_date date not null,
    image varchar(100),
    saga_id bigint,
    genre_id bigint
);
alter table books add constraint books_sagas__fk foreign key (saga_id) references saga (id)
    on delete set null;