# Explique o conceito de normalização e para que é usado.

Normalização é o processo de organização de dados em um banco de dados. Isso inclui a criação de tabelas e o estabelecimento de relações entre essas tabelas de acordo com as regras projetadas para proteger os dados e tornar o banco de dados mais flexível, eliminando a redundância e a dependência inconsistente.

# Adicione um filme à tabela de filmes

````
insert into movies (title, rating, awards, release_date, length) values ('O último mestre do Ar', 7.9, 3, date('2020-12-12'), 90);

````

# Adicione um gênero à tabela de gêneros.

````
insert into genres (name, ranking, active) values ('Gênero', '20', 1);
````

# Associe o filme do Ex 2. ao gênero criado no Ex. 3.

````
update movies set genre_id = 14 where (id = 22);
````

# Modifique a tabela de atores para que pelo menos um ator adicione como favorito o filme adicionado no Ex. 2.

````
update actors set favorite_movie_id = 22 where (id = 1);
````

# Crie uma cópia temporária da tabela de filmes.
````
CREATE TEMPORARY TABLE temp_movies
SELECT * FROM movies;
````
# Elimine desta tabela temporária todos os filmes que ganharam menos de 5 prêmios.

````
SET SQL_SAFE_UPDATES = 0;
delete from temp_movies where awards < 5;
select * from temp_movies;
````

# Obtenha a lista de todos os gêneros que possuem pelo menos um filme.

````
select g.name, count(g.id) as total from genres as g inner join movies as m on (m.genre_id = g.id) group by (g.name) having total >= 1;
````

# Obtenha a lista de atores cujo filme favorito ganhou mais de 3 prêmios.

````
select a.first_name, m.title, m.awards from actors as a inner join movies as m on (a.favorite_movie_id = m.id) having m.awards >= 3;
````

# Use o plano de explicação para analisar as consultas nos Ex. 6 e 7.

````
EXPLAIN delete from temp_movies where awards < 5;
````

# O que são os índices? Para que servem?

Um índice permite que o conjunto das linhas de uma tabela que satisfazem determinado critério seja localizado rapidamente. Os índices são utilizados para encontrar registros com um valor específico de uma coluna rapidamente.

# Crie um índice sobre o nome na tabela de filmes.
````
CREATE INDEX movies_title_index ON movies(title);
````

# Verifique se o índice foi criado corretamente.

````
SHOW INDEX FROM movies;
````
