create database [login] 
go 
use [login]
go 
create table account (
	id INT IDENTITY(1,1) PRIMARY KEY,
	username nvarchar(20),
	[password] nvarchar(20),
	email nvarchar(30),
	phone int,
	isAdmin bit
);

select *from account
insert into account 
values ('abc','123','abc@gmail.com',0123456789,1);