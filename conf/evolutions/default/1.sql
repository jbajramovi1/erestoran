 # --- !Ups
create table account(
id bigint not null,
email varchar(255) not null,
password varchar(255) not null,
role bigint not null,
phone varchar(255),
country varchar(255),
city varchar(255),
firstName varchar(255),
lastName varchar(255),
constraint pk_test primary key (id)) with (OIDS=false);

 # --- !Downs
 drop table if exists account;