insert into authors_books (author_id, book_id, pseudonym)
values (1, 1, null), (1, 2, null), (2, 23, null), (2, 24, null), (2, 25, null), (2, 26, null), (2, 27, null), (2, 28, null),
       (2, 29, null), (2, 30, null), (2, 31, null), (2, 32, null), (2, 33, null), (2, 34, null), (2, 35, null), (2, 37, null),
       (3, 3, null), (3, 4, null), (3, 5, null), (4, 6, null), (4, 7, null), (5, 8, null), (5, 9, null), (5, 10, null),
       (6, 11, null), (6, 12, null), (6, 13, null), (6, 14, null), (6, 15, null), (6, 16, null), (6, 17, null), (6, 18, null),
       (6, 19, null), (6, 20, null), (6, 21, null), (6, 22, null), (6, 23, null), (6, 24, null), (6, 25, null), (7, 36, 'James S.A. Corey'),
       (7, 38, 'James S.A. Corey'), (8, 38, 'James S.A. Corey'), (8, 36, 'James S.A. Corey');

insert into books_genres (book_id, genre_id)
values (1, 2), (1, 6), (1, 11), (1, 9), (2, 2), (2, 6), (2, 10), (3, 1),(3, 10), (4, 1), (4, 10), (5, 1), (5, 10), (6, 1), (6, 6),
       (6, 10), (7, 1), (7, 6), (7, 10), (8, 1), (8, 3), (8, 9), (9, 1), (9, 3), (9, 9), (10, 1), (10, 3), (10, 9), (11, 1), (11, 6),
       (11, 9), (11, 10), (12, 1), (12, 6), (12, 9), (12, 10), (13, 1), (13, 6), (13, 9), (13, 10), (14, 1), (14, 6), (14, 9),
       (14, 10), (15, 1), (15, 6), (15, 9), (15, 10), (16, 1), (16, 6), (16, 9), (16, 10), (17, 1), (17, 6), (17, 9), (17, 10),
       (18, 1), (18, 6), (18, 9), (18, 10), (19, 1), (19, 6), (19, 9), (19, 10), (20, 1), (20, 6), (20, 9), (20, 10), (21, 1),
       (21, 6), (21, 9), (21, 10), (22, 1), (22, 6), (22, 9), (22, 10), (23, 1), (23, 6), (23, 9), (23, 10), (24, 1), (24, 6),
       (24, 9), (24, 10), (25, 1), (25, 6), (25, 9), (25, 10), (26, 1), (26, 6), (26, 13), (27, 1), (27, 6), (27, 9), (27, 10),
       (28, 1), (28, 6), (28, 9), (28, 10), (29, 1), (29, 6), (29, 10), (30, 1), (30, 6), (30, 10), (31, 1), (31, 6), (31, 9),
       (31, 10), (32, 1), (32, 6), (32, 9), (32, 10), (33, 1), (33, 6), (33, 9), (33, 10), (34, 1), (34, 6), (34, 9), (34, 10),
       (35, 1), (35, 4), (35, 9), (35, 12), (36, 2), (37, 1), (37, 2), (37, 12), (37, 9), (38, 2);

update books set saga_id = 1 where id = 1;
update books set saga_id = 1 where id = 2;
update books set saga_id = 3 where id = 26;
update books set saga_id = 3 where id = 27;
update books set saga_id = 3 where id = 28;
update books set saga_id = 3 where id = 29;
update books set saga_id = 3 where id = 30;
update books set saga_id = 3 where id = 31;
update books set saga_id = 3 where id = 32;
update books set saga_id = 3 where id = 33;
update books set saga_id = 3 where id = 34;
update books set saga_id = 4 where id = 3;
update books set saga_id = 4 where id = 4;
update books set saga_id = 4 where id = 5;
update books set saga_id = 5 where id = 6;
update books set saga_id = 5 where id = 7;
update books set saga_id = 6 where id = 8;
update books set saga_id = 6 where id = 9;
update books set saga_id = 6 where id = 10;
update books set saga_id = 7 where id = 11;
update books set saga_id = 7 where id = 12;
update books set saga_id = 7 where id = 13;
update books set saga_id = 7 where id = 14;
update books set saga_id = 7 where id = 15;
update books set saga_id = 7 where id = 16;
update books set saga_id = 7 where id = 17;
update books set saga_id = 7 where id = 18;
update books set saga_id = 7 where id = 19;
update books set saga_id = 7 where id = 20;
update books set saga_id = 7 where id = 21;
update books set saga_id = 7 where id = 22;
update books set saga_id = 7 where id = 23;
update books set saga_id = 7 where id = 24;
update books set saga_id = 7 where id = 25;
update books set saga_id = 8 where id = 36;
update books set saga_id = 8 where id = 38;

update rereads set book_id = 1 where id = 1;
update rereads set book_id = 2 where id = 2;
update rereads set book_id = 5 where id = 3;
update rereads set book_id = 7 where id = 4;
update rereads set book_id = 6 where id = 5;
update rereads set book_id = 6 where id = 6;
update rereads set book_id = 4 where id = 7;
update rereads set book_id = 3 where id = 8;
update rereads set book_id = 8 where id = 9;
update rereads set book_id = 9 where id = 10;
update rereads set book_id = 10 where id = 11;
update rereads set book_id = 11 where id = 12;
update rereads set book_id = 12 where id = 13;
update rereads set book_id = 13 where id = 14;
update rereads set book_id = 14 where id = 15;
update rereads set book_id = 15 where id = 16;
update rereads set book_id = 16 where id = 17;
update rereads set book_id = 17 where id = 18;
update rereads set book_id = 18 where id = 19;
update rereads set book_id = 19 where id = 20;
update rereads set book_id = 20 where id = 21;
update rereads set book_id = 21 where id = 22;
update rereads set book_id = 22 where id = 23;
update rereads set book_id = 23 where id = 24;
update rereads set book_id = 24 where id = 25;
update rereads set book_id = 25 where id = 26;
update rereads set book_id = 26 where id = 27;
update rereads set book_id = 27 where id = 28;
update rereads set book_id = 28 where id = 29;
update rereads set book_id = 29 where id = 30;
update rereads set book_id = 30 where id = 31;
update rereads set book_id = 31 where id = 32;
update rereads set book_id = 32 where id = 33;
update rereads set book_id = 33 where id = 34;
update rereads set book_id = 34 where id = 35;
update rereads set book_id = 35 where id = 36;
update rereads set book_id = 37 where id = 37;
update rereads set book_id = 36 where id = 38;
update rereads set book_id = 38 where id = 39;








