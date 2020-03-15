drop table if exists users;
create table users
(
  user_id INT NOT NULL IDENTITY PRIMARY KEY,
  firstname varchar(255) not null,
  lastname  varchar(255) not null,
  email varchar(20) not null
);