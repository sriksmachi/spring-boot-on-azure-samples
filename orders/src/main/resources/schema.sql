drop table if exists orders;
create table orders
(
  order_id INT NOT NULL IDENTITY PRIMARY KEY,
  alias varchar(10) not null,
  address varchar(255) not null,
  phone  varchar(25) not null,
  order_date varchar(20) not null,
  orderDescription varchar(200) not null,
  restaurant varchar(100) not null
);