#user_transaction_demo
use practice;
create table user_transaction_demo(
    id varchar(50) primary key ,
    username varchar(100),
    age int
) engine = innodb