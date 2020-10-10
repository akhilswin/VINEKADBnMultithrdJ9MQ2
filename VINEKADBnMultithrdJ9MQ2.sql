create database ContactDB;
use ContactDB;

create table Contact 
(
	firstName char(10),
	lastName char(10),
	email char(20),
	phoneNo char(10)
);

insert into Contact
values('Rajesh','Singh','rajesh@gmail.com','9999765654');
