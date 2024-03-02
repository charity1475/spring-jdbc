delete from customer_profile;
delete from customer;
insert into customer(id, name) values (1, 'Hillary Hajji');
insert into customer(id, name) values (2, 'Walter Charles');

insert into customer_profile(customer, username, password) values (1, 'hillary@gogo.com', 'hillary12');
insert into customer_profile(customer, username, password) values (2, 'walter@gogo.com', 'walter12');
