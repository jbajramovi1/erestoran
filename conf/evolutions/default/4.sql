# --- !Ups
create table reservation(
id bigint not null,
tables bigint,
reservation_date date ,
phone varchar(255),
account_id bigint not null,
restaurant_id bigint not null,
constraint reservation_pk_test primary key (id),
constraint reservation_restaurant_id_fk FOREIGN KEY (restaurant_id) references restaurant(id) match simple on update no action on delete cascade,
constraint reservation_user_id_fk FOREIGN KEY (account_id) references account(id) match simple on update no action on delete cascade);

 # --- !Downs
 drop table if exists reservation;
