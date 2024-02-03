use book_archive;

insert into genres (name)
values ('FANTASÍA'), ('SCI-FI'), ('FANTASÍA OSCURA'), ('ROMANCE'), ('MISTERIO'), ('ÉPICA'), ('NO FICCIÓN'), ('FANTASÍA URBANA'),
       ('AVENTURA'), ('ACCIÓN'), ('HORROR'), ('COMEDIA'), ('ATRACO');

insert into sagas(name, publish_start, publish_end)
values ('Sun Eater', 2018, null), ('Green Bone Saga', 2017, 2022), ('Mistborn', 2006, null), ('The Powder Mage', 2013, 2015), ('Malazan Book of the Fallen', 1999, 2011),
       ('The Age of Madness', 2019, 2021), ('The Wheel of Time', 1990, 2013), ('The Expanse', 2011, 2021);

insert into authors(name, country, birth_year, death_year)
values ('Christopher Ruocchio', 'USA', 1993, null), ('Brandon Sanderson', 'USA', 1975, null), ('Brian McClellan', 'USA', 1986, null), ('Steven Erikson', 'Canadá', 1959, null),
       ('Joe Abercrombie', 'UK', 1974, null), ('Robert Jordan', 'USA', 1948, 2007), ('Daniel Abraham', 'USA', 1969, null), ('Ty Frank', 'USA', 1969, null);

insert into books(title, pages, saga_num, fave, publish_year)
values ('Empire of Silence', 763, 1, false, 2018), ('The Lesser Devil', 205, 1.5, false, 2020), ('Promise of Blood', 561, 1, false, 2013),
       ('Crimson Campaign', 594, 2, false, 2014), ('Autumn Republic', 618, 3, false, 2015), ('Gardens of the Moon', 772, 1, false, 1999),
       ('Deadhouse Gates', 847, 2, false, 2000), ('A Little Hatred', 472, 1, false, 2019), ('Troubles with Peace', 513, 2, false, 2020),
       ('The Wisdom of Crowds', 520, 3, false, 2021), ('The Eye of the World', 751, 1, false, 1990), ('The great Hunt', 671, 2, false, 1990),
       ('The Dragon Reborn', 658, 3, false, 1991), ('The Shadow Rising', 1032, 4, false, 1992), ('The Fires of Heaven', 913, 5, false, 1993),
       ('Lord of Chaos', 1036, 6, false, 1994), ('A Crown of Swords', 882, 7, false, 1996), ('The Path of Daggers', 656, 8, false, 1998),
       ('Winter\'s Heart', 705, 9, false, 2000), ('Crossroads of Twilight', 688, 10, false, 2003), ('New Spring', 398, 0.5, false, 2004),
       ('Knife of Dreams', 886, 11, true, 2005), ('The Gathering Storm', 861, 12, false, 2009), ('Towers of Midnight', 977, 13, false, 2010),
       ('A Memory of Light', 1025, 14, true, 2013), ('The Final Empire', 672, 1, false, 2006), ('The Well of Ascension', 800, 2, false, 2007),
       ('The Hero of Ages', 848, 3, true, 2008), ('The Eleventh Metal', 20, 0.5, false, 2011), ('Mistborn: Secret History', 151, 3.5, false, 2016),
       ('The Alloy of Law', 336, 4, false, 2011), ('Shadows of Self', 383, 5, false, 2015), ('The Bands of Mourning', 448, 6, false, 2016),
       ('The Lost Metal', 513, 7, false, 2022), ('Tress of the Emerald Sea', 374, null, false, 2023), ('Caliban\'s War', 605, 2, false, 2012),
       ('The Frugal Wizard\'s Handbook for Surviving Medieval England', 303, null, false, 2023), ('Leviathan Wakes', 577, 1, false, 2011);

insert into pseudonyms(pseudonym)
values ('James S.A. Corey');

