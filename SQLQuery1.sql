create database testlogin
go 
use testlogin
go 

create table account(
	[user] nvarchar(20),
	pass nvarchar(20)
)
insert into account
values ('abc','123'),
