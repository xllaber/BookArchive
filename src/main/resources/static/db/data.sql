use book_archive;

insert into genres (id, name)
values (1, 'FANTASÍA'), (2, 'SCI-FI'), (3, 'FANTASÍA OSCURA'), (4, 'ROMANCE'), (5, 'MISTERIO'), (6, 'ÉPICA'), (7, 'NO FICCIÓN'), (8, 'FANTASÍA URBANA');

insert into saga(name, publish_start, publish_end)
values ('Sun Eater', 2018, null), ('Green Bone Saga', 2017, 2022), ('Mistborn', 2006, null), ('The Powder Mage', 2013, 2015), ('Malazan Book of the Fallen', 1999, 2011),
       ('The Age of Madness', 2019, 2021), ('The Wheel of Time', 1990, 2013), ('The Expanse', 2011, 2021);

insert into authors(name, country, birth_year, death_year)
values ('Christopher Ruocchio', 'USA', 1993, null), ('Brandon Sanderson', 'USA', 1975, null), ('Brian McClellan', 'USA', 1986, null), ('Steven Erikson', 'Canadá', 1959, null),
       ('Joe Abercrombie', 'UK', 1974, null), ('Robert Jordan', 'USA', 1948, 2007), ('Daniel Abraham', 'USA', 1969, null), ('Ty Frank', 'USA', 1969, null);

insert into books(title, pages, saga_num, fave, publish_year)
values ('Empire of Silence', 763, 1, false, 2018), ('The Lesser Devil', 205, 1.5, false, 2020), ('Promise of Blood', 561, 1, false, 2013),
       ('Crimson Campaign', 594, 2, false, 2014), ('Autumn Republic', 618, 3, false, 2015), ('Gardens of the Moon', 772, 1, false, 1999),
       ('Deadhouse Gates', 847, 2, false, 2000), ('A Little Hatred', 513, 1, false, 2019), ('Troubles with Peace', 513, 2, false, 2020),
       ('The Wisdom of Crowds', 520, 3, false, 2021), ('The Eye of the World', 751, 1, false, 1990), ('The great Hunt', 671, 2, false, 1990),
       ('The Dragon Reborn', 658, 3, false, 1991), ('The Shadow Rising', 1032, 4, false, 1992), ('The Fires of Heaven', 913, 5, false, 1993),
       ('Lord of Chaos', 1036, 6, false, 1994), ('A Crown of Swords', 882, 7, false, 1996), ('The Path of Daggers', 656, 8, false, 1998),
       ("Winter's Heart", 705, 9, false, 2000), ('Crossroads of Twilight', 688, 10, false, 2003), ('New Spring', 398, 0.5, false, 2004),
       ('Knife of Dreams', 886, 11, true, 2005), ('The Gathering Storm', 861, 12, false, 2009), ('Towers of Midnight', 977, 13, false, 2010),
       ('A Memory of Light', 1025, 14, true, 2013), ('The Final Empire', 672, 1, false, 2006), ('The Well of Ascension', 800, 2, false, 2007),
       ('The Hero of Ages', 848, 3, true, 2008), ('The Eleventh Metal', 20, 0.5, false, 2011), ('Mistborn: Secret History', 151, 3.5, false, 2016),
       ('The Alloy of Law', 336, 4, false, 2011), ('Shadows of Self', 383, 5, false, 2015), ('The Bands of Mourning', 448, 6, false, 2016),
       ('The Lost Metal', 513, 7, false, 2022), ('Tress of the Emerald Sea', 374, null, false, 2023), ("Caliban's War", 605, 2, false, 2012),
       ("The Frugal Wizard's Handbook for Surviving Medieval England", 303, null, false, 2023), ('Leviathan Wakes', 577, 1, false, 2011);

insert into rereads(impression, start_date, finish_date)
values ('El principio de una ópera espacial que promete mucho. Narrado por el protagonista después de toda la historia, ha conseguido que ame u odie a todos los personajes. PD: ¿Por qué todo el mundo está buenísimo?',
        2023-12-24, 2024-01-01),
    ('Una novela corta sobre qué pasó en los años desde que Hadrian huyó de Delos. Le da personalidad al hermano pequeño pero el autor brilla mucho más cuando escribe en 1a persona. No es importante para la saga.',
     2024-01-01, 2024-01-02),
    ('Tan frenético o más que los dos anteriores. Un final fantástico para una saga fantástica. Los personajes son de lo más humano que he leído en mucho tiempo y las escenas de accion son increíbles. Recomendadisima',
     2023-12-10, 2023-12-24),
    ('JODER, lo que me ha costado. \nSi el primero era denso, este es otra vez lo mismo pero con más páginas. Cuando aún no te has hecho al mundo del 1r libro te lleva a un lugar y personajes distintos.',
     2023-10-16, 2023-12-9),
    ('Aunque recordaba cosas de la primera lectura, sigue siendo un libro muy denso y difícil de seguir. Aún así tengo muchas ganas de empezar el nuevo viaje que supone esta saga.',
     2023-09-11, 2023-10-09),
    ('Denso como su puta madre pero deseando conocer el mundo de Malaz', 2021-04-21, 2021-05-10);