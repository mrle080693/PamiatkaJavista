CREATE DATABASE pamiatka_javista;

CREATE TABLE comments
(
  id serial primary key,
  page_name varchar(44),
  user_name    varchar(22),
  comment varchar(1000)
);

insert into comments (page_name, user_name, comment) values ('first-article', 'Trol', 'Huinia');