insert into rereads(impressions, start_date, finish_date)
values ('El principio de una ópera espacial que promete mucho. Narrado por el protagonista después de toda la historia, ha conseguido que ame u odie a todos los personajes. PD: ¿Por qué todo el mundo está buenísimo?',
        '2023-12-24', '2024-01-01'),
    ('Una novela corta sobre qué pasó en los años desde que Hadrian huyó de Delos. Le da personalidad al hermano pequeño pero el autor brilla mucho más cuando escribe en 1a persona. No es importante para la saga.',
     '2024-01-01', '2024-01-02'),
    ('Tan frenético o más que los dos anteriores. Un final fantástico para una saga fantástica. Los personajes son de lo más humano que he leído en mucho tiempo y las escenas de accion son increíbles. Recomendadisima',
     '2023-12-10', '2023-12-24'),
    ('JODER, lo que me ha costado.<br>Si el primero era denso, este es otra vez lo mismo pero con más páginas. Cuando aún no te has hecho al mundo del 1r libro te lleva a un lugar y personajes distintos.',
     '2023-10-16', '2023-12-9'),
    ('Aunque recordaba cosas de la primera lectura, sigue siendo un libro muy denso y difícil de seguir. Aún así tengo muchas ganas de empezar el nuevo viaje que supone esta saga.',
     '2023-09-11', '2023-10-09'),
    ('Denso como su puta madre pero deseando conocer el mundo de Malaz', '2021-04-21', '2021-05-10'),
    ('El ritmo de esta entrega es mucho mejor que el de la anterior, pero esta vez me da la impresión de que algunos personajes se han desarrollado mucho más que otros pese a tener una importancia similar.',
     '2023-07-20', '2023-07-31'),
    ('Este libro es acción y combate sin parar, de principio a fin. Hasta el punto que a veces cuesta seguirle el ritmo.<br>Los magos se esnifan la pólvora como si fuese cocaína, con sus efectos secundarios incluidos.',
     '2023-05-07', '2023-06-05'),
    ('Trata temas muy políticos y polémicos como el machismo o el clasismo maravillosamente gracias a la crudeza y explicidad del género grimdark que Abercrombie domina a la perfección.<br>Tremenda portada btw',
     '2022-07-22', '2022-08-03'),
    ('De nuevo, Joe Abercrombie es capaz de crear los personajes más desdeñables y asquerosos posibles y hacerte apreciarlos y respetarlos sin pensarlo dos veces',
     '2022-08-04', '2022-08-28'),
    ('Un gran clímax para una gran historia. El desarrollo de personajes es brutal y la ironía de la historia y los giros de guión hacen de este libro una obra maestra.',
     '2022-08-29', '2022-09-20'),
    ('The Eye of the World', '2021-05-22', '2021-06-27'), ('The Great Hunt', '2021-06-28', '2021-08-10'), ('The Dragon Reborn', '2021-08-11', '2021-09-10'),
    ('The Shadow Rising', '2021-09-11', '2021-10-15'), ('The Fires oh Heavens', '2021-10-16', '2021-11-17'), ('Lord of Chaos', '2021-11-18', '2021-12-21'),
    ('Se nota que aquí el foco cambia hacia el World Building a través de los puntos de vista de personajes muy secundarios.',
     '2021-12-22', '2022-01-13'),
    ('(falta el prólogo del siguiente libro, unas 100/150 pág mínimo, y el glosario del final está incompleto)',
     '2022-01-14', '2022-02-06'),
    ('Vaya final. Encima con la OST de Elden Ring de fondo. Los pelos  de punta y la piel de gallina.',
     '2022-02-07', '2022-03-02'),
    ('Hasta donde he leído, el peor de la saga. No pasa nada realmente importante hasta las últimas 2 o 3 páginas y los capítulos son larguísimos.<br>Aún así, es el que más rápido he leído',
     '2022-03-03', '2022-03-13'),
    ('Muy interesante y revelador conocer el pasado de dos personajes tan importantes e icónicos de la saga.',
     '2022-03-14', '2022-03-17'),
    ('Por fin ha conseguido pasar de una gran saga a ser una de las mejores que leeré jamás. Ha conseguido hacerme llorar de alegría, temblar de nervios y enfadarme de rabia. Una excelente despedida de Jordan de su obra maestra.',
     '2022-03-18', '2022-03-29'),
    ('Se nota claramente el cambio de estilo a Sanderson con capítulos mucho más cortos, cómo trata los PoV y cómo maneja los tiempos dentro de la histora. All in all un gran libro.',
     '2022-03-29', '2022-04-08'),
    ('El PoV de un personaje no concuerda temporalmente con los demás y eso confunde un poco hasta que te das cuenta. Cierra todas la líneas para preparar el FINAL. En resumen: Cliffhanger, el libro.',
     '2022-04-09', '2022-04-19'),
    ('¿Por qué no puedo parar de llorar?', '2022-04-20', '2022-04-29'),
    ('The Final Empire', null, null), ('The Well of Ascension', null, null), ('The Hero of Ages', null, null),
    ('The Eleventh Metal', null, null), ('Mistborn: Secret History', null, null), ('The Alloy of Law', null, null),
    ('Shadows of Self', null, null), ('The Bands of Mourning', null, null),
    ('Uno de los mejores libros del Cosmere hasta la fecha.<br>Por fin se hace clara referencia a la existencia de otros planetas y fuerzas que existen en el Cosmere y los personajes son conscientes de ello.',
     '2022-11-16', '2022-11-27'),
    ('La típica historia de la dama atrapada en la torre de la malvada bruja pero es la dama quien salva al príncipe, haciéndose pirata por el camino.<br>Vaya bomba de info del Cosmere, por cierto.',
     '2023-01-01', '2023-01-04'),
    ('Único proyecto secreto fuera del Cosmere. Un soplo de aire fresco para cambiar el estilo de Brandon aunque es muy corto para explorar bien todo lo que presenta',
     '2023-04-11', '2023-04-20'),
    ('Esto solo es una muestra de un libro escrito por un atuor con pseudónimo', null, null),
    ('Esto solo es una muestra de un libro escrito por un atuor con pseudónimo 2', null, null);