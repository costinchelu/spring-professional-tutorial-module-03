# drop database if exists `spring_tutorial_employees`;
# drop database if exists `spring_tutorial_products`;
# drop user if exists `user`@'localhost';
#
# create database `spring_tutorial_employees`;
# create database `spring_tutorial_products`;
#
# create user `user`@'192.168.1.170' identified by 'pass';
# grant all privileges on `spring_tutorial_employees`.* TO `user`@'192.168.1.170';
# grant all privileges on `spring_tutorial_products`.* TO `user`@'192.168.1.170';
#
# create table `spring_tutorial_employees`.`employee`(
#     id int,
#     firstname varchar(32),
#     lastname varchar(32),
#     email varchar(32),
#     phonenumber varchar(32),
#     hiredate date,
#     salary int
# );
#
# create table `spring_tutorial_products`.`product`(
#     id int,
#     name varchar(32),
#     quantity int,
#     price float,
#     available boolean
# );