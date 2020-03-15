drop table if exists orders;
create table orders
(
  order_id INT NOT NULL IDENTITY PRIMARY KEY,
  user_id INT,
  address varchar(255) not null,
  phone  varchar(25) not null,
  order_date varchar(20) not null
);