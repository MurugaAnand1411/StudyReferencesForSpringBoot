drop database if exists sales;

create database sales;

use sales;


CREATE TABLE role (
	id bigint(20) NOT NULL auto_increment primary key,
	name varchar(255) DEFAULT NULL
);


CREATE TABLE user (
	id bigint(20) NOT NULL auto_increment primary key,
	email varchar(255) DEFAULT NULL unique,
	firstName varchar(255) DEFAULT NULL,
	lastName varchar(255) DEFAULT NULL,
	password varchar(255) DEFAULT NULL
);

CREATE TABLE user_role (
	user_id bigint(20) NOT NULL references user(id),
	role_id bigint(20) NOT NULL references role(id)
);

CREATE TABLE product (
	id int(11) NOT NULL AUTO_INCREMENT primary key,
	name varchar(45) NOT NULL,
	brand varchar(45) NOT NULL,
	madein varchar(45) NOT NULL,
	price float NOT NULL
);


CREATE TABLE sale (
    id int(11) NOT NULL AUTO_INCREMENT primary key,
    product_id int(11) NOT NULL references product(id),
    user_id int(11) NOT NULL references user(id),
    quantity int NOT NULL,
    amount double NOT NULL
);

insert into role (name) values ('ROLE_USER');
insert into role (name) values ('ROLE_ADMIN');